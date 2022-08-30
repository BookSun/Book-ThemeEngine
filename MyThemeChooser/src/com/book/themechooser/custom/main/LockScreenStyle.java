package com.book.themechooser.custom.main;

import android.app.Fragment;

import com.book.themechooser.custom.CustomBase;
import com.book.themechooser.custom.fragment.local.LocalLockScreenStyleFragment;
import com.book.themechooser.custom.fragment.online.OnLineLockScreenStyleFragment;

/**
 * @author xufeng
 */
public class LockScreenStyle extends CustomBase {

    @Override
    public Fragment getLocalFragment() {
        return new LocalLockScreenStyleFragment();
    }

    @Override
    public Fragment getOnLineFragment() {
        return new OnLineLockScreenStyleFragment();
    }

}
