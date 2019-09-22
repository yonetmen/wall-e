package com.kasimgul.robot.utility;

import java.util.Arrays;
import java.util.List;

public class PathValidator {

    private static final List<String> validCommands = Arrays.asList("V", "H", "G", "L", "R", "F");

    private PathValidator() {/* No instance is allowed */}

    public static boolean isValid(String path) {
        List<String> pathList = Arrays.asList(path.toUpperCase().split(""));

        boolean valid = pathList.stream()
                .anyMatch(item -> !validCommands.contains(item));

        return !valid;
    }
}
