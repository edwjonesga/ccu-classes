import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class MainTest {

    @Test
    public void testEmptyItems() {
        HikingPacking.Backpack backpack = new HikingPacking.Backpack(10);
        List<HikingPacking.Item> items = new ArrayList<>();
        HikingPacking.Backpack packedBackpack = HikingPacking.packForHiking(backpack, items);
        assertEquals(0, packedBackpack.getTotalWeight());
        assertEquals(0, packedBackpack.getTotalValue());
    }

    @Test
    public void testEmptyBackpack() {
        HikingPacking.Backpack backpack = new HikingPacking.Backpack(0);
        List<HikingPacking.Item> items = new ArrayList<>();
        items.add(new HikingPacking.Item(5, 10));
        HikingPacking.Backpack packedBackpack = HikingPacking.packForHiking(backpack, items);
        assertEquals(0, packedBackpack.getTotalWeight());
        assertEquals(0, packedBackpack.getTotalValue());
    }

    @Test
    public void testSingleItemFits() {
        HikingPacking.Backpack backpack = new HikingPacking.Backpack(10);
        List<HikingPacking.Item> items = new ArrayList<>();
        items.add(new HikingPacking.Item(5, 10));
        HikingPacking.Backpack packedBackpack = HikingPacking.packForHiking(backpack, items);
        assertEquals(5, packedBackpack.getTotalWeight());
        assertEquals(10, packedBackpack.getTotalValue());
    }

    @Test
    public void testSingleItemDoesNotFit() {
        HikingPacking.Backpack backpack = new HikingPacking.Backpack(5);
        List<HikingPacking.Item> items = new ArrayList<>();
        items.add(new HikingPacking.Item(10, 20));
        HikingPacking.Backpack packedBackpack = HikingPacking.packForHiking(backpack, items);
        assertEquals(0, packedBackpack.getTotalWeight());
        assertEquals(0, packedBackpack.getTotalValue());
    }

    @Test
    public void testMultipleItemsSomeFit() {
        HikingPacking.Backpack backpack = new HikingPacking.Backpack(10);
        List<HikingPacking.Item> items = new ArrayList<>();
        items.add(new HikingPacking.Item(5, 10));
        items.add(new HikingPacking.Item(3, 7));
        items.add(new HikingPacking.Item(8, 15));
        HikingPacking.Backpack packedBackpack = HikingPacking.packForHiking(backpack, items);
        // Assuming the optimal solution is to take the first two items
        assertEquals(8, packedBackpack.getTotalWeight());
        assertEquals(17, packedBackpack.getTotalValue());
    }

    @Test
    public void testMultipleItemsAllFit() {
        HikingPacking.Backpack backpack = new HikingPacking.Backpack(20);
        List<HikingPacking.Item> items = new ArrayList<>();
        items.add(new HikingPacking.Item(5, 10));
        items.add(new HikingPacking.Item(3, 7));
        items.add(new HikingPacking.Item(8, 15));
        HikingPacking.Backpack packedBackpack = HikingPacking.packForHiking(backpack, items);
        assertEquals(16, packedBackpack.getTotalWeight());
        assertEquals(32, packedBackpack.getTotalValue());
    }

    @Test
    public void testMultipleItemsWithOptimalSelection() {
        HikingPacking.Backpack backpack = new HikingPacking.Backpack(8);
        List<HikingPacking.Item> items = new ArrayList<>();
        items.add(new HikingPacking.Item(4, 60));
        items.add(new HikingPacking.Item(4, 200));
        items.add(new HikingPacking.Item(1, 20));
        items.add(new HikingPacking.Item(3, 70));

        HikingPacking.Backpack packedBackpack = HikingPacking.packForHiking(backpack, items);
        assertEquals(290, packedBackpack.getTotalValue());
        assertEquals(8, packedBackpack.getTotalWeight());
    }

    @Test
    public void testCopyBackpack(){
        HikingPacking.Backpack backpack = new HikingPacking.Backpack(10);
        List<HikingPacking.Item> items = new ArrayList<>();
        items.add(new HikingPacking.Item(5, 10));
        backpack.addItem(items.get(0));
        HikingPacking.Backpack copyBackpack = backpack.copy();
        assertEquals(backpack.getCapacity(), copyBackpack.getCapacity());
        assertEquals(backpack.getTotalWeight(), copyBackpack.getTotalWeight());
        assertEquals(backpack.getTotalValue(), copyBackpack.getTotalValue());
    }
}