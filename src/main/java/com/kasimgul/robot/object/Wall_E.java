package com.kasimgul.robot.object;

import com.kasimgul.robot.geo.Destination;
import com.kasimgul.robot.geo.Direction;
import com.kasimgul.robot.ui.UserInterface;
import com.kasimgul.robot.utility.PathValidator;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class Wall_E {

    private final Room room;
    private final UserInterface userInterface;
    private Direction direction;
    private Point currentLocation;

    public Wall_E(Room room, UserInterface userInterface) {
        this.room = room;
        this.userInterface = userInterface;
        this.currentLocation = room.getStartPosition();
        this.direction = Direction.NORTH;
    }

    public Destination gotoDestination(String path) {
        boolean isValid = PathValidator.isValid(path);
        if (!isValid) return null;

        List<String> pathAsList = Arrays.asList(path.split(""));
        pathAsList.forEach(letter -> {
            switch (letter.toUpperCase()) {
                case "V":
                case "L":
                    turnLeft();
                    break;
                case "R":
                case "H":
                    turnRight();
                    break;
                case "G":
                case "F":
                    moveForward();
                    break;
            }
        });
        validateDestination();
        return new Destination(currentLocation, direction);
    }

    private void turnLeft() {
        int leftId = (direction.getId() + 2) % 4 + 1;
        direction = Direction.getDirectionById(leftId);
    }

    private void turnRight() {
        int rightId = direction.getId() % 4 + 1;
        direction = Direction.getDirectionById(rightId);
    }

    private void moveForward() {
        switch (direction) {
            case NORTH:
                currentLocation.y += 1;
                break;
            case EAST:
                currentLocation.x += 1;
                break;
            case SOUTH:
                currentLocation.y -= 1;
                break;
            case WEST:
                currentLocation.x -= 1;
                break;
        }
    }

    private void validateDestination() {
        boolean contains = room.contains(currentLocation);
        if (!contains) {
            userInterface.handleInvalidDestination(currentLocation, room);
        }
    }
}
