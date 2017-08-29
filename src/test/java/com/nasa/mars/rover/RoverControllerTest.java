package com.nasa.mars.rover;

import com.nasa.mars.action.IAction;
import com.nasa.mars.action.LeftAction;
import com.nasa.mars.action.MoveAction;
import com.nasa.mars.action.RightAction;
import com.nasa.mars.exception.AppException;
import com.nasa.mars.type.Direction;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class RoverControllerTest {
    private RoverController roverController;
    private Position position;
    private Coordinate lowerLimit;
    private Coordinate upperLimit;

    @Before
    public void setup() {
        Coordinate coordinate = new Coordinate(1, 2);
        position = new Position(coordinate, Direction.N);
        lowerLimit = new Coordinate(0, 0);
        upperLimit = new Coordinate(5, 5);
        roverController = new RoverController(position, lowerLimit, upperLimit);
    }

    @Test
    public void testLeftAction() throws AppException {
       List<IAction> actions = Arrays.asList(new LeftAction(), new MoveAction());
        roverController.apply(actions);
        Assert.assertEquals("0 2 W", roverController.getPosition().toString());
    }

    @Test
    public void testRightAction() throws AppException {
        List<IAction> actions = Arrays.asList(new RightAction(), new MoveAction());
        roverController.apply(actions);
        Assert.assertEquals("2 2 E", roverController.getPosition().toString());
    }

    @Test
    public void testActions() throws AppException {
        List<IAction> actions = Arrays.asList(new LeftAction(), new MoveAction(),
                new LeftAction(), new MoveAction(),
                new LeftAction(), new MoveAction(),
                new LeftAction(), new MoveAction(),
                new MoveAction());
        roverController.apply(actions);
        Assert.assertEquals("1 3 N", roverController.getPosition().toString());
    }
}
