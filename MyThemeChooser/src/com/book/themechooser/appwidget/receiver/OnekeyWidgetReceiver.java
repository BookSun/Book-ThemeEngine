package com.book.themechooser.appwidget.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.book.themechooser.appwidget.util.CommonUtils;
import com.book.themechooser.appwidget.util.WallpaperUtils;

public class OnekeyWidgetReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (CommonUtils.ACTION_ONEKEY_WALLPAPER.equals(action)) {
            WallpaperUtils.startWallpaperService(context);
        } else if (CommonUtils.ACTION_ONEKEY_FONT.equals(action)) {
            startFontChangeService(context);
        } else if (CommonUtils.ACTION_ONEKEY_THEME.equals(action)) {
            startThemeChangeService(context);
        }
    }

    private void startFontChangeService(Context context) {
        Intent service = new Intent("com.book.themechooser.OnekeyFontChangeService");
        context.startService(service);
    }

    private void startThemeChangeService(Context context) {
        Intent service = new Intent("com.book.themechooser.OnekeyThemeChangeService");
        context.startService(service);
    }
}
