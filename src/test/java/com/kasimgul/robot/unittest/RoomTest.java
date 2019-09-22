package com.kasimgul.robot.unittest;

import com.kasimgul.robot.object.Room;
import com.kasimgul.robot.object.RoomCircle;
import com.kasimgul.robot.object.RoomSquare;
import org.junit.Assert;
import org.junit.Test;

import java.awt.*;

public class RoomTest {

    @Test
    public void squareRoomValidPath_ShouldReturnTrue() {
        Room room = new RoomSquare();
        Point point = new Point(1, 2);
        boolean contains = room.contains(point);
        Assert.assertTrue(contains);
    }

    @Test
    public void squareRoomInvalidPath_ShouldReturnFalse() {
        Room room = new RoomSquare();
        Point invalidY = new Point(1, 6);
        boolean contains = room.contains(invalidY);
        Assert.assertFalse(contains);

        Point invalidX = new Point(6, 1);
        contains = room.contains(invalidX);
        Assert.assertFalse(contains);
    }

    @Test
    public void circleRoomValidPath_ShouldReturnTrue() {
        Room room = new RoomCircle();
        Point point = new Point(5, 5);
        boolean contains = room.contains(point);
        Assert.assertTrue(contains);
    }

    @Test
    public void circleRoomInvalidPath_ShouldReturnFalse() {
        Room room = new RoomCircle();
        Point invalidY = new Point(5, 11);
        boolean contains = room.contains(invalidY);
        Assert.assertFalse(contains);

        Point invalidX = new Point(11, 5);
        contains = room.contains(invalidX);
        Assert.assertFalse(contains);
    }
}
