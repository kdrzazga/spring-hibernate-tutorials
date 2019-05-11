package org.kd;

import org.junit.Test;
import org.kd.common.CyclicList;

import java.util.stream.IntStream;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class CyclicListTest {

    @Test
    public void testShiftLeft2Elements() {
        var list = createTestList(2);
        list.shiftLeft();

        assertThat(list, hasSize(2));
        assertEquals(Integer.valueOf(2), list.get(0));
        assertEquals(Integer.valueOf(1), list.get(1));
    }

    @Test
    public void testShiftRight2Elements() {
        var list = createTestList(2);
        list.shiftRight();

        assertThat(list, hasSize(2));
        assertEquals(Integer.valueOf(2), list.get(0));
        assertEquals(Integer.valueOf(1), list.get(1));
    }

    @Test
    public void testShiftLeft5Elements() {
        var list = createTestList(5);
        list.shiftLeft();

        assertThat(list, hasSize(5));
        assertEquals(Integer.valueOf(5), list.get(3));
        assertEquals(Integer.valueOf(1), list.get(4));
    }

    @Test
    public void testShiftRight5Elements() {
        var list = createTestList(5);
        list.shiftRight();

        assertThat(list, hasSize(5));
        assertEquals(Integer.valueOf(5), list.get(0));
        assertEquals(Integer.valueOf(1), list.get(1));
    }

    @Test
    public void testAdding() {
        var list = new CyclicList<String>(2);

        list.add("Ala");
        list.add("ma");
        list.add("kota");

        assertThat(list, hasSize(2));
        assertEquals("ma", list.get(0));
        assertEquals("kota", list.get(1));
    }

    private CyclicList<Integer> createTestList(int elementCount) {
        var list = new CyclicList<Integer>(elementCount);

        IntStream.range(1, elementCount +1).forEach(list::add);
        return list;
    }

}
