
package com.book.support.theme;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import android.os.Build;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;

public class IconAlias {

    private static final String TAG = "IconAlias";
    
    private static final String NOKIA_MM_419 = "MM-419";
    
    private static final String NOKIA_X = "Nokia_X";
    
    public static void loadAlias(HashMap<String, String> map, String config) {
        loadDefaultAlias(map);
        loadCustomAlias(map, config);
    }

    public static void loadCustomAlias(HashMap<String, String> map, String file) {
        InputStream in = null;
        try {
            File config = new File(file);
            if (config.exists()) {
                in = new FileInputStream(config);
                XmlPullParser parser = XmlPullParserFactory.newInstance().newPullParser();
                parser.setInput(in, "utf-8");
                int eventType = parser.getEventType();
                while (eventType != XmlPullParser.END_DOCUMENT) {
                    if (eventType == XmlPullParser.START_TAG && parser.getName().equals("Icon")) {
                        String name = parser.getAttributeValue(null, "name");
                        String alias = parser.getAttributeValue(null, "alias");
                        map.put(name, alias);
                    }
                    eventType = parser.next();
                }
                in.close();
            }
        } catch (Exception e) {
            Log.e(TAG, "load icon alias", e);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (Exception ex) {
                }
            }
        }
    }

    public static void loadDefaultAlias(HashMap<String, String> map) {
        // activities
        map.put("com.android.gallery3d#com.android.camera.Camera.png", "com.book.camera.png");
        map.put("com.android.gallery3d#com.android.camera.CameraLauncher.png","com.book.camera.png");
        map.put("com.android.gallery3d.app.Gallery.png", "com.book.photo.png");
        map.put("com.android.gallery3d.app.bookGalleryActivity.png", "com.book.photo.png");
        map.put("com.android.settings.bluetooth.RequestPermissionActivity.png", "com.book.bluetooth.png");
        map.put("com.book.gallery3d#com.android.camera.Camera.png", "com.book.camera.png");
        map.put("com.android.camera2#com.android.camera.CameraLauncher.png", "com.book.camera.png");
        map.put("com.book.gallery3d#com.android.camera.CameraLauncher.png", "com.book.camera.png");
        map.put("com.book.gallery3d#com.android.gallery3d.app.bookGalleryActivity.png","com.book.photo.png");
        map.put("com.book.PIM.contacts.activities.ContactsEntryActivity.png","com.book.contacts.png");
        map.put("com.book.PIM#com.android.contacts.ContactsApplication.png","com.book.contacts.png");
        map.put("com.book.PIM.contacts.activities.DialtactsActivity.png", "com.book.phone.png");
        map.put("com.book.PIM#com.android.contacts.activities.DialtactsActivity.png", "com.book.phone.png");
        map.put("com.book.PIM.contacts.activities.MessageActivity.png", "com.book.messages.png");
        map.put("com.book.PIM#com.android.contacts.activities.MessageActivity.png", "com.book.messages.png");
        map.put("com.book.PIM.contacts.ShareContactViaSDCard.png", "com.book.sdcard.png");
        map.put("com.book.PIM.mms.ui.ComposeMessageActivity.png", "com.book.messages.png");
        map.put("com.android.deskclock.DeskClockMainActivity.png", "com.book.deskclock.png");
        map.put("com.android.deskclock.AlarmClock.png", "com.book.deskclock.png");
        
        // packages
        map.put("android.png", "book.png");
        map.put("com.android.browser.png", "com.book.browser.png");
        map.put("com.oupeng.browser#com.opera.android.OperaStartActivity.png", "com.book.browser.png");
        map.put("com.android.calculator2.png", "com.book.calculator.png");
        map.put("com.android.calendar.png", "com.book.calendar.png");
        map.put("com.android.calendar.png", "com.book.calendar.png");
        map.put("com.android.camera.png", "com.book.camera.png");
        map.put("com.android.deskclock.png", "com.book.deskclock.png");
        map.put("com.android.email.png", "com.book.mail.png");
        map.put("com.android.exchange.png", "com.book.mail.png");
        map.put("com.android.facelock.png", "com.book.settings.png");
        map.put("com.android.galaxy4.png", "com.book.wallpaper.png");
        map.put("com.android.gallery3d.png", "com.book.photo.png");
        map.put("com.android.magicsmoke.png", "com.book.wallpaper.png");
        map.put("com.android.musicvis.png", "com.book.wallpaper.png");
        map.put("com.android.noisefield.png", "com.book.wallpaper.png");
        map.put("com.android.phasebeam.png", "com.book.wallpaper.png");
        map.put("com.android.phone.png", "com.book.phone.png");
        map.put("com.android.providers.calendar.png", "com.book.calendar.png");
        map.put("com.android.providers.contacts.png", "com.book.contacts.png");
        map.put("com.android.providers.downloads.png", "com.book.download.png");
        map.put("com.android.providers.downloads.ui.png", "com.book.download.png");
        map.put("com.android.providers.media.png", "com.book.music.png");
        map.put("com.android.providers.settings.png", "com.book.settings.png");
        map.put("com.android.providers.telephony.png", "com.book.phone.png");
        map.put("com.android.settings.png", "com.book.settings.png");
        map.put("com.android.soundrecorder.png", "com.book.soundrecorder.png");
        map.put("com.android.stk.png", "com.book.stk.png");
        map.put("com.android.wallpaper.png", "com.book.wallpaper.png");
        map.put("com.android.wallpaper.holospiral.png", "com.book.wallpaper.png");
        map.put("com.android.wallpaper.livepicker.png", "com.book.wallpaper.png");
        map.put("com.baidu.BaiduMap.png", "com.book.maps.png");
        map.put("com.baidu.searchbox.png", "com.book.search.png");
        map.put("com.baidu.voiceassistant.png", "com.book.voicecommand.png");
        map.put("com.chaozh.iReader.png", "com.book.bookstore.png");
        map.put("com.book.appstore.png", "com.book.store.png");
        map.put("com.book.flashlight.png", "com.book.torch.png");
        map.put("com.book.gallery3d.png", "com.book.photo.png");
        map.put("com.book.labi.png", "com.book.contacts.png");
        map.put("com.book.launcher.png", "book.png");
        map.put("com.book.launcher5.png", "book.png");
        map.put("com.book.lockscreen.png", "com.book.lock.png");
        map.put("com.book.bookguide.png", "com.book.guidebook.png");
        map.put("com.book.netmgr.adjust.png", "com.book.netmgr.png");
        map.put("com.book.PIM.png", "com.book.contacts.png");
        map.put("com.book.player.png", "com.book.music.png");
        map.put("com.book.musicplayer.png", "com.book.music.png");
        map.put("com.book.spm.png", "com.book.battery.png");
        map.put("com.book.themechooser.png", "com.book.theme.png");
        map.put("com.book.thememanager.png", "com.book.theme.png");
        map.put("com.book.updater.png", "com.book.update.png");
        map.put("com.book.providers.downloads.png", "com.book.download.png");
        map.put("com.book.providers.downloads.ui.png", "com.book.download.png");
        map.put("com.mediatek.batterywarning.png", "com.book.settings.png");
        map.put("com.mediatek.bluetooth.png", "com.book.bluetooth.png");
        map.put("com.mediatek.FMRadio.png", "com.book.radio.png");
        map.put("com.mediatek.schpwronoff.png", "com.book.settings.png");
        map.put("com.mediatek.StkSelection.png", "com.book.stk.png");
        map.put("com.mediatek.videoplayer.png", "com.book.video.png");
        map.put("com.mediatek.voicecommand.png", "com.book.settings.png");
        map.put("com.mediatek.voiceunlock.png", "com.book.settings.png");
        map.put("com.mediatek.datatransfer.png", "com.book.datatransfer.png");
        map.put("com.when.android.calendar365.png", "com.book.calendar.png");
        map.put("org.dayup.gnotes.book.png", "com.book.note.png");
        map.put("tv.huohua.android.ocher.png", "com.book.movie.png");
        map.put("com.quicinc.fmradio.png", "com.book.radio.png");
        map.put("com.quicinc.fmradio.FMRadio.png", "com.book.radio.png");
        map.put("com.android.bluetooth.png", "com.book.bluetooth.png");
        map.put("com.oppo.camera.CameraLauncher.png", "com.book.camera.png");
        map.put("com.oppo.gallery3d.png", "com.book.photo.png");
        // for aosp coolpad s5890
        map.put("com.yulong.android.cp_utk.png", "com.book.stk.png");
        map.put("com_yulong_android_cp_utk.png", "com_mediatek_stkselection.png");
        //KK
        map.put("com.android.dialer.png", "com.book.phone.png");
        map.put("com.android.contacts.png", "com.book.contacts.png");
        map.put("com.android.dialer.DialtactsActivity.png", "com.book.phone.png");
        map.put("com.android.contacts.activities.ContactsEntryActivity.png", "com.book.contacts.png");
        map.put("com.android.contacts.activities.MessageActivity.png", "com.book.messages.png");
        map.put("com.android.mms.png","com.book.messages.png");
        
        map.put("com_android_contacts_contactsapplication.png", "com_book_pim_contacts_activities_contactsentryactivity.png");
        map.put("com_android_contacts_activities_dialtactsactivity.png", "com_book_pim_contacts_activities_dialtactsactivity.png");
        map.put("com_android_contacts_activities_messageactivity.png", "com_book_pim_contacts_activities_messageactivity.png");
        // v4 alias
        map.put("com_android_deskclock_deskclockmainactivity.png", "com_android_deskclock.png");
        map.put("com_android_deskclock_alarmClock.png", "com_android_deskclock.png");
        map.put("com_book_pim_contacts_contactsapplication.png", "com_book_pim_contacts_activities_contactsentryactivity.png");
        map.put("com_android_gallery3d_app_galleryappimpl.png", "com_android_galleryx.png");
        map.put("com_android_camera_cameralauncher.png", "com_android_camera.png");
        map.put("com_android_camera_camera.png", "com_android_camera.png");
        map.put("com_android_gallery3d_app_bookgalleryactivity.png", "com_android_galleryx.png");
        map.put("com_android_gallery3d_app_gallery.png", "com_android_galleryx.png");
        map.put("com_book_gallery3d_app_bookgalleryactivity.png", "com_android_galleryx.png");
        map.put("com_baidu_baidumap.png", "com_android_mapx.png");
        map.put("com_baidu_voiceassistant.png", "com_book_voicecommand.png");
        map.put("com_chaozh_ireader.png", "com_book_books.png");
        map.put("com_book_appstore.png", "com_book_store.png");
        map.put("com_baidu_searchbox.png", "com_book_search.png");
        
        map.put("com_mediatek_fmradio.png", "com_book_fmradio.png");
        map.put("com_quicinc_fmradio.png", "com_book_fmradio.png");
        map.put("com_quicinc_fmradio_fmradio.png", "com_book_fmradio.png");
        map.put("com_mediatek_videoplayer.png", "com_android_video.png");
        map.put("com_socogame_ppc.png", "com_android_gamex.png");
        map.put("com_when_android_calendar365.png", "com_android_calendarx.png");
        map.put("com_android_calendar.png", "com_android_calendarx.png");
        map.put("org_dayup_gnotes_book.png", "com_android_notesx.png");
        map.put("tv_huohua_android_ocher.png", "com_book_movie.png");
        map.put("icon_folder_background.png", "com_android_folder.png");
        map.put("com_book_musicplayer.png", "com_book_player.png");
        map.put("com_book_providers_downloads_ui.png", "com_android_providers_downloads_ui.png");
        map.put("com.android.music.png", "com.book.music.png");

        map.put("com_android_music.png", "com_book_player.png");

        map.put("com.android.quicksearchbox.png", "com.book.search.png");
        map.put("com.android.camera2.png", "com.book.camera.png");
        Build bd = new Build();
        // Nokia MM-419
        if (NOKIA_MM_419.equals(bd.MODEL) || NOKIA_X.equals(bd.MODEL)) {
            map.put("com.android.mms.png", "com.book.messages.png");
            map.put("com.android.contacts.activities.DialtactsActivity.png",
                    "com.book.phone.png");
            map.put("com.nokia.xpress.png", "com.book.browser.png");
            map.put("com.android.music.png", "com.book.music.png");
            map.put("com.android.quicksearchbox.png", "com.book.search.png");
            map.put("com.here.app.maps.png", "com.book.maps.png");
            map.put("com.uc.nokiaappstore.png", "com.book.store.png");
            map.put("com.book.themechooser.ThemeChooser.png",
                    "com.book.theme.png");
            map.put("com.book.launcher.n#com.book.themechooser.ThemeChooser.png",
                    "com.book.theme.png");
            map.put("com.book.launcher.n#com.book.weather.bookWeather.png",
                    "com.book.weather.png");

            // V4 alias
            map.put("com_android_contacts.png",
                    "com_book_pim_contacts_activities_contactsentryactivity.png");
            map.put("com_android_mms.png",
                    "com_book_pim_contacts_activities_messageactivity.png");
            map.put("com_android_contacts_activities_dialtactsactivity.png",
                    "com_book_pim_contacts_activities_dialtactsactivity.png");
            map.put("com_nokia_xpress.png", "com_android_browser.png");
            map.put("com_android_music.png", "com_book_player.png");
            map.put("com_android_quicksearchbox.png", "com_book_search.png");
            map.put("com_here_app_maps.png", "com_android_mapx.png");
            map.put("com_uc_nokiaappstore.png", "com_book_store.png");
            map.put("com_book_themechooser_themechooser.png",
                    "com_book_themechooser.png");
            map.put("com_quicinc_fmradio.png", "com_book_fmradio.png");
        }
        // nokia MM-419 end
    }
}
