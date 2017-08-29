package com.nasa.mars.util;

import com.nasa.mars.action.IAction;
import com.nasa.mars.action.LeftAction;
import com.nasa.mars.action.MoveAction;
import com.nasa.mars.action.RightAction;
import com.nasa.mars.exception.AppException;
import com.nasa.mars.rover.Coordinate;
import com.nasa.mars.rover.Position;
import com.nasa.mars.type.Direction;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Parser {
    private static <K, V> Map.Entry<K, V> entry(K key, V value) {
        return new AbstractMap.SimpleEntry<>(key, value);
    }

    private static Map<String, IAction> actionMap = Collections.unmodifiableMap(Stream.of(
            entry("L", new LeftAction()),
            entry("R", new RightAction()),
            entry("M", new MoveAction()))
            .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue())));

    public static Coordinate getLimitCoordinates(String input) throws AppException {
        if (input == null) throw new AppException("invalid input for limits. input=" + input);
        String[] limits = input.split(" ");
        if (limits.length != 2) throw new AppException("invalid input for limits. input=" + input);
        return new Coordinate(Integer.parseInt(limits[0]), Integer.parseInt(limits[1]));
    }

    public static Position getPosition(String input) throws AppException {
        if (input == null) throw new AppException("invalid input for position. input=" + input);
        String[] limits = input.split(" ");
        if (limits.length != 3) throw new AppException("invalid input for position. input=" + input);
        Coordinate coordinate = new Coordinate(Integer.parseInt(limits[0]), Integer.parseInt(limits[1]));
        Direction direction = Direction.valueOf(limits[2]);
        return new Position(coordinate, direction);
    }

    public static List<IAction> getActions(String input) throws AppException {
        if (input == null) throw new AppException("invalid input for position. input=" + input);
        List<IAction> actions = new ArrayList<>();
        for(char c : input.toCharArray()) {
            actions.add(actionMap.get(String.valueOf(c)));
        }
        return actions;
    }
}
