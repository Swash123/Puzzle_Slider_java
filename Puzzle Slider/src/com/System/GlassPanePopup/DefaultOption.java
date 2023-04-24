package com.System.GlassPanePopup;

import net.miginfocom.layout.LayoutCallback;

import java.awt.*;


public class DefaultOption extends Option {

    private float animate;

    /**
     * Creates a new Option object.
     *
     */
    public DefaultOption(){

    }


    public LayoutCallback getLayoutCallBack(Component parent) {
        return new DefaultLayoutCallBack(parent);
    }


    public String getLayout(Component parent, float animate) {
        float an = 20f / parent.getHeight();
        float space = 0.5f + an - (animate * an);
        return "pos 0.5al " + space + "al";
    }


    public boolean closeWhenClickOutside() {
        return true;
    }


    public boolean blockBackground() {
        return true;
    }


    public Color background() {
        return new Color(100, 100, 100);
    }


    public float opacity() {
        return 0.5f;
    }


    public int duration() {
        return 300;
    }


    public float getAnimate() {
        return animate;
    }


    public void setAnimate(float animate) {
        this.animate = animate;
    }
}