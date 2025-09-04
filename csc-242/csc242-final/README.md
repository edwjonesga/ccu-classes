# CSC 242 Final Exam – Part B

This is **Part B** of your final exam for CSC 242. It will test your ability to model and implement core object-oriented programming concepts in Java.

---

## 🧪 What You Need to Do

You are given 13 partially defined Java files. Each file represents a separate question focused on a concept from the course.

* Implement as many questions as you can within the time limit.
* Your total grade will be based on your **best answers summing to a maximum of 200 points**.
* You are encouraged to attempt more than 7 questions, but only the highest-scoring submissions will count.

---

## 🕒 Time Limit

**75 minutes**

* This is a **closed-book exam**.
* You **may reference your own past assignments**, but not online resources, textbooks, notes, or each other.

---

## 💾 Submission Instructions

Your code **must compile**.
If your submission does not compile, you may receive a **penalty of up to 50%** on each affected question.

Submit a single `Assignment.zip` file containing your completed `.java` files. 

---

## 📋 Question Descriptions

### Q1: Abstraction (25 points)

Create a `DeliveryService` class that **HAS-A** `Driver` and **IS-A** `BusinessEntity`. Use this to model both composition and abstraction.

---

### Q2: Classes and Objects (15 points)

Define a `Movie` class with private fields such as `title` and `releaseYear`. Provide a constructor and a method to print out the movie details.

---

### Q3: Method Overloading (15 points)

Implement a `Calculator` class with two `add()` methods:

* One that accepts two integers.
* One that accepts three integers.
  This demonstrates method overloading.

---

### Q4: Encapsulation (20 points)

Create a `CreditCard` class that includes fields named `cardNumber` and `balance`. These fields should be encapsulated. Provide getter and setter methods for both, and include basic validation logic in the setters.

---

### Q5: Inheritance (25 points)

Create a `Person` class and a `Teacher` class. The `Teacher` should inherit from `Person` and override a method such as `getRole()`.

---

### Q6: Polymorphism (25 points)

Create an abstract class `Shape` with a `draw()` method. Implement `Circle` and `Square` as subclasses. Use polymorphism to store multiple shapes in a list and call `draw()` on each.

---

### Q7: Abstract Classes (20 points)

Define an abstract class `Animal` with a method `makeSound()`. Implement a concrete subclass `Dog` that defines this method.

---

### Q8: Interface Design (20 points)

Define a `Clickable` interface with a method `click()`. Implement the interface in at least two different classes (`Button`, `Icon`) and define their versions of `click()`.

---

### Q9: Singleton Pattern (35 points)

Implement the Singleton pattern in a `Logger` class. Ensure only one instance of the `Logger` can be created and that it provides a `log(String message)` method.

---

### Q10: UML Modeling (20 points)

Create classes based on the model on the handout/projector:


---

### Q11: Immutability (25 points)

Create an immutable `Point` class. Once a point is constructed, its x and y coordinates should not be changeable. Provide a `moveTo(int dx, int dy)` method that returns a new `Point`.

---

### Q12: Generics (30 points)

Create a generic class `Box<T>` that can store any type. Use a field named `contents` to hold the value. Implement a method `getContents()` that returns this value.

---

### Q13: Reflection (40 points)

Write a method that takes an `Object` and a `String` (representing a method name). Use reflection to **invoke the method with that name** on the object, assuming it takes no parameters.

---

### Q14: Lambdas and Functional Interfaces (50 points)

1. Create a `FunctionalInterface` called `GpaFilter` with a method that takes a `Student` and returns a `boolean`.
2. Inside the `Student` class, define an instance of `GpaFilter` using a lambda expression that returns `true` if the student's GPA is greater than 2.7 and `false` otherwise.

   * *Hint*: You probably need a `double gpa` field in the `Student` class.

---

## ✅ Reminders

* Complete **as many questions as you can** within the time limit.
* Your top-scoring submissions (up to 200 points) will be counted.
* Code must **compile**, follow Java syntax, and represent the correct **relationships and behavior**.

