package com.book.themechooser.custom.main;


import android.app.Fragment;

import com.book.themechooser.custom.CustomBase;
import com.book.themechooser.custom.fragment.local.FontsFragment;
import com.book.themechooser.custom.fragment.online.OnLineFontsFragment;

public class Fonts extends CustomBase {

    @Override
    public Fragment getLocalFragment() {
        return new FontsFragment();
    }

    @Override
    public Fragment getOnLineFragment() {
        return new OnLineFontsFragment();
    }

}
