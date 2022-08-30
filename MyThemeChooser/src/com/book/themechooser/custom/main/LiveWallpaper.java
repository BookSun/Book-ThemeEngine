package com.book.themechooser.custom.main;

import android.app.Fragment;

import com.book.themechooser.custom.CustomBase;
import com.book.themechooser.custom.fragment.local.LiveWallpaperFragment;
import com.book.themechooser.custom.fragment.online.OnLineLiveWallpaperFragment;

public class LiveWallpaper extends CustomBase {

    @Override
    public Fragment getLocalFragment() {
        return new LiveWallpaperFragment();
    }

    @Override
    public Fragment getOnLineFragment() {
        return new OnLineLiveWallpaperFragment();
    }
}
