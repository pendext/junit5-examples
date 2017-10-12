package com.pendext.junit.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.io.IOException;

public interface EqualsTestable<T> extends Testable<T> {

    T createUnequalObject() throws IOException;

    @Test
    default void objectEqualsItself() throws IOException {
        T value = createObject();
        assertEquals(value, value);
    }

    @Test
    default void objectDoesNotEqualNull() throws IOException {
        T value = createObject();
        assertFalse(value.equals(null));
    }

}
