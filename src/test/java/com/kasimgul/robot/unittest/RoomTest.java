package com.kasimgul.robot.unittest;

import com.kasimgul.robot.object.Room;
import com.kasimgul.robot.object.CircularRoom;
import com.kasimgul.robot.object.SquareRoom;
import org.junit.Assert;
import org.junit.Test;

import java.awt.*;

public class RoomTest {

    @Test
    public void squareRoomValidPath_ShouldReturnTrue() {
        Room room = new SquareRoom();
        Point point = new Point(1, 2);
        boolean contains = room.contains(point);
        Assert.assertTrue(contains);
    }

    @Test
    public void squareRoomInvalidPath_ShouldReturnFalse() {
        Room room = new SquareRoom();
        Point invalidY = new Point(1, 6);
        boolean contains = room.contains(invalidY);
        Assert.assertFalse(contains);

        Point invalidX = new Point(6, 1);
        contains = room.contains(invalidX);
        Assert.assertFalse(contains);
    }

    @Test
    public void circularRoomValidPath_ShouldReturnTrue() {
        Room room = new CircularRoom();
        Point point = new Point(5, 5);
        boolean contains = room.contains(point);
        Assert.assertTrue(contains);
    }

    @Test
    public void circularRoomInvalidPath_ShouldReturnFalse() {
        Room room = new CircularRoom();
        Point invalidY = new Point(5, 10);
        boolean contains = room.contains(invalidY);
        Assert.assertFalse(contains);

        Point invalidX = new Point(10, 5);
        contains = room.contains(invalidX);
        Assert.assertFalse(contains);

        invalidY = new Point(5, -10);
        contains = room.contains(invalidY);
        Assert.assertFalse(contains);

        invalidX = new Point(-10, 5);
        contains = room.contains(invalidX);
        Assert.assertFalse(contains);
    }
}
