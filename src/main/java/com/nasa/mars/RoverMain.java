package com.nasa.mars;

import com.nasa.mars.action.IAction;
import com.nasa.mars.exception.AppException;
import com.nasa.mars.rover.Coordinate;
import com.nasa.mars.rover.Position;
import com.nasa.mars.rover.RoverController;
import com.nasa.mars.util.Parser;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RoverMain {
    public static void main(String[] args) throws AppException {
        System.out.println("Press enter/return twice to signal an end of input:");
        Scanner scanner = new Scanner(System.in);
        List<RoverController> rovers = new ArrayList<>();
        Coordinate lowerLimit = new Coordinate(0, 0);
        String input = scanner.nextLine();
        Coordinate upperLimit = Parser.getLimitCoordinates(input);
        while (true) {
            input = scanner.nextLine();
            if (input.equals("")) break;
            Position position = Parser.getPosition(input);
            input = scanner.nextLine();
            List<IAction> actions = Parser.getActions(input);
            RoverController rover = new RoverController(position, lowerLimit, upperLimit);
            rover.apply(actions);
            rovers.add(rover);
        }
        System.out.println("Output:");
        for(RoverController rover : rovers) {
            System.out.println(rover);
        }
        System.exit(0);
    }
}
