package com.kasimgul.robot.unittest;

import com.kasimgul.robot.geo.Destination;
import com.kasimgul.robot.geo.Direction;
import org.junit.Assert;
import org.junit.Test;

import java.awt.*;

public class DestinationTest {

    @Test
    public void destinationOutputForNorth() {
        Point point = new Point(1, 1);
        Direction direction = Direction.NORTH;
        Destination destination = new Destination(point, direction);
        String expected = "Wall-E's current location is: X=1, Y=1, N";
        Assert.assertEquals(expected, destination.toString());
    }

    @Test
    public void destinationOutputForEast() {
        Point point = new Point(2, 2);
        Direction direction = Direction.EAST;
        Destination destination = new Destination(point, direction);
        String expected = "Wall-E's current location is: X=2, Y=2, E";
        Assert.assertEquals(expected, destination.toString());
    }

    @Test
    public void destinationOutputForSouth() {
        Point point = new Point(3, 3);
        Direction direction = Direction.SOUTH;
        Destination destination = new Destination(point, direction);
        String expected = "Wall-E's current location is: X=3, Y=3, S";
        Assert.assertEquals(expected, destination.toString());
    }

    @Test
    public void destinationOutputForWest() {
        Point point = new Point(4, 4);
        Direction direction = Direction.WEST;
        Destination destination = new Destination(point, direction);
        String expected = "Wall-E's current location is: X=4, Y=4, W";
        Assert.assertEquals(expected, destination.toString());
    }
}
