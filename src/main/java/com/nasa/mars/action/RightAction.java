package com.nasa.mars.action;

import com.nasa.mars.rover.RoverController;

public class RightAction implements IAction {
    public void apply(RoverController rover) {
        rover.right();
    }
}
