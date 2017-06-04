package com.pendext.junit.util;

import com.pendext.junit.annotations.IntegrationTest;
import org.junit.jupiter.api.*;
import org.slf4j.*;

@IntegrationTest
public interface TestDecorator {

    Logger logger = LoggerFactory.getLogger("test-logger");

    @BeforeAll
    static void beforeAll() {
        // logging or other work here
    }

    @AfterAll
    static void afterAll() {
        // logging or other work here
    }

    @BeforeEach
    default void beforeEach(TestInfo testInfo) {
        // logging or other work here
    }

    @AfterEach
    default void afterEach(TestInfo testInfo) {
        // logging or other work here
    }

}
