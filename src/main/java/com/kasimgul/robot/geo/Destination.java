package com.kasimgul.robot.geo;

import java.awt.*;

public class Destination {

    private Point point;
    private Direction direction;

    public Destination(Point point, Direction direction) {
        this.point = point;
        this.direction = direction;
    }

    @Override
    public String toString() {
        return "Wall-E's current location is: "
                + "X=" + (int) point.getX() + ", "
                + "Y=" + (int) point.getY() + ", "
                + direction.name().substring(0, 1);
    }

}
