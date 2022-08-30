package com.book.support.util;

import android.os.SystemProperties;
import android.text.TextUtils;

/**
 * Information about book OS, extracted from system properties.
 */
public class Build extends android.os.Build {
    /** The device name set by / used in bookOS. */
    public static final String book_DEVICE = SystemProperties.get("ro.book.device", UNKNOWN);

    public static final boolean book_DEFAULT_VIBRATION_GENERAL = SystemProperties.getBoolean("ro.book.defvibration", false);
    public static final String book_DEFAULT_RINGER_VOLUME_GENERAL = SystemProperties.get("ro.book.defringvolume", "8");
    public static final String book_DEFAULT_NOTIFICATION_VOLUME_GENERAL = SystemProperties.get("ro.book.defnotificationvolume", "8");
    public static final String book_DEFAULT_ALARM_VOLUME_GENERAL = SystemProperties.get("ro.book.defalarmvolume", "8");
    public static final boolean LEAW_DEFAULT_HAPTIC_FEEDBACK_GENERAL = SystemProperties.getBoolean("ro.book.hapticfeedback", false);
    /** The version of bookOS. */
    public static final String book_VERSION = SystemProperties.get("ro.book.version", UNKNOWN);

    public static final String PLATFORM_MTK_6575 = "MT6575";
    public static final String PLATFORM_MTK_6577 = "MT6577";
    /** The platform of bookOS. */
    public static final String PLATFORM = SystemProperties.get("ro.mediatek.platform", UNKNOWN);

    /** Return true if there are 2 sdcards in the device. */
    public static final boolean HAS_DUAL_SDCARDS = SystemProperties.getBoolean("ro.sys.dualSD", false);

    /** Return true if support book waxin in the device. */
    public static final boolean book_WAXIN_SUPPORT = SystemProperties.getBoolean("ro.book.waxin", false);

    /** Return true if support book intercept in the device. */
    public static final boolean book_INTERCEPT_SUPPORT = SystemProperties.getBoolean("ro.book.intercept", true);

    /** Return if 24 or 12 hour format*/
    public static final String TimeFormatHour = SystemProperties.get("ro.time.format.hour", UNKNOWN);

    /** Return true if shutdown animation is enable */
    public static final boolean SHUTDOWN_ANIMATIOM = SystemProperties.getBoolean("ro.build.shutdown.animation", false);

    /** add by benwu */
    public static final boolean book_CTA_SUPPORT = (SystemProperties.getBoolean("ro.book.cta", false) && android.os.Build.TYPE.equals("eng"));

    /** Return ro.book.b2b.version*/
    public static final String B2bVersion = SystemProperties.get("ro.book.b2b.version", UNKNOWN);

    /** Return ro.book.hardware.version*/
    public static final String HardwareVersion = SystemProperties.get("ro.book.hardware.version", UNKNOWN);
    /** Return true if support book pim weibo in the device */
    public static final boolean PIM_WEIBO_SUPPORT = SystemProperties.getBoolean("ro.book.b2b.pim.weibo",false);

    /** Return ro.sys.partner*/
    public static final String book_CHANNEL = SystemProperties.get("ro.sys.partner", "book");

    /** Return true if support book dualbutton just switch sim card in the device. */
    public static final boolean book_SWITCHSIM_SUPPORT = SystemProperties.getBoolean("ro.book.dualbutton.switchsim", true);

    //by zhangxianjia
    public static final boolean book_CAMERA_FLASHLIGHT = SystemProperties.getBoolean("ro.book.camera.flashlight", false);

    /** Return large font size*/
    public static final String DefaultFontScale = SystemProperties.get("ro.book.font.default", UNKNOWN);

    /**Return true if support video call  */
    public static final boolean book_VIDEOCALL_SUPPORT = SystemProperties.getBoolean("ro.book.videocall", false);

    /**Return true if support customer sales statistics  */
    public static final boolean book_SALES_STATISTICS_SUPPORT = SystemProperties.getBoolean("ro.book.sales.statistics", false);

    /**Return true if support launcher SCENE  */
    public static final boolean book_SCENE_SUPPORT = SystemProperties.getBoolean("ro.book.scene", false);

    /**Return true if support dial default mode is fastmode  */
    public static final boolean book_DIAL_FASTMODE_SUPPORT = SystemProperties.getBoolean("ro.book.dial.fastmode", false);

    /**Return true if support root option  */
    public static final boolean ROOT_ACCESS_SUPPORT = SystemProperties.getBoolean("ro.book.root.access", false);

    /**Return true if data off at default  */
    public static final boolean book_DATA_OFF_DEFAULT = SystemProperties.getBoolean("ro.book.data.off", false);

    /**Return true if support magnifier when input */
    public static final boolean SHOW_MAGNIFIER_WHEN_INPUT = "maguro".equals(DEVICE) ? true : false;

    public static final boolean IS_GALAXYS_NEXUS = "maguro".equals(DEVICE);

    public static final boolean IS_MIONE_CDMA = ("mione_plus".equals(DEVICE) && isMsm8660());

    public static final boolean IS_MITWO_CDMA = ("aries".equals(DEVICE) && hasCdmaProperty());

    public static final boolean IS_COOLPAD_5890 = "Coolpad5890".equals(DEVICE);

    public static final boolean IS_OPPO_N1 = "OPPO_N1_JB2".equals(book_DEVICE);

    /**Return proximity valid change delay */
    public static final int PROXIMITY_VALID_CHANGE_DELAY = SystemProperties.getInt("ro.book.prox.validchangedelay", 260);

    public static final String bookDefaultSmsNotificationName = SystemProperties.get("ro.config.sms_sound");

    private static boolean isMsm8660() {
        String soc = SystemProperties.get("ro.soc.name");
        return (TextUtils.equals(soc, "msm8660")) || (TextUtils.equals(soc, "unkown"));
    }

    private static boolean hasCdmaProperty() {
        String cdma = SystemProperties.get("persist.radio.modem");
        return (!TextUtils.isEmpty(cdma)) && ("CDMA".equals(cdma));
    }

    public static boolean hasFroyo() {
        // Can use static final constants like FROYO, declared in later versions
        // of the OS since they are inlined at compile time. This is guaranteed behavior.
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.FROYO;
    }

    public static boolean hasGingerbread() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD;
    }

    public static boolean hasHoneycomb() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB;
    }

    public static boolean hasHoneycombMR1() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR1;
    }

    /*
     * public static boolean hasJellyBean() {
     *     return Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN;
     * }
     */
}
