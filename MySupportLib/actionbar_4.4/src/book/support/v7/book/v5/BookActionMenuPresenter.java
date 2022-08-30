package book.support.v7.book.v5;

import java.util.ArrayList;

import book.support.v7.internal.view.menu.ActionMenuPresenter;
import book.support.v7.internal.view.menu.MenuBuilder;
import book.support.v7.internal.view.menu.MenuItemImpl;
import book.support.v7.appcompat.R;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.util.Log;


public class bookActionMenuPresenter extends ActionMenuPresenter {
    private boolean mIsActionMode;

    public bookActionMenuPresenter(Context context) {
        super(context, R.layout.abc_action_menu_layout,
                R.layout.abc_action_menu_item_layout);

        android.util.TypedValue typedValue = new android.util.TypedValue();
        if (context.getTheme().resolveAttribute(R.attr.book_action_mode_style,
                typedValue, true)) {
            if (typedValue.type == android.util.TypedValue.TYPE_INT_BOOLEAN) {
                mIsActionMode = typedValue.data != 0;
            }
        }
    }

    @Override
    public void initForMenu(Context context, MenuBuilder menu) {
        super.initForMenu(context, menu);

    }

    public boolean flagActionItems() {
        final ArrayList<MenuItemImpl> visibleItems = mMenu.bookGetVisibleItems();
        final int itemsSize = visibleItems.size();
        //Log.e("jxli", "bookActionMenuPresenter.java flagActionItems(), itemSize = " + itemsSize);
        int actionButtonCount = 0;
        int maxActions = bookActionMenuView.MAX_CELL_COUNT;

        for(int i = 0; i < itemsSize; i++) {
            MenuItemImpl item = (MenuItemImpl)visibleItems.get(i);
            if(item.requestsActionButton() || item.requiresActionButton()) {
                actionButtonCount++;
            }
        }

        actionButtonCount = 0;
        for(int i = 0; i < itemsSize; i++) {
            MenuItemImpl item = (MenuItemImpl) visibleItems.get(i);
            if(actionButtonCount < maxActions && (item.requestsActionButton() || item.requiresActionButton())) {
                actionButtonCount++;
                item.setIsActionButton(true);
            } else {
                item.setIsActionButton(false);
            }
        }

        return true;
    }

    @Override
    public void updateMenuView(boolean cleared) {
        super.updateMenuView(cleared);

        if (null != mUpdateListener) {
            mUpdateListener.onUpdated(mMenu);
        }
    }

    public void setActionMode(boolean actionMode)  {
        mIsActionMode = actionMode;
    }

    public boolean isActionMode() {
        return mIsActionMode;
    }

    public interface OnActionMenuUpdateListener {
        public void onUpdated(MenuBuilder menu);
    }
    private OnActionMenuUpdateListener mUpdateListener;
    public void setOnActionMenuUpdateListener(OnActionMenuUpdateListener listener) {
        mUpdateListener = listener;
    }
}
