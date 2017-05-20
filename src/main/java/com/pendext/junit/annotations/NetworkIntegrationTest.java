package com.pendext.junit.annotations;

import org.junit.jupiter.api.Tag;

import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@IntegrationTest
@Tag("requires network")
public @interface NetworkIntegrationTest {
}