Good luck — demonstrate what you’ve learned!


# ⚠️ Important Grading Rules ⚠️
1. Code that does not compile will recieve an automatic 50% penalty or more depending on if I want to go digging through your code to see why it isn't working. Happy to help during office hours tho :-)
2. Gratuitous modification of test code to make your code pass if it doesn't will also recieve a significant up to 50% penalty (at my discression). Please check with me before modifying tests.
3. With the exception of cases where I'm in a good mood :-) you can expect to receive a 0 for any assignment that is not turned in before the deadline if arrangements for a late submission are not made before hand.

## Downloading, Unzipping, and Running the Assignment
### Step 1: Download the assignment ZIP file from your course portal.
### Step 2: Unzip the file into a directory of your choice.
You can use the following command in the terminal to unzip the file:
```sh
unzip the-assignment.zip
```

### Step 3: Open a terminal (Command Prompt on Windows, Terminal on Mac/Linux) and navigate to the unzipped directory using the `cd` command.

### Step 4: Build the Docker image using the following command:
#### Windows only (Ensure Docker Desktop is running)
```sh
docker build -t csc242-final .
```

### Step 5: Once the image is built, run the container using:
#### Linux/Mac:
```sh
docker run -it --rm -v "$(pwd)":/workspace csc242-final
```
#### Windows:
```sh
docker run -it --rm -v "%cd%":/workspace csc242-final
```
### Step 6: Get most recent assignment code.
Once your workspace is running run the following command to get the most recent code from github.
Select your class then select the current assignment short name: csc242-final
```sh
refresh-assignment-files.sh
```

## Using the Installed Scripts
After running the Docker container, you will have access to three scripts that are included in the Docker image:

1. **compile.sh:** This script compiles all code including `Main.java` and `MainTest.java` files.
    ```sh
    compile.sh
    ```
    It will compile the source files and ensure that your code is ready for testing.

2. **run-tests.sh:** This script runs the JUnit tests in the `MainTest.java` file.
    ```sh
    run-tests.sh
    ```
    The results will be saved to a file named `test-results.txt`.

3. **prepare_to_submit.sh:** This script prepares your assignment for submission by running all tests and creating a ZIP file containing your work.
    ```sh
    prepare_to_submit.sh
    ```
    If all tests pass, it will create a file named `Assignment.zip` in the `/workspace` directory, ready for submission.

4. **update-docker.sh:** This script downloads a new Dockerfile to your workspace. This is sometimes necessary if updates are required.
    ```sh
    update-docker.sh
    ```
    You will need to exit, rebuild, and restart your Docker container after running this command.

5. **refresh-assignment-files.sh:** This script downloads a fresh copy of the assignment files into your workspace to a directory named csc242-final.
    ```sh
    refresh-assignment-files.sh
    ```
    You will need to copy the files you want to replace from the csc242-final directory.


# Getting Started with Docker for Your Assignment
This assignment will guide you through creating a Docker-based environment. Follow the instructions below to set up Docker on your system and complete the tasks.

## Setting Up Docker
### Windows
1. Download Docker Desktop from [Docker’s official website](https://www.docker.com/products/docker-desktop/).
2. Run the installer and follow the prompts.
3. After installation, launch Docker Desktop and ensure it is running.

### Mac
1. Open Terminal.
2. Install Homebrew if it is not already installed by running the following command:
    ```sh
    /bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
    ```
3. Run the following command to install Docker using Homebrew:
    ```sh
    brew install --cask docker
    ```
4. Start Docker from the command line:
    ```sh
    open /Applications/Docker.app
    ```
5. Verify Docker installation by running:
    ```sh
    docker --version
    ```

### Linux
1. Open a terminal.
2. Run the following commands:
    ```sh
    sudo apt-get update
    sudo apt-get install docker.io
    ```
3. Verify Docker installation with:
    ```sh
    docker --version
    ```

