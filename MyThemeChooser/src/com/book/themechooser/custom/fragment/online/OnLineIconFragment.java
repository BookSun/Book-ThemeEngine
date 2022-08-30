package com.book.themechooser.custom.fragment.online;

import com.book.themechooser.OnLineBaseFragment;
import com.book.themechooser.ThemeConstants;
import com.book.themechooser.adapters.online.OnlineIconsAdapter;
import com.book.themechooser.adapters.online.ThumbnailOnlineAdapter;
import com.book.themechooser.server.intf.NetBaseParam;
import com.book.themechooser.server.intf.UrlParam;

/**
 * @author xufeng
 */
public class OnLineIconFragment extends OnLineBaseFragment {

    @Override
    protected NetBaseParam initUrl() {
        return UrlParam.newUrlParam(UrlParam.ICONSTYLE, ThemeConstants.ICON);
    }

    @Override
    protected ThumbnailOnlineAdapter onlineAdapterInstance() {
		if (getActivity() == null) {
			return null;
		}
        return new OnlineIconsAdapter(getActivity(), themeBases);
    }

}
