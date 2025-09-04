import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    @Test
    public void testInstanceRelationships() {
        AbstractAnimal dog = new Dog();
        AbstractAnimal cat = new Cat();
        AbstractAnimal eagle = new Eagle();
        AbstractAnimal shark = new Shark();
        AbstractAnimal dolphin = new Dolphin();
        AbstractAnimal bat = new Bat();
        AbstractAnimal frog = new Frog();
        AbstractAnimal duck = new Duck();
        AbstractAnimal penguin = new Penguin();
        AbstractAnimal bear = new Bear();

        // Test general AbstractAnimal instances
        assertTrue(dog instanceof AbstractAnimal);
        assertTrue(cat instanceof AbstractAnimal);
        assertTrue(eagle instanceof AbstractAnimal);
        assertTrue(shark instanceof AbstractAnimal);
        assertTrue(dolphin instanceof AbstractAnimal);
        assertTrue(bat instanceof AbstractAnimal);
        assertTrue(frog instanceof AbstractAnimal);
        assertTrue(duck instanceof AbstractAnimal);
        assertTrue(penguin instanceof AbstractAnimal);
        assertTrue(bear instanceof AbstractAnimal);

        // Test that all are instances of LivingThing
        assertTrue(dog instanceof LivingThing);
        assertTrue(cat instanceof LivingThing);
        assertTrue(eagle instanceof LivingThing);
        assertTrue(shark instanceof LivingThing);
        assertTrue(dolphin instanceof LivingThing);
        assertTrue(bat instanceof LivingThing);
        assertTrue(frog instanceof LivingThing);
        assertTrue(duck instanceof LivingThing);
        assertTrue(penguin instanceof LivingThing);
        assertTrue(bear instanceof LivingThing);

        // Test specific classifications
        assertTrue(dog instanceof Mammal);
        assertTrue(cat instanceof Mammal);
        assertTrue(eagle instanceof Bird);
        assertTrue(shark instanceof Fish);
        assertTrue(dolphin instanceof Mammal);
        assertTrue(bat instanceof Mammal);
        assertTrue(frog instanceof Amphibian);
        assertTrue(duck instanceof Bird);
        assertTrue(penguin instanceof Bird);
        assertTrue(bear instanceof Mammal);

        // Test aquatic, terrestrial, and aerial classifications
        assertTrue(shark instanceof Aquatic);
        assertTrue(dolphin instanceof Aquatic);
        assertTrue(frog instanceof Aquatic);
        assertTrue(duck instanceof Aquatic);
        assertTrue(penguin instanceof Aquatic);
        
        assertTrue(dog instanceof Terrestrial);
        assertTrue(cat instanceof Terrestrial);
        assertTrue(bear instanceof Terrestrial);
        assertTrue(frog instanceof Terrestrial);
        assertTrue(duck instanceof Terrestrial);
        assertTrue(penguin instanceof Terrestrial);
        
        assertTrue(eagle instanceof Aerial);
        assertTrue(bat instanceof Aerial);
        assertTrue(duck instanceof Aerial);
    }

    @Test
    public void testNameFieldInAbstractAnimal() {
        AbstractAnimal dog = new Dog();
        dog.setName("Buddy");
        assertEquals("Buddy", dog.getName());

        AbstractAnimal cat = new Cat();
        cat.setName("Whiskers");
        assertEquals("Whiskers", cat.getName());
    }

    @Test
    public void testBreatheMethod() {
        LivingThing[] livingThings = {new Dog(), new Cat(), new Eagle(), new Shark(), new Dolphin(), new Bat(), new Frog(), new Duck(), new Penguin(), new Bear()};
        
        for (LivingThing livingThing : livingThings) {
            livingThing.breathe(); // Ensuring all living things can breathe
        }
    }

    @Test
    public void testCarnivoresEatAnimal() {
        Animal testAnimal = new Animal() {};
        Carnivorous[] carnivores = {new Dog(), new Cat(), new Eagle(), new Shark(), new Dolphin(), new Frog(), new Penguin(), new Bat(), new Duck(), new Bear()};
        
        for (Carnivorous carnivore : carnivores) {
            carnivore.eatAnimal(testAnimal);
        }
    }

    @Test
    public void testHerbivoresEatPlant() {
        Plant testPlant = new Plant() {};
        Herbivorous[] herbivores = {new Bat(), new Duck(), new Bear()};
        
        for (Herbivorous herbivore : herbivores) {
            herbivore.eatPlant(testPlant);
        }
    }

    @Test
    public void testOmnivoresEatBoth() {
        Animal testAnimal = new Animal() {};
        Plant testPlant = new Plant() {};
        Omnivorous[] omnivores = {new Bat(), new Duck(), new Bear()};
        
        for (Omnivorous omnivore : omnivores) {
            omnivore.eatAnimal(testAnimal);
            omnivore.eatPlant(testPlant);
        }
    }

    @Test
    public void testTerrestrialsWalk() {
        Terrestrial[] terrestrials = {new Dog(), new Cat(), new Bear(), new Frog(), new Duck(), new Penguin()};
        
        for (Terrestrial terrestrial : terrestrials) {
            terrestrial.walk();
        }
    }

    @Test
    public void testAerialsFly() {
        Aerial[] aerials = {new Eagle(), new Bat(), new Duck()};
        
        for (Aerial aerial : aerials) {
            aerial.fly();
        }
    }

    @Test
    public void testAquaticsSwim() {
        Aquatic[] aquatics = {new Shark(), new Dolphin(), new Frog(), new Duck(), new Penguin()};
        
        for (Aquatic aquatic : aquatics) {
            aquatic.swim();
        }
    }
}
