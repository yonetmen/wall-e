package com.kasimgul.robot.object;

import java.awt.*;

public interface Room {

    Point getStartPosition();

    boolean contains(Point position);

}
