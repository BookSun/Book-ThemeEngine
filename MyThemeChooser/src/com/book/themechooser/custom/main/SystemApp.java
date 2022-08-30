package com.book.themechooser.custom.main;


import android.app.Fragment;

import com.book.themechooser.custom.CustomBase;
import com.book.themechooser.custom.fragment.local.SystemAppFragment;
import com.book.themechooser.custom.fragment.online.OnLineSystemAppFragment;

public class SystemApp extends CustomBase {

    @Override
    public Fragment getLocalFragment() {
        return new SystemAppFragment();
    }

    @Override
    public Fragment getOnLineFragment() {
        return new OnLineSystemAppFragment();
    }

}
