package com.pendext.junit.util;

import java.io.IOException;

public interface Testable<T> {
    T createObject() throws IOException;
}
