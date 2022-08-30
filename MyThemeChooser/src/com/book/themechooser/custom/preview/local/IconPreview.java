package com.book.themechooser.custom.preview.local;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.book.themechooser.R;
import com.book.themechooser.ThemeApplication;
import com.book.themechooser.newmechanism.ApplyThemeHelp;
import com.book.themechooser.newmechanism.NewMechanismHelp;
import com.book.themechooser.preview.slide.local.PreviewIconsActivity;
import com.book.themes.CustomType;
import com.book.themes.ThemeManager;
import com.book.themes.provider.ThemeItem;
import com.book.themes.provider.ThemeItem.PreviewsType;
import com.book.themes.provider.Themes;

import util.ThemeUtil;

public class IconPreview extends PreviewIconsActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected void doApply(ThemeItem bean) {
        ThemeItem appliedTheme = Themes.getAppliedTheme(this);
        if (null == appliedTheme) {
            return;
        }
        Uri uri = Themes.getThemeUri(this, appliedTheme.getPackageName(), appliedTheme.getThemeId());
        appliedTheme.close();

        Intent i = new Intent(ThemeManager.ACTION_CHANGE_THEME, uri);
        i.putExtra(ThemeManager.EXTRA_EXTENDED_THEME_CHANGE, true);
        i.putExtra(ThemeManager.EXTRA_ICONS_URI, bean.getIconsUri());
        if (bean.getPackageName().equals("com.book.theme.bookDefaultTheme")
                && bean.getThemeId().equals("bookDefaultTheme")) {
            i.putExtra(ThemeManager.DEFAULT_ICON, true);
        }
        i.putExtra(CustomType.EXTRA_NAME, CustomType.DESKTOP_ICON_TYPE);
        ThemeUtil.isChangeIcon = true;
        ApplyThemeHelp.changeTheme(this, i);

        ThemeApplication.sThemeStatus.setAppliedThumbnail(NewMechanismHelp.getApplyThumbnails(this
                , bean, PreviewsType.LAUNCHER_ICONS), com.book.themechooser.ThemeStatus.THEME_TYPE_ICONS);
    }

    private String parseUriNullSafe(Uri uri) {
        return (uri != null ? uri.toString() : null);
    }

    public ImageAdapter initAdapter() {
        return new ImageAdapter(this, mThemeItem, PreviewsType.LAUNCHER_ICONS);
    }

    @Override
    protected String getDeleteUsingThemeToastMessage() {
        return getString(R.string.delete_using_theme_icon);
    }

    @Override
    protected String getDeleteToast() {
        return getString(R.string.icons_delete_success);
    }
}
