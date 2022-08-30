
package com.book.support.laml;

import com.book.support.laml.elements.ButtonScreenElement;
import com.book.support.laml.elements.ButtonScreenElement.ButtonAction;

public abstract interface InteractiveListener {
    public abstract void onButtonInteractive(ButtonScreenElement ele,
            ButtonAction action);
}
