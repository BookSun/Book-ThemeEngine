/// book BEGIN
/*
 * Copyright (C) 2006 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package android.app;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageParser.Activity;
import android.content.pm.PackageParser.Package;
import android.content.pm.ResolveInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Package bookThemeHelper 
 *
 * {@hide}
 */

public class bookThemeHelper {
    private static final String ICON_THEME = "/data/system/system/face/icons";
    public static final String book_RES_PATH = "/system/framework/book-res.apk";

    public static void addExtraAssetPaths(AssetManager assetManager) {
        assetManager.addAssetPath(book_RES_PATH);
    }

    public static List<PackageInfo> getInstalledThemePackages(Context context) {
        ArrayList<PackageInfo> finalList = new ArrayList<PackageInfo>();
        //Delete for standalone by Fan.Yang
/*        List<PackageInfo> installedPackagesList = context.getPackageManager().getInstalledPackages(PackageManager.GET_THEME_PACKAGES);
        Iterator<PackageInfo> i = installedPackagesList.iterator();
        while (i.hasNext()) {
            final PackageInfo pi = i.next();
            if (pi != null && pi.isThemeApk) {
                finalList.add(pi);
            }
        }*/
        return finalList;
    }

    //Delete for standalone by Fan.Yang
/*    public static Drawable getIconDrawable(PackageManager pm, String packageName, int icon,  ApplicationInfo ai, PackageItemInfo pi) {
        book.util.IconManager im = new book.util.IconManager();
        Drawable dr = im.loadIcon(ai);
        if (null != dr) {
            return dr;
        }
        if (null != ai) {
            dr = im.loadIcon(ai);
            if (null != dr) {
                return dr;
            }
        }

        dr = pm.getDrawable(packageName, icon, ai);

        return dr;
    }*/

    // 48811-book Add begin
	// for support meta-data to book Theme
    public static void changeTheme(Context context) {
        int bookThemeId = context.getResources().getIdentifier("book:style/V5.Theme.Holo.Light", null, null);
        if (bookThemeId > 0) {
            context.setTheme(bookThemeId);
        }
    }

    public static void changeTheme(Context context, String theme) {
        int bookThemeId = context.getResources().getIdentifier(theme, null, null);
        if (bookThemeId > 0) {
            context.setTheme(bookThemeId);
        }
    }

    /**
     *
     * use to change a activity theme when the apk is in book os.
     *
     * @param context The context of the activity.
     * @param name The name of the desired resource.
     * @param defType Optional default resource type to find, if "type/" is
     *                not included in the name.  Can be null to require an
     *                explicit type.
     * @param defPackage Optional default package to find, if "package:" is
     *                   not included in the name.  Can be null to require an
     *                   explicit package.
     */
    public static void changeTheme(Context context, String name, String defType, String defPackage) {
        int bookThemeId = context.getResources().getIdentifier(name, defType, defPackage);
        if (bookThemeId > 0) {
            context.setTheme(bookThemeId);
        }
    }

    public static void changeThemeForbook(Resources res, Activity activity) {
        String themeName = activity.metaData.getString("book-theme");
        if (themeName != null) {
            int themeId = res.getIdentifier(themeName, null, null);
            if (themeId != 0) {
                activity.info.theme = themeId;
            }
        }
    }

    public static void changeThemeForbook(Resources res, Package owner, final ApplicationInfo ai) {
        String themeName = owner.mAppMetaData.getString("book-theme");
        if (themeName != null) {
            int themeId = res.getIdentifier(themeName, null, null);
            if (themeId != 0) {
                ai.theme = themeId;
            }
        }
    }
	// 48811-book Add end
}
/// book END
