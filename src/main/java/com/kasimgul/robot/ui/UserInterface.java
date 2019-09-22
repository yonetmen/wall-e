package com.kasimgul.robot.ui;

import com.kasimgul.robot.geo.Destination;
import com.kasimgul.robot.object.Room;
import com.kasimgul.robot.object.RoomCircle;
import com.kasimgul.robot.object.RoomSquare;

import java.awt.*;
import java.util.Scanner;

public class UserInterface {

    private final Scanner scanner;

    public UserInterface() {
        this.scanner = new Scanner(System.in);
    }

    public Room roomSelection() {
        Room room = null;
        System.out.println("Please choose a Room to operate your Wall_E: ");
        System.out.println("1 - Square Room");
        System.out.println("2 - Circle Room");
        String roomType = scanner.nextLine();

        switch (roomType) {
            case "1":
                room = new RoomSquare();
                break;
            case "2":
                room = new RoomCircle();
                break;
            default:
                System.err.println("Your input is not valid. Please try again!");
                break;
        }
        return room;
    }

    public String getPathFromUser() {
        System.out.println("Wall-E waits for your command. Please tell him where to go.");
        return scanner.nextLine();
    }

    public void outputDestination(Destination destination) {
        System.out.println(destination);
    }

    public void handleInvalidInput() {
        System.err.println("You provided invalid commands. Please use only followed letters");
        System.out.println("L = Turn Left");
        System.out.println("R = Turn Right");
        System.out.println("F = Forward");
        System.out.println("V = Vänd åt vänster");
        System.out.println("H = Vänd åt höger");
        System.out.println("G = Gå framåt");
    }

    public void handleInvalidDestination(Point location, Room room) {
        System.err.println("Destination is located outside the room. Wall-E will shut down!");

        int currentX = (int) location.getX();
        int currentY = (int) location.getY();

        String roomTypeName = room.getClass().getSimpleName();
        if (roomTypeName.equals(RoomSquare.class.getSimpleName())) {
            if (currentX < 1) currentX -= 1;
            if (currentY < 1) currentY -= 1;
        }

        System.err.println("Invalid destination. X=" + currentX + ", Y=" + currentY);
    }
}
