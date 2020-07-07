package lesson4Test;

import inf.lesson4.ModCollection;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class ModCollectionTest {

    public static ModCollection<Integer> mc;

    @BeforeAll
    public static void create() {
        mc = new ModCollection<>();
    }

    @Test
    public void iterator() {
        mc.add(1);
        mc.add(2);
        assertTrue(mc.iterator() instanceof Iterator);
    }

    @Test
    public void size() {
        assertEquals(0, mc.size());
    }

    @Test
    public void size1() {
        mc.add(1);
        mc.add(2);
        mc.remove(3);
        assertEquals(2, mc.size());
    }

    @Test
    public void size2() {
        mc.add(2);
        mc.add(3);
        mc.remove(3);
        assertEquals(1, mc.size());
    }

    @Test
    public void size3() {
        mc.add(null);
        mc.add(3);
        mc.remove(3);
        assertEquals(1, mc.size());
    }

    @Test
    public void add() {
        assertTrue(mc.add(1));
    }

    @Test
    public void add2() {
        mc.add(3);
        assertEquals(1, mc.size());
    }

    @Test
    public void add3() {
        mc.add(3);
        mc.add(3);
        mc.remove(3);
        assertEquals(1, mc.size());
    }

    @Test
    public void remove() {
        mc.add(1);
        assertTrue(mc.remove(1));
    }

    @Test
    public void remove1() {
        mc.add(1);
        assertFalse(mc.remove(2));
    }

    @Test
    public void remove2() {
        mc.add(1);
        mc.add(2);
        mc.add(3);
        mc.remove(2);
        assertNotSame(Arrays.toString(new int[]{1, 3}), mc.toString());
    }
}
