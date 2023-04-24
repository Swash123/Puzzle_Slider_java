package com.System.GlassPanePopup;

import net.miginfocom.layout.LayoutCallback;

import java.awt.*;


public abstract class  Option {

    public abstract LayoutCallback getLayoutCallBack(Component parent);

    public abstract String getLayout(Component parent, float animate);

    public abstract boolean closeWhenClickOutside();

    public abstract boolean blockBackground();

    public abstract Color background();

    public abstract float opacity();

    public abstract int duration();

    public abstract float getAnimate();

    abstract void setAnimate(float animate);
}
