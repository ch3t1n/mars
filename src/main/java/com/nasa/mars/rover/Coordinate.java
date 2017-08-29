package com.nasa.mars.rover;

public class Coordinate {
    private int x;
    private int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // Assumption: no move/action if limit is hit.
    public void moveNorth(Coordinate limit) {
        if ((limit.y - this.y) > 0) {
            this.y++;
        }
    }

    public void moveEast(Coordinate limit) {
        if ((limit.x - this.x) > 0) {
            this.x++;
        }
    }

    public void moveSouth(Coordinate limit) {
        if ((this.y - limit.y) > 0) {
            this.y--;
        }
    }

    public void moveWest(Coordinate limit) {
        if ((this.x - limit.x) > 0) {
            this.x--;
        }
    }
}
