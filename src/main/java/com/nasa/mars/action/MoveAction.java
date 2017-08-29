package com.nasa.mars.action;

import com.nasa.mars.rover.RoverController;

public class MoveAction implements IAction {
    public void apply(RoverController rover) {
        rover.move();
    }
}
