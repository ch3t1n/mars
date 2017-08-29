package com.nasa.mars.action;

import com.nasa.mars.rover.RoverController;

public class LeftAction implements IAction {
    public void apply(RoverController rover) {
        rover.left();
    }
}
