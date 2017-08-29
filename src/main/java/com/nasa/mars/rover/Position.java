package com.nasa.mars.rover;

import com.nasa.mars.type.Direction;

public class Position {
    private Coordinate coordinate;
    private Direction direction;

    public Position(Coordinate coordinate, Direction direction) {
        this.coordinate = coordinate;
        this.direction = direction;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public Direction getDirection() {
        return direction;
    }

    public void left() {
        this.direction = direction.left();
    }

    public void right() {
        this.direction = direction.right();
    }

    public void move(Coordinate lowerLimit, Coordinate upperLimit) {
        switch (direction) {
            case N:
                coordinate.moveNorth(upperLimit);
                break;
            case S:
                coordinate.moveSouth(lowerLimit);
                break;
            case E:
                coordinate.moveEast(upperLimit);
                break;
            case W:
                coordinate.moveWest(lowerLimit);
                break;
        }
    }

    @Override
    public String toString() {
        return coordinate.getX() + " " + coordinate.getY() + " " + direction;
    }
}
