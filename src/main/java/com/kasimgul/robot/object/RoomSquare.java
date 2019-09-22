package com.kasimgul.robot.object;

import java.awt.*;

public class RoomSquare implements Room {

    private Point startPosition;
    private static final int X = 5;
    private static final int Y = 5;

    public RoomSquare() {
        startPosition = new Point(1, 2);
    }

    @Override
    public Point getStartPosition() {
        return startPosition;
    }

    @Override
    public boolean contains(Point position) {
        return ((position.getX() > 0 && (position.getX() <= X)) &&
                (position.getY() > 0 && position.getY() <= Y));

    }
}
