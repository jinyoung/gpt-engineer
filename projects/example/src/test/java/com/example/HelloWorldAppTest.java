package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class HelloWorldAppTest {
    @Test
    public void testMain() {
        // Since the main method doesn't return anything, we're just ensuring it runs without exceptions
        HelloWorldApp.main(new String[]{});
        assertTrue(true); // If no exception is thrown, the test passes
    }
}