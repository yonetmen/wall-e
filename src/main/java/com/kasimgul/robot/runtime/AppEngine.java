package com.kasimgul.robot.runtime;

import com.kasimgul.robot.geo.Destination;
import com.kasimgul.robot.object.Room;
import com.kasimgul.robot.object.Wall_E;
import com.kasimgul.robot.ui.UserInterface;

public class AppEngine {

    private UserInterface userInterface;

    public AppEngine() {
        this.userInterface = new UserInterface();
    }

    public void runApplication() {
        Room room = getSelectedRoom();
        Wall_E wallE = new Wall_E(room, userInterface);
        Destination destination = moveRobotToDestination(wallE);
        userInterface.outputDestination(destination);
    }

    private Room getSelectedRoom() {
        Room room;
        do {
            room = userInterface.roomSelection();
        } while (room == null);
        return room;
    }

    private Destination moveRobotToDestination(Wall_E wallE) {
        Destination destination;
        do {
            String path = userInterface.getPathFromUser();
            destination = wallE.gotoDestination(path);
            if (destination == null)
                userInterface.handleInvalidInput();
        } while (destination == null);
        return destination;
    }

}
