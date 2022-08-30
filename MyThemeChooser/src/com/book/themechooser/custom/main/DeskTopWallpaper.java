package com.book.themechooser.custom.main;

import android.app.Fragment;

import com.book.themechooser.custom.CustomBase;
import com.book.themechooser.custom.fragment.local.DeskTopWallpaperFragment;
import com.book.themechooser.custom.fragment.online.OnLineDeskTopWallpaperFragment;

public class DeskTopWallpaper extends CustomBase {

    @Override
    public Fragment getLocalFragment() {
        return new DeskTopWallpaperFragment();
    }

    @Override
    public Fragment getOnLineFragment() {
        return new OnLineDeskTopWallpaperFragment();
    }
}
