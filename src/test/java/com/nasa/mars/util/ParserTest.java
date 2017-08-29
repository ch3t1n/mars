package com.nasa.mars.util;

import com.nasa.mars.action.IAction;
import com.nasa.mars.action.LeftAction;
import com.nasa.mars.exception.AppException;
import com.nasa.mars.rover.Coordinate;
import com.nasa.mars.rover.Position;
import com.nasa.mars.type.Direction;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ParserTest {
    @Test
    public void testLimitCoordinates() throws AppException {
        Coordinate coordinate = Parser.getLimitCoordinates("5 5");
        Assert.assertEquals(5, coordinate.getX());
        Assert.assertEquals(5, coordinate.getY());
    }

    @Test
    public void testPositions() throws AppException {
        Position position = Parser.getPosition("1 2 N");
        Assert.assertEquals(1, position.getCoordinate().getX());
        Assert.assertEquals(2, position.getCoordinate().getY());
        Assert.assertEquals(Direction.N, position.getDirection());
    }

    @Test
    public void testActions() throws AppException {
        List<IAction> actions = Parser.getActions("LMLMLLM");
        Assert.assertEquals(7, actions.size());
        Assert.assertEquals(LeftAction.class, actions.get(0).getClass());
    }
}
