package com.kasimgul.robot.object;

import java.awt.*;

public class RoomCircle implements Room {

    private Point startPosition;
    private static final int RADIUS = 10;

    public RoomCircle() {
        startPosition = new Point(0, 0);
    }

    @Override
    public Point getStartPosition() {
        return startPosition;
    }

    @Override
    public boolean contains(Point position) {
        return ((position.getX() >= -RADIUS && (position.getX() <= RADIUS)) &&
                (position.getY() >= -RADIUS && position.getY() <= RADIUS));
    }
}
