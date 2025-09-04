// Base class: Animal
public abstract class Animal {
    private String name;
    private Habitat habitat;

    public Animal(String name, Habitat habitat) {
        this.name = name;
        this.habitat = habitat;
    }

    public String getName() {
        return name;
    }

    public Habitat getHabitat() {
        return habitat;
    }

    public abstract String makeSound();

    public String getDescription() {
        return name + " lives in the " + habitat.getName();
    }
}

// Composition class: Habitat
class Habitat {
    private String name;

    public Habitat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Derived class: Mammal
class Mammal extends Animal {
    public Mammal(String name, Habitat habitat) {
        super(name, habitat);
    }

    @Override
    public String makeSound() {
        return getName() + " various sounds!";
    }

  
}

// Derived class: Bird
class Bird extends Animal {
    public Bird(String name, Habitat habitat) {
        super(name, habitat);
    }

    @Override
    public String makeSound() {
        return getName() + " chirps!";
    }

 

}

// Main class for testing
public class Main {
    // Method 1: Explore IS-A relationship
    public Animal exploreISARelationship() {
        // Create an Animal reference to a Mammal and return it.
        // Animal a = new Mammal(...)
        return null;
    }

    // Method 2: Explore HAS-A relationship
    public Animal exploreHASARelationship() {
        // Create an animal and give it a habitat of 'River' then return the animal
        // Animal HAS-A Habitat
        return null;
    }

    // Method 3: Test animal sounds
    public String testAnimalSounds() {
        // Create a bird and then return the sound it makes. Modify it until the test passes
        return null;
    }


    // Student Task: Create a Lion class
    public Mammal createLionClass() {
        // Task: Extend Mammal to create a Lion class.
        // Implement makeSound() to return "Lion roars!".
        // Test the Lion class by creating an object and returning it in this method.
        // Make it so that the Lion doesn't need to have the name and habitat specified we can just say new Lion()
        // Lion lion = new Lion();
        
        return lion;
    }
}
