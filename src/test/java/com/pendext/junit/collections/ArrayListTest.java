package com.pendext.junit.collections;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayListTest {

    @Test
    public void firstArrayListTest() {
        ArrayList<String> listOne = new ArrayList<>();
        ArrayList<String> listTwo = new ArrayList<>();
        assertEquals(listOne.size(), listTwo.size());
    }

    @Test
    public void addingAnItemWorks() {
        ArrayList<String> list = new ArrayList<>();
        list.add("one");
        assertEquals(1, list.size());
    }

    @Test
    public void adding_one_item_to_arrayList_shouldIncrement_sizeOfList() {
        ArrayList<String> list = new ArrayList<>();
        list.add("one");
        assertEquals(1, list.size());
    }

    @Test
    @DisplayName("Adding one item to an array list should increment the size of the list.")
    public void addingAnItemWorksWithDisplayName() {
        ArrayList<String> list = new ArrayList<>();
        list.add("one");
        assertEquals(1, list.size());
    }

}