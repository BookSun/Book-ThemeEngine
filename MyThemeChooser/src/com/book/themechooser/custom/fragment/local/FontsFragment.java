package com.book.themechooser.custom.fragment.local;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.book.themechooser.R;
import com.book.themechooser.ThemeApplication;
import com.book.themechooser.custom.preview.local.FontsPreview;
import com.book.themes.provider.ThemeItem;
import com.book.themes.provider.ThemeItem.PreviewsType;

public class FontsFragment extends LocalBase {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLayoutRes = R.layout.theme_fonts_preference;
        mItemLayoutResource = R.layout.theme_fonts;
        mDefaultImageRes = R.drawable.bg_text_style;
    }

    @Override
    protected int getType() {
        return FONT_TYPE;
    }

    @Override
    public void startActivity(View v) {
        Intent intent = new Intent();
        intent.setClass(getActivity(), FontsPreview.class);
        Bundle mExtras = new Bundle();
        mExtras.putStringArrayList("themes_uri", uriList);
        intent.putExtra("extras_themes_uri", mExtras);
        intent.setData((Uri) v.getTag());
        getActivity().startActivity(intent);
    }

    @Override
    public boolean isApplied(ThemeItem themeItem) {
        return ThemeApplication.sThemeStatus.isApplied(themeItem.getPackageName()
                , com.book.themechooser.ThemeStatus.THEME_TYPE_FONT);
    }

    @Override
    public PreviewsType getThumbnailType() {
        return PreviewsType.FONTS;
    }

    @Override
    public void onItemClick(android.widget.AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent();
        intent.setClass(getActivity(), FontsPreview.class);
        Bundle mExtras = new Bundle();
        mExtras.putStringArrayList("themes_uri", uriList);
        intent.putExtra("extras_themes_uri", mExtras);
        intent.setData((Uri) ((ViewHolder) view.getTag()).thumbnail.getTag());
        getActivity().startActivity(intent);
    }
}
