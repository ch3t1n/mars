package com.nasa.mars.rover;

import com.nasa.mars.exception.AppException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CoordinateTest {
    private Coordinate coordinate;
    private Coordinate lowerLimit;
    private Coordinate upperLimit;

    @Before
    public void setup() {
        coordinate = new Coordinate(1, 2);
        lowerLimit = new Coordinate(0, 0);
        upperLimit = new Coordinate(5, 5);
    }

    @Test
    public void testMoveNorth() throws AppException {
        coordinate.moveNorth(upperLimit);
        Assert.assertEquals(1, coordinate.getX());
        Assert.assertEquals(3, coordinate.getY());
    }

    @Test
    public void testMoveSouth() throws AppException {
        coordinate.moveSouth(lowerLimit);
        Assert.assertEquals(1, coordinate.getX());
        Assert.assertEquals(1, coordinate.getY());
    }

    @Test
    public void testMoveEast() throws AppException {
        coordinate.moveEast(upperLimit);
        Assert.assertEquals(2, coordinate.getX());
        Assert.assertEquals(2, coordinate.getY());
    }

    @Test
    public void testMoveWest() throws AppException {
        coordinate.moveWest(lowerLimit);
        Assert.assertEquals(0, coordinate.getX());
        Assert.assertEquals(2, coordinate.getY());
    }
}
