public class HikingPacking {
    /*
     * You are planning a hiking trip and have limited carrying capacity.
     * Each item has a weight and a value (importance for survival).
     * Your goal is to determine the **maximum value** of items you can pack
     * without exceeding your weight limit.
     * Implement a method that finds the best selection of items and returns them in a packed backpack.
     * 
     * Points: 50
     */

    // Inner class representing a backpack
        // Inner class representing a backpack
    public static class Backpack {
        private int capacity;
        private List<Item> packedItems;

        public Backpack(int capacity) {
            this.capacity = capacity;
            this.packedItems = new ArrayList<>();
        }

        public int getCapacity() {
            return capacity;
        }

        public void addItem(Item item) {
            packedItems.add(item);
        }

        public int getTotalWeight() {
            int totalWeight = 0;
            for (Item item : packedItems) {
                totalWeight += item.getWeight();
            }
            return totalWeight;
        }

        public int getTotalValue() {
            int totalValue = 0;
            for (Item item : packedItems) {
                totalValue += item.getValue();
            }
            return totalValue;
        }

        public Backpack copy() {
            Backpack newBackpack = new Backpack(this.capacity);
            for (Item item : this.packedItems) {
                newBackpack.addItem(item);
            }
            return newBackpack;
        }
    }
    // Inner class representing an item
    public static class Item {
        private int weight;
        private int value;

        public Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }

        public int getWeight() {
            return weight;
        }

        public int getValue() {
            return value;
        }
    }

    /**
     * Selects the optimal set of items that maximize survival value while staying within weight limits.
     * @param backpack The backpack object with capacity.
     * @param items List of items available for packing.
     * @return A packed Backpack with the optimal set of items.
     */
    public static Backpack packForHiking(Backpack backpack, List<Item> items) {
        // TODO: Implement Dynamic Programming approach to optimize item selection
        return new Backpack(backpack.getCapacity()); // Placeholder: Returns an empty backpack
    }
}
