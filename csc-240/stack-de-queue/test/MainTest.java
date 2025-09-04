import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Queue;
import java.util.Stack;

public class MainTest {
    private LinkedListQueue<Integer> queue;
    private ArrayStack<Integer> stack;
    private ArrayDeque<Integer> deque;
    private Word word;

    @BeforeEach
    void setUp() {
        queue = new LinkedListQueue<>();
        stack = new ArrayStack<>();
        deque = new ArrayDeque<>();
        word = new Word();
    }

    // Test LinkedListQueue
    @Test
    void testQueueOperations() {
        queue.add(1);
        queue.add(2);
        queue.add(3);
        assertEquals(1, queue.remove());
        assertEquals(2, queue.peek());
        assertFalse(queue.isEmpty());
    }

    // Test ArrayStack
    @Test
    void testStackOperations() {
        stack.push(10);
        stack.push(20);
        stack.push(30);
        assertEquals(30, stack.pop());
        assertEquals(20, stack.peek());
        assertFalse(stack.isEmpty());
    }

    // Test Word isStackPalindrome using Stack
    @Test
    void testWordIsStackPalindromeStack() {
        assertTrue(word.isStackPalindrome("racecar"));
        assertFalse(word.isStackPalindrome("hello"));
    }

    // Test Deque Operations
    @Test
    void testDequeOperations() {
        deque.addFirst(5);
        deque.addLast(10);
        deque.addFirst(2);
        assertEquals(2, deque.removeFirst());
        assertEquals(10, deque.removeLast());
        assertFalse(deque.isEmpty());
    }

    // Test Word isPalindrome using Deque
    @Test
    void testWordIsPalindromeDeque() {
        assertTrue(word.isDequePalindrome("madam"));
        assertFalse(word.isDequePalindrome("world"));
    }
}
