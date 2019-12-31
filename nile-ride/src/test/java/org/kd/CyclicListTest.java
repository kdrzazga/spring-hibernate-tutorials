package org.kd;

import org.junit.jupiter.api.Test;
import org.kd.nileride.common.CyclicList;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

//TODO import static org.hamcrest.Matchers.hasSize;

public class CyclicListTest {

    @Test
    public void testShiftLeft2Elements() {
        var list = createTestList(2);
        list.shiftLeft();

        //TODO assertThat(list, hasSize(2));
        assertEquals(Integer.valueOf(2), list.get(0));
        assertEquals(Integer.valueOf(1), list.get(1));
    }

    @Test
    public void testShiftRight2Elements() {
        var list = createTestList(2);
        list.shiftRight();

        //TODO assertThat(list, hasSize(2));
        assertEquals(Integer.valueOf(2), list.get(0));
        assertEquals(Integer.valueOf(1), list.get(1));
    }

    @Test
    public void testShiftLeft5Elements() {
        var list = createTestList(5);
        list.shiftLeft();

        //TODO assertThat(list, hasSize(5));
        assertEquals(Integer.valueOf(5), list.get(3));
        assertEquals(Integer.valueOf(1), list.get(4));
    }

    @Test
    public void testShiftRight5Elements() {
        var list = createTestList(5);
        list.shiftRight();

        //TODO assertThat(list, hasSize(5));
        assertEquals(Integer.valueOf(5), list.get(0));
        assertEquals(Integer.valueOf(1), list.get(1));
    }

    @Test
    public void testAdding() {
        var list = new CyclicList<String>(2);

        list.add("Ala");
        list.add("ma");
        list.add("kota");

        //TODO assertThat(list, hasSize(2));
        assertEquals("ma", list.get(0));
        assertEquals("kota", list.get(1));
    }

    private CyclicList<Integer> createTestList(int elementCount) {
        var list = new CyclicList<Integer>(elementCount);

        IntStream.range(1, elementCount +1).forEach(list::add);
        return list;
    }

}
