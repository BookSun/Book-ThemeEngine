package com.book.themechooser.custom.fragment.online;

import com.book.themechooser.OnLineBaseFragment;
import com.book.themechooser.ThemeConstants;
import com.book.themechooser.adapters.online.OnlineWallPaperAdapter;
import com.book.themechooser.adapters.online.ThumbnailOnlineAdapter;
import com.book.themechooser.server.intf.NetBaseParam;
import com.book.themechooser.server.intf.UrlParam;

public class OnLineDeskTopWallpaperFragment extends OnLineBaseFragment {
    @Override
    protected NetBaseParam initUrl() {
        return UrlParam.newUrlParam(UrlParam.WALLPAPER, ThemeConstants.DESKTOP_WALLPAPER);
    }

    @Override
    protected ThumbnailOnlineAdapter onlineAdapterInstance() {
		if (getActivity() == null) {
			return null;
		}
        return new OnlineWallPaperAdapter(getActivity(), themeBases);
    }
}
