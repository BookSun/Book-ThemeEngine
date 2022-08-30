LOCAL_PATH:= $(call my-dir)
include $(CLEAR_VARS)

LOCAL_MODULE_TAGS := optional

LOCAL_STATIC_JAVA_LIBRARIES :=book-theme
LOCAL_STATIC_JAVA_LIBRARIES += laml

LOCAL_SRC_FILES := $(call all-java-files-under, src)

LOCAL_SRC_FILES += \
      src/com/book/themes/service/IThemeService.aidl\
      src/com/book/themes/service/IThemeServiceCallback.aidl\

LOCAL_MODULE := com.book.themes

include $(BUILD_STATIC_JAVA_LIBRARY)

# Build sub-modules
include $(call all-makefiles-under, $(LOCAL_PATH))
#include $(call all-subdir-makefiles)
