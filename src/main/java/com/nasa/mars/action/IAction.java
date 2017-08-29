package com.nasa.mars.action;

import com.nasa.mars.rover.RoverController;

public interface IAction {
    void apply(RoverController rover);
}
