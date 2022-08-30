package com.book.themechooser;

import com.book.themechooser.adapters.online.OnlineThemePkgAdapter;
import com.book.themechooser.adapters.online.ThumbnailOnlineAdapter;
import com.book.themechooser.server.intf.NetBaseParam;
import com.book.themechooser.server.intf.UrlParam;

public class OnLineThemeFragment extends OnLineBaseFragment {
    protected NetBaseParam initUrl() {
        return UrlParam.newUrlParam(UrlParam.THEMEPACKAGE);
    }

    @Override
    protected ThumbnailOnlineAdapter onlineAdapterInstance() {
		if (getActivity() == null) {
			return null;
		}
        return new OnlineThemePkgAdapter(getActivity(), themeBases);
    }
}
