package com.kasimgul.robot.unittest;

import com.kasimgul.robot.utility.PathValidator;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PathValidatorTest {

    @Test
    public void inputValidatorGivenValidCommands_ShouldReturnTrue() {
        String validPathList = "VHGFLLRFGH";
        boolean valid = PathValidator.isValid(validPathList);
        assertTrue(valid);

        String validPath = "V";
        valid = PathValidator.isValid(validPath);
        assertTrue(valid);
    }

    @Test
    public void inputValidatorGivenInvalidCommands_ShouldReturnFalse() {
        String invalidPathList = "VHGFLXRFGH";
        boolean valid = PathValidator.isValid(invalidPathList);
        assertFalse(valid);

        String invalidPath = "X";
        valid = PathValidator.isValid(invalidPath);
        assertFalse(valid);
    }
}
