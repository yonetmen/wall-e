package com.kasimgul.robot.unittest;

import org.junit.Rule;
import org.junit.contrib.java.lang.system.SystemErrRule;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

public abstract class AbstractTest {

    @Rule
    public final SystemOutRule outRule = new SystemOutRule().enableLog();

    @Rule
    public final SystemErrRule errRule = new SystemErrRule().enableLog();

    @Rule
    public final TextFromStandardInputStream systemInMock =
            TextFromStandardInputStream.emptyStandardInputStream();
}
