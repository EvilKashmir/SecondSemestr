package lesson6Test;

import inf.lesson6.MyMap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyMapTest {

    public static MyMap<Integer, Integer> map;

    @BeforeAll
    public static void create() {
        map = new MyMap<>();
        map.put(1, 1);
    }

    @Test
    public void size() {
        assertNotEquals(0, map.size());
    }

    @Test
    void size1() {
        map.put(2, 2);
        assertEquals(2, map.size());
    }

    @Test
    void size2() {
        map.put(2, 2);
        map.remove(1);
        assertEquals(1, map.size());
    }

    @Test
    public void isEmpty() {
        assertFalse(map.isEmpty());
    }

    @Test
    public void isEmpty1() {
        map.remove(1);
        assertTrue(map.isEmpty());
    }

    @Test
    public void containsKey() {
        assertTrue(map.containsKey(1));
    }

    @Test
    public void containsKey1() {
        assertFalse(map.containsKey(2));
    }

    @Test
    public void containsKey2() {
        try {
            map.containsKey(null);
            Assertions.fail("Expected NullPointerException");
        } catch (NullPointerException e) {
            assertEquals("Null element", e.getMessage());
        }
    }

    @Test
    public void containsValue() {
        assertTrue(map.containsValue(1));
    }

    @Test
    public void containsValue1() {
        assertFalse(map.containsValue(2));
    }

    @Test
    public void containsValue2() {
        try {
            map.containsValue(null);
            Assertions.fail("Expected NullPointerException");
        } catch (NullPointerException e) {
            assertEquals("Null element", e.getMessage());
        }
    }

    @Test
    public void get() {
        assertEquals(1, map.get(1));
    }

    @Test
    public void get1() {
        try {
            map.get(null);
        } catch (NullPointerException e) {
            assertNull(e.getMessage());
        }
    }

    @Test
    public void get2() {
        assertNull(map.get(2));
    }

    @Test
    public void put() {
        assertNull(map.put(2, 2));
    }

    @Test
    public void put1() {
        try {
            map.put(null, null);
        } catch (NullPointerException e) {
            assertNull(e.getMessage());
        }
    }

    @Test
    public void put2() {
        try {
            map.put(null, 2);
        } catch (NullPointerException e) {
            assertNull(e.getMessage());
        }
    }

    @Test
    public void put3() {
        try {
            map.put(2, null);
        } catch (NullPointerException e) {
            assertNull(e.getMessage());
        }
    }

    @Test
    public void remove() {
        assertEquals(1, map.remove(1));
    }

    @Test
    public void remove1() {
        try {
            map.remove(null);
        } catch (NullPointerException e) {
            assertNull(e.getMessage());
        }
    }

    @Test
    public void remove2() {
        assertNull(map.remove(2));
    }

    @Test
    public void clear() {
        map.clear();
        assertEquals(0, map.size());
    }
}