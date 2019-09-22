package com.kasimgul.robot.unittest;

import com.kasimgul.robot.geo.Destination;
import com.kasimgul.robot.object.Room;
import com.kasimgul.robot.object.SquareRoom;
import com.kasimgul.robot.object.Wall_E;
import com.kasimgul.robot.ui.UserInterface;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.awt.*;

@RunWith(MockitoJUnitRunner.class)
public class RobotTest extends AbstractTest {

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void goToDestinationGivenValidPath_ShouldOutputResult() {
        Room room = Mockito.mock(SquareRoom.class);
        UserInterface userInterface = new UserInterface();
        Point currentLocation = new Point(1, 2);
        Mockito.when(room.getStartPosition()).thenReturn(currentLocation);
        Wall_E wallE = new Wall_E(room, userInterface);
        String path = "HGHGGHGHG";
        Destination destination = wallE.gotoDestination(path);
        Assert.assertEquals("Wall-E's current location is: X=1, Y=1, N", destination.toString());
    }

    @Test
    public void goToDestinationGivenInvalidPath_ShouldReturnErrorMsg() {
        Room room = Mockito.mock(SquareRoom.class);
        UserInterface userInterface = new UserInterface();
        Point currentLocation = new Point(1, 2);
        Mockito.when(room.getStartPosition()).thenReturn(currentLocation);
        Wall_E wallE = new Wall_E(room, userInterface);
        String path = "FFFFF";
        Destination destination = wallE.gotoDestination(path);
        Assert.assertEquals("Wall-E's current location is: X=1, Y=7, N", destination.toString());
        Assert.assertTrue(errRule.getLog().contains("Destination is located outside the room. Wall-E will shut down!"));
    }

}
