package com.pendext.junit.collections;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayListTest {

    @Test
    public void firstArrayListTest() {
        ArrayList<String> listOne = new ArrayList<>();
        ArrayList<String> listTwo = new ArrayList<>();
        assertEquals(listOne.size(), listTwo.size());
    }

}