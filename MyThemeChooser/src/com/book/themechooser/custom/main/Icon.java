package com.book.themechooser.custom.main;

import android.app.Fragment;

import com.book.themechooser.custom.CustomBase;
import com.book.themechooser.custom.fragment.local.IconFragment;
import com.book.themechooser.custom.fragment.online.OnLineIconFragment;

public class Icon extends CustomBase {

    @Override
    public Fragment getLocalFragment() {
        return new IconFragment();
    }

    @Override
    public Fragment getOnLineFragment() {
        return new OnLineIconFragment();
    }

}
