package com.book.themechooser.custom.fragment.online;

import com.book.themechooser.OnLineBaseFragment;
import com.book.themechooser.ThemeConstants;
import com.book.themechooser.adapters.online.OnlineLiveWallpaperAdapter;
import com.book.themechooser.adapters.online.ThumbnailOnlineAdapter;
import com.book.themechooser.server.intf.NetBaseParam;
import com.book.themechooser.server.intf.UrlParam;

public class OnLineLiveWallpaperFragment extends OnLineBaseFragment {

    @Override
    protected NetBaseParam initUrl() {
        return UrlParam.newUrlParam(UrlParam.LIVE_WALLPAPER, ThemeConstants.LIVE_WALLPAPER);
    }

    @Override
    protected ThumbnailOnlineAdapter onlineAdapterInstance() {
		if (getActivity() == null) {
			return null;
		}
        return new OnlineLiveWallpaperAdapter(getActivity(), themeBases);
    }

}
