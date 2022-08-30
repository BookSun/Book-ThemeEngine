package com.book.themechooser.custom.fragment.online;

import com.book.themechooser.OnLineBaseFragment;
import com.book.themechooser.ThemeConstants;
import com.book.themechooser.adapters.online.OnlineFontsAdapter;
import com.book.themechooser.adapters.online.ThumbnailOnlineAdapter;
import com.book.themechooser.server.intf.NetBaseParam;
import com.book.themechooser.server.intf.UrlParam;

public class OnLineFontsFragment extends OnLineBaseFragment {
    @Override
    protected NetBaseParam initUrl() {
        return UrlParam.newUrlParam(UrlParam.FONT, ThemeConstants.FONT);
    }

    @Override
    protected ThumbnailOnlineAdapter onlineAdapterInstance() {
		if (getActivity() == null) {
			return null;
		}
        return new OnlineFontsAdapter(getActivity(), themeBases);
    }

    @Override
    public void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLayoutRes = com.book.themechooser.R.layout.online_fonts;
    }
}
