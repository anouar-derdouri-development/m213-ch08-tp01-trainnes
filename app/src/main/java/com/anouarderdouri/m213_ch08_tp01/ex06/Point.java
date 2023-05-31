package com.anouarderdouri.m213_ch08_tp01.ex06;

public class Point {
    private Character label = '?';
    private Integer x = null;
    private Integer y = null;

    public Character getLabel() {
        return label;
    }

    public void setLabel(Character label) {
        this.label = label;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format("%s(%s, %s)",
                label == null ? "" : label,
                x == null ? "?" : x,
                y == null ? "?" : y);
    }
}
