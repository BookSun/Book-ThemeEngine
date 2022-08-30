package com.book.themechooser.custom.main;

import android.app.Fragment;
import android.content.Intent;

import com.book.themechooser.custom.CustomBase;
import com.book.themechooser.custom.fragment.local.LocalLockScreenWallpaperFragment;
import com.book.themechooser.custom.fragment.online.OnLineLockScreenWallpaperFragment;

/**
 * @author xufeng
 */
public class LockScreenWallpaper extends CustomBase {

    @Override
    public Fragment getLocalFragment() {
        return new LocalLockScreenWallpaperFragment();
    }

    @Override
    public Fragment getOnLineFragment() {
        return new OnLineLockScreenWallpaperFragment();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

}
