package com.kasimgul.robot.unittest;

import com.kasimgul.robot.object.Room;
import com.kasimgul.robot.object.CircularRoom;
import com.kasimgul.robot.object.SquareRoom;
import com.kasimgul.robot.ui.UserInterface;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class UserInterfaceTest extends AbstractTest {

    private UserInterface ui;

    @Before
    public void setup() {
        ui = new UserInterface();
    }

    @After
    public void destroy() {
        ui = null;
    }

    @Test
    public void roomSelection_ShouldReturnSquareRoom() {
        systemInMock.provideLines("1");
        Room room = ui.roomSelection();
        assertEquals(SquareRoom.class.getSimpleName(), room.getClass().getSimpleName());
    }

    @Test
    public void roomSelection_ShouldReturnCircularRoom() {
        systemInMock.provideLines("2");
        Room room = ui.roomSelection();
        assertEquals(CircularRoom.class.getSimpleName(), room.getClass().getSimpleName());
    }

    @Test
    public void roomSelection_ShouldReturnNull() {
        systemInMock.provideLines("3");
        Room room = ui.roomSelection();
        assertNull(room);
        String log = errRule.getLog();
        assertTrue(log.contains("Your input is not valid. Please try again!"));
    }

    @Test
    public void handleInvalidDestinationTest() {
        Point point = new Point(0, -1);
        Room room = new SquareRoom();
        ui.handleInvalidDestination(point, room);
        String log = errRule.getLog();
        boolean contains = log.contains("Invalid destination. X=-1, Y=-2");
        assertTrue(contains);
    }

}
