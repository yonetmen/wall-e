package com.kasimgul.robot.unittest;

import com.kasimgul.robot.runtime.AppEngine;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AppEngineTest extends AbstractTest {

    private AppEngine appEngine;

    @Before
    public void setup() {
        appEngine = new AppEngine();
    }

    @After
    public void destroy() {
        appEngine = null;
    }

    @Test
    public void selectSquareRoomAndGetFinalResult() {
        systemInMock.provideLines("1", "HGHGGHGHG");
        appEngine.runApplication();
        String log = outRule.getLog();
        Assert.assertTrue(log.contains("X=1, Y=1, N"));
    }

    @Test
    public void selectSquareRoomWithInvalidPath_ShouldFail() {
        systemInMock.provideLines("1", "FFFF");
        appEngine.runApplication();
        String log = errRule.getLog();
        Assert.assertTrue(log.contains("Destination is located outside the room. Wall-E will shut down!"));
    }

    @Test
    public void selectCircularRoomAndGetFinalResult() {
        systemInMock.provideLines("2", "RRFLFFLRF");
        appEngine.runApplication();
        String log = outRule.getLog();
        Assert.assertTrue(log.contains("X=3, Y=-1, E"));
    }

    @Test
    public void selectCircularRoomWithInvalidPath_ShouldFail() {
        systemInMock.provideLines("2", "FFFFFFFFFFF");
        appEngine.runApplication();
        String log = errRule.getLog();
        Assert.assertTrue(log.contains("Destination is located outside the room. Wall-E will shut down!"));
    }

}
