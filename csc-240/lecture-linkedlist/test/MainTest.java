
// MainTest.java to test functionality using JUnit
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MainTest {

    @Test
    public void testSLList() {
        SLList<Integer> slList = Main.createSLList();
        slList.addFirst(1);
        slList.addLast(2);
        assertArrayEquals(new Integer[]{1, 2}, slList.toArray());
    }

    @Test
    public void testDLList() {
        DLList<Integer> dlList = Main.createDLList();
        dlList.addFirst(10);
        dlList.addLast(20);
        assertArrayEquals(new Integer[]{10, 20}, dlList.toArray());
    }

    @Test
    public void testSEList() {
        SEList<Integer> seList = Main.createSEList();
        seList.add(100);
        seList.add(200);
        assertArrayEquals(new Integer[]{100, 200}, seList.toArray());
    }
}
