package test;

import org.junit.jupiter.api.*;
import src.Main;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    Main main = new Main();

    @Test
    public void testArrayListWriteOperations() {
        List<String> input = Arrays.asList("A", "B", "C");
        List<String> result = main.arrayListWriteOperations(input, "D", 1);
        assertEquals(Arrays.asList("A", "C", "D"), result);
    }

    @Test
    public void testArrayListReadOperations() {
        List<String> input = Arrays.asList("A", "B", "C");
        String result = main.arrayListReadOperations(input, 2);
        assertEquals("C", result);
    }

    @Test
    public void testLinkedListWriteOperations() {
        List<String> input = Arrays.asList("A", "B", "C");
        List<String> result = main.linkedListWriteOperations(input, "D", 0);
        assertEquals(Arrays.asList("B", "C", "D"), result);
    }

    @Test
    public void testLinkedListReadOperations() {
        List<String> input = Arrays.asList("A", "B", "C");
        String result = main.linkedListReadOperations(input, 1);
        assertEquals("B", result);
    }

    @Test
    public void testHashSetWriteOperations() {
        Set<String> input = new HashSet<>(Arrays.asList("A", "B"));
        Set<String> result = main.hashSetWriteOperations(input, "C", "A");
        assertTrue(result.contains("B"));
        assertTrue(result.contains("C"));
        assertFalse(result.contains("A"));
    }

    @Test
    public void testHashSetReadOperations() {
        Set<String> input = new HashSet<>(Arrays.asList("A", "B", "C"));
        assertTrue(main.hashSetReadOperations(input, "B"));
        assertFalse(main.hashSetReadOperations(input, "D"));
    }

    @Test
    public void testHashMapWriteOperations() {
        Map<Integer, String> input = new HashMap<>(Map.of(1, "A", 2, "B"));
        Map<Integer, String> result = main.hashMapWriteOperations(input, 3, "C", 1);
        assertTrue(result.containsKey(2));
        assertTrue(result.containsKey(3));
        assertFalse(result.containsKey(1));
        assertEquals("C", result.get(3));
    }

    @Test
    public void testHashMapReadOperations() {
        Map<Integer, String> input = new HashMap<>(Map.of(1, "A", 2, "B", 3, "C"));
        assertEquals("B", main.hashMapReadOperations(input, 2));
        assertNull(main.hashMapReadOperations(input, 4));
    }

    @Test
    public void testPriorityQueueWriteOperations() {
        Queue<String> input = new PriorityQueue<>(Arrays.asList("B", "A"));
        Queue<String> result = main.priorityQueueWriteOperations(input, "C");
        assertEquals("A", result.peek());
    }

    @Test
    public void testPriorityQueueReadOperations() {
        Queue<String> input = new PriorityQueue<>(Arrays.asList("B", "A", "C"));
        assertEquals("A", main.priorityQueueReadOperations(input));
    }

    @Test
    public void testStackWriteOperations() {
        Deque<String> input = new ArrayDeque<>(Arrays.asList("A", "B"));
        Deque<String> result = main.stackWriteOperations(input, "C");
        assertEquals("C", result.peek());
    }

    @Test
    public void testStackReadOperations() {
        Deque<String> input = new ArrayDeque<>(Arrays.asList("A", "B"));
        assertEquals("B", main.stackReadOperations(input));
    }
}
