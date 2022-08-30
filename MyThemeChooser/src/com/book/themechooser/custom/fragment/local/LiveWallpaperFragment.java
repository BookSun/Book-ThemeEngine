package com.book.themechooser.custom.fragment.local;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.book.themechooser.R;
import com.book.themechooser.ThemeApplication;
import com.book.themechooser.ThemeStatus;
import com.book.themechooser.custom.preview.local.LiveWallpaperPreview;
import com.book.themes.provider.ThemeItem;
import com.book.themes.provider.ThemeItem.PreviewsType;

public class LiveWallpaperFragment extends LocalBase {
    private static final int REQUEST_PREVIEW = 100;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLayoutRes = R.layout.live_wallpaper_list;
        mItemLayoutResource = R.layout.live_wallpaper_entry;
    }

    @Override
    protected int getType() {
        return LIVE_WALLPAPER_TYPE;
    }

    @Override
    public void startActivity(View v) {
        Intent intent = new Intent().setClass(
                getActivity(), LiveWallpaperPreview.class).setData((Uri) v.getTag());
        getActivity().startActivity(intent);
    }

    @Override
    public boolean isApplied(ThemeItem themeItem) {
        return ThemeApplication.sThemeStatus.isApplied(themeItem.getPackageName() + themeItem.getThemeId()
                , ThemeStatus.THEME_TYPE_LIVEWALLPAPER);
    }

    @Override
    public PreviewsType getThumbnailType() {
        return PreviewsType.LIVE_WALLPAPER;
    }
}
