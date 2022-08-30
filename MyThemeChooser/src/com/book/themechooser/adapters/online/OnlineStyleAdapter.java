package com.book.themechooser.adapters.online;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.book.themechooser.ThemeConstants;
import com.book.themechooser.custom.preview.online.OnLineSystemAppPreivew;
import com.book.themechooser.pojos.ThemeBase;

import java.io.Serializable;
import java.util.ArrayList;

import util.ThemeUtil;

public class OnlineStyleAdapter extends ThumbnailOnlineAdapter {
    public OnlineStyleAdapter(Context context, ArrayList<ThemeBase> themeBases) {
        super(context, themeBases, com.book.themechooser.ThemeStatus.THEME_TYPE_STYLE);
    }

    public void onClick(View v) {
        super.onClick(v);
        Intent intent = new Intent();
        intent.setClass(mContext, OnLineSystemAppPreivew.class);
        intent.putExtra(ThemeConstants.THEMEBASE, (Serializable) v.getTag());
        tempThemeBases = mThemeBases;
//        intent.putExtra("themeBases", (Serializable) mThemeBases);
        comingSource.startActivityForResult(intent, REQUESTCODE);
    }

    @Override
    protected void initPath(ThemeBase themeBase) {
        try {
            url = themeBase.thumbnailpath;
            thumbnailPath = new StringBuilder().append(ThemeConstants.THEME_ONLINE_THUMBNAIL)
                    .append("/").append(ThemeConstants.THEME_THUMBNAIL_STYLE_PREFIX)
                    .append(ThemeUtil.getNameNoBuffix(themeBase.getPkg())).toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
