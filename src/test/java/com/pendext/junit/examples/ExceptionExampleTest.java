package com.pendext.junit.examples;

import static org.junit.jupiter.api.Assertions.*;

import com.sun.org.apache.xalan.internal.xsltc.compiler.CompilerException;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.*;

import java.io.IOException;

class ExceptionExampleTest {

    private ExceptionExample exceptionExample;

    @BeforeEach
    public void initialize() {
        exceptionExample = new ExceptionExample();
    }

    @Test
    @DisplayName("This test should throw an IO exception. ")
    public void basicExceptionExample() {
        String expectedMessage = RandomStringUtils.randomAlphabetic(10);
        Throwable actualException = assertThrows(IOException.class, () ->
                exceptionExample.basicExceptionExample(expectedMessage)
        );
        assertEquals(expectedMessage, actualException.getMessage());
    }

    @Test
    @DisplayName("This test shows the assertThrows assertion within an assertAll")
    public void variousExceptionsExampleWithLambdas() {
        assertAll("Test against various exceptions being throw from a single method",
                () -> {
                    Throwable actualException = assertThrows(IOException.class, () ->
                            exceptionExample.variousExceptionsExample(1)
                    );
                    assertEquals("expected message", actualException.getMessage());
                },
                () -> assertThrows(RuntimeException.class, () ->
                        exceptionExample.variousExceptionsExample(1)
                ),
                () -> assertThrows(ClassCastException.class, () ->
                        exceptionExample.variousExceptionsExample(2)
                ),
                () -> assertThrows(CompilerException.class, () ->
                        exceptionExample.variousExceptionsExample(4)
                )
        );
    }

}