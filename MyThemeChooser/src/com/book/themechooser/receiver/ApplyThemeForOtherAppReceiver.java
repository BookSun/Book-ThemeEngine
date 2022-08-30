package com.book.themechooser.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import com.book.themechooser.ThemeApplication;
import com.book.themechooser.ThemeStatus;
import com.book.themechooser.newmechanism.ApplyThemeHelp;
import com.book.themes.CustomType;
import com.book.themes.ThemeManager;
import com.book.themes.provider.PackageResources;
import com.book.themes.provider.ThemeItem;
import com.book.themes.provider.Themes;

import util.ThemeUtil;

public class ApplyThemeForOtherAppReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        int type = intent.getIntExtra("theme_type", -1);
        String pkgName = intent.getStringExtra("pkgName");
        String themeId = intent.getStringExtra("themeId");
        ThemeItem mThemeItem = Themes.getTheme(context, pkgName, themeId);
        if (type == CustomType.DESKTOP_WALLPAPER_TYPE) {
            try {
                context.setWallpaper(ThemeUtil.CreateCropBitmap(context.getContentResolver()
                        .openInputStream(mThemeItem.getWallpaperUri(context))));
                ThemeApplication.sThemeStatus.setAppliedThumbnail(mThemeItem.getPackageName()
                        , com.book.themechooser.ThemeStatus.THEME_TYPE_WALLPAPER);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (type == CustomType.LOCKSCREEN_WALLPAPER_TYPE) {
            ThemeItem appliedTheme = Themes.getAppliedTheme(context);
            if (null == appliedTheme) {
                return;
            }
            Uri uri = Themes.getThemeUri(context, appliedTheme.getPackageName(), appliedTheme.getThemeId());
            ThemeUtil.supportsLockWallpaper(context);
            Intent i = new Intent(ThemeManager.ACTION_CHANGE_THEME, uri);
            i.putExtra(ThemeManager.EXTRA_EXTENDED_THEME_CHANGE, true);
            i.putExtra(ThemeManager.EXTRA_LOCK_WALLPAPER_URI, PackageResources.convertFilePathUri(mThemeItem.getLockWallpaperUri(context)));
            i.putExtra(CustomType.EXTRA_NAME, CustomType.LOCKSCREEN_WALLPAPER_TYPE);
            ApplyThemeHelp.changeTheme(context, i);
            ThemeApplication.sThemeStatus.setAppliedPkgName(mThemeItem.getPackageName()
                    , com.book.themechooser.ThemeStatus.THEME_TYPE_LOCK_WALLPAPER);

        } else {
            Uri uri = mThemeItem.getUri(context);
            Intent i = new Intent(ThemeManager.ACTION_CHANGE_THEME, uri);
            if (mThemeItem.hasThemePackageScope()) {
                i.putExtra(ThemeManager.EXTRA_SYSTEM_APP, true);
            }
            if (mThemeItem.getFontUril() != null) {
                ThemeUtil.isKillProcess = true;
            }
            if (mThemeItem.getIconsUri() != null) {
                ThemeUtil.isChangeIcon = true;
            }
            ApplyThemeHelp.changeTheme(context, i);

            ThemeApplication.sThemeStatus.setAppliedPkgName(mThemeItem.getPackageName(),
                    ThemeStatus.THEME_TYPE_PACKAGE);
        }
    }

}
