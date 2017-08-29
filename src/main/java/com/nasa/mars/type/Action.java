package com.nasa.mars.type;

public enum Action {
    L("Left"),
    R("Right"),
    M("Move");

    private String action;

    Action(String action) {
        this.action = action;
    }
}