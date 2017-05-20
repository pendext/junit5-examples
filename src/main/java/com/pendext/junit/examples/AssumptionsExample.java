package com.pendext.junit.examples;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

import org.junit.jupiter.api.*;

public class AssumptionsExample {

    @Test
    public void validAssumption() {
        assumeTrue(System.getProperty("user.country").equals("US")); // allows the test to continue
        assertEquals(2, 3);
    }

    @Test
    public void invalidAssumption() {
        assumeTrue("CI".equals(System.getenv("ENV")),
                () -> "Test is not valid - not run on CI machine."); // does not allow the test to continue
        assertEquals(2, 2);
    }

    @Test
    public void assumingExample() {
        assumingThat(System.getProperty("user.country").equals("CZ"),
                () -> assertEquals(2, 3)); // test wrapped in assumingThat does not get executed
        assertEquals("a string", "a string");
    }

    @Test
    public void assumingExampleWithAssertAll() {
        assertAll("Show usage of assumptions within an assertAll",
                () -> assumingThat(System.getProperty("user.country").equals("CZ"), () -> assertEquals(3, 3)),
                () -> assumingThat(System.getProperty("user.country").equals("US"), () -> assertEquals(2, 3)),
                () -> assumingThat(System.getProperty("user.country").equals("US"), () -> assertEquals("expected", "actual")),
                () -> assertEquals("a string", "a string"));
    }

}

