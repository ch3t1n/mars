package com.nasa.mars.rover;

import com.nasa.mars.action.IAction;
import com.nasa.mars.exception.AppException;

import java.util.List;

public class RoverController {
    private Position position;
    private Coordinate lowerLimit;
    private Coordinate upperLimit;

    public RoverController(Position position, Coordinate lowerLimit, Coordinate upperLimit) {
        this.position = position;
        this.lowerLimit = lowerLimit;
        this.upperLimit = upperLimit;
    }

    public Position getPosition() {
        return position;
    }

    public void left() {
        this.position.left();
    }

    public void right() {
        this.position.right();
    }

    public void move() {
        this.position.move(lowerLimit, upperLimit);
    }

    public void apply(List<IAction> actions) throws AppException {
        for(IAction action : actions) {
            action.apply(this);
        }
    }

    @Override
    public String toString() {
        return position.toString();
    }
}
