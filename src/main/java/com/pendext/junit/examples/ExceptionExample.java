package com.pendext.junit.examples;

import com.sun.org.apache.xalan.internal.xsltc.compiler.CompilerException;

import java.io.IOException;
import java.util.ConcurrentModificationException;

public class ExceptionExample {

    public void basicExceptionExample(String message) throws IOException {
        throw new IOException(message);
    }

    public void variousExceptionsExample(int i) throws Exception {
        switch(i) {
            case 1:
                throw new IOException();
            case 2:
                throw new RuntimeException();
            case 3:
                throw new ClassCastException();
            case 4:
                throw new ArrayIndexOutOfBoundsException();
            case 5:
                throw new CompilerException();
            default:
                throw new ConcurrentModificationException();
        }
    }

}
