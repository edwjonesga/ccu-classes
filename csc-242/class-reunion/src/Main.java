// Problem 1: A Simple Class

// Problem 2: Two Interacting Classes


// Problem 3: A Class Hierarchy



// Problem 4: Three Classes Working Together



// Problem 5: Interface and Class Hierarchy



// Problem 6: A Beautiful Inheritance Relationship


// Main.java to enforce the existence of required classes and methods.
public class Main {
    public static void main(String[] args) {
        Timer timer = new Timer();
        Song song = new Song();
        Playlist playlist = new Playlist();
        Document doc = new Report();
        Document invoice = new Invoice();
        Student student = new Student();
        Course course = new Course();
        Enrollment enrollment = new Enrollment();
        PaymentMethod cc = new CreditCard();
        PaymentMethod paypal = new PayPal();
        Employee employee = new Employee("Alice", 50000);
        Manager manager = new Manager("Bob", 50000);
    }
}
