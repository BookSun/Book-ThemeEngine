LOCAL_PATH:= $(call my-dir)
include $(CLEAR_VARS)

LOCAL_MODULE_TAGS := optional

LOCAL_SRC_FILES := $(call all-java-files-under, src)

LOCAL_STATIC_JAVA_LIBRARIES := \
	com.book.themes \
    android-support-v13 \
    book-download-manager \
    book-support-v7-appcompat \

LOCAL_RESOURCE_DIR = \
    $(LOCAL_PATH)/res \
    vendor/book/apps/bookSupportLib/actionbar_4.4/res \

LOCAL_AAPT_FLAGS := \
    --auto-add-overlay \
    --extra-packages book.support.v7.appcompat

LOCAL_PACKAGE_NAME := bookThemeChooser

LOCAL_CERTIFICATE := platform

include $(BUILD_PACKAGE)
include $(BUILD_MULTI_PREBUILT)
# including the test apk
# include $(call all-makefiles-under,$(LOCAL_PATH))
