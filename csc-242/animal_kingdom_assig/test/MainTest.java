// MainTest class for testing the methods
public class MainTest {
    @Test
    public void testExploreISARelationship() {
        Main main = new Main();
        Animal animal = main.exploreISARelationship();
        assertTrue(animal instanceof Mammal);
    }

    @Test
    public void testExploreHASARelationship() {
        Main main = new Main();
        Animal animal = main.exploreHASARelationship();
        assertEquals("River", animal.getHabitat().getName());
    }

    @Test
    public void testAnimalSounds() {
        Main main = new Main();
        String sound = main.testAnimalSounds();
        assertEquals("Parrot chirps!", sound);
    }

    @Test
    public void testCreateLionClass() {
        Main main = new Main();
        Mammal lion = main.createLionClass();
        assertEquals("Lion roars!", lion.makeSound());
        assertEquals("Savanna", lion.getHabitat().getName());
    }