package com.kasimgul.robot.unittest;

import com.kasimgul.robot.geo.Direction;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class DirectionTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void getNorthWithCorrectId_ShouldMatch() {
        Direction actual = Direction.NORTH;
        Direction expected = Direction.getDirectionById(1);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getNorthWithIncorrectId_ShouldNotMatch() {
        Direction actual = Direction.NORTH;
        Direction expected = Direction.getDirectionById(2);
        Assert.assertNotEquals(expected, actual);
    }

    @Test
    public void getEastWithCorrectId_ShouldMatch() {
        Direction actual = Direction.EAST;
        Direction expected = Direction.getDirectionById(2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getEastWithIncorrectId_ShouldNotMatch() {
        Direction actual = Direction.EAST;
        Direction expected = Direction.getDirectionById(3);
        Assert.assertNotEquals(expected, actual);
    }

    @Test
    public void getSouthWithCorrectId_ShouldMatch() {
        Direction actual = Direction.SOUTH;
        Direction expected = Direction.getDirectionById(3);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getSouthWithIncorrectId_ShouldNotMatch() {
        Direction actual = Direction.SOUTH;
        Direction expected = Direction.getDirectionById(4);
        Assert.assertNotEquals(expected, actual);
    }

    @Test
    public void getWestWithCorrectId_ShouldMatch() {
        Direction actual = Direction.WEST;
        Direction expected = Direction.getDirectionById(4);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getWestWithIncorrectId_ShouldNotMatch() {
        Direction actual = Direction.WEST;
        Direction expected = Direction.getDirectionById(1);
        Assert.assertNotEquals(expected, actual);
    }

    @Test
    public void getDirectionWithInvalidId_ShouldThrowIllegalArgumentException() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Invalid input. There are only four directions.");
        Direction notExist = Direction.getDirectionById(5);
    }

}
