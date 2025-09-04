# Assignment Tasks
# CSC 242: Object-Oriented Programming - Midterm Exam

## Instructions

This midterm exam tests your understanding of object-oriented programming concepts, including classes, objects, interfaces, inheritance, and polymorphism.

**General Guidelines:**

1.  **Read Carefully:** Read each class and interface description thoroughly before starting to implement any code.
2.  **Implement All Required Functionality:** Ensure that all methods and attributes specified in the class descriptions are implemented.
3.  **Follow Best Practices:** Adhere to good coding practices, including meaningful variable names, proper indentation, and clear comments, encapsulation, polymorphism.
4.  **Testing:** While not explicitly required, you are strongly encouraged to test your code to ensure it functions as expected.
5.  **Focus on Core Concepts:** The primary focus of this exam is to demonstrate your understanding of object-oriented principles.
6.  **Implement Interfaces:** Implement the methods described in the interfaces.
7.  **Extend Classes:** Extend classes where appropriate.

## Classes and Interfaces

**1. `BankAccount` Class:** (10 points)

* Represents a bank account with an account number, account holder, and balance.
* Implement methods to:
    * Deposit money into the account.
    * Withdraw money from the account.
    * Retrieve the current balance.
* Ensure that withdrawals cannot exceed the available balance.

**2. `Book` Class:** (10 points)

* Represents a book with a title, author, ISBN, and availability status.
* Implement methods to:
    * Check out the book.
    * Return the book.
* Ensure that books cannot be checked out if they are already unavailable.

**3. `Library` Class:** (15 points)

* Manages a collection of `Book` objects.
* Implement methods to:
    * Check out a specific book.
    * Return a specific book.
    * List all available books in the library.

**4. `Product` Class:** (10 points)

* Represents a product with a name, price, and category.
* Implement a method to:
    * Retrieve the product's info i.e. name, price, and category.

**5. `Electronics` Class:** (20 points)

* Represents an electronic product.
* Add an attribute for warranty period.
* Extend the `Product` class.
* Override the method to retrieve product info, including the warranty period.

**6. `Clothing` Class:** (20 points)

* Represents a clothing product.
* Add an attribute for size.
* Extend the `Product` class.
* Override the method to retrieve product details, including the size.

**7. `PaymentProcessor` Interface:** (15 points)

* Define a method to:
    * Process a payment.

**8. `CreditCardPayment` Class:** (20 points)

* Implement the `PaymentProcessor` interface.
* Implement the method to process a payment, printing a message indicating that payment has been processed via credit card.

**9. `PayPalPayment` Class:** (20 points)

* Implement the `PaymentProcessor` interface.
* Implement the method to process a payment, printing a message indicating that payment has been processed via PayPal.

**10. `Shape` Interface:** (15 points)

* Define a method to:
    * Calculate the area of the shape.

**11. `Rectangle` Class:** (20 points)

* Represents a rectangle with length and width.
* Implement a constructor to set length and width.
* Ensure that a rectangle is a Shape.

**12. `Square` Class:** (20 points)

* Represents a square with a side length.
* Implement a constructor to set the side length.
* Be sure to make use of the available classes and functionality.
* Ensure that a Square is also a Shape.

**5 Additional points for clean tidy code**

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
docker build -t mid-term .
```

### Step 5: Once the image is built, run the container using:
#### Linux/Mac:
```sh
docker run -it --rm -v "$(pwd)":/workspace mid-term
```
#### Windows:
```sh
docker run -it --rm -v "%cd%":/workspace mid-term
```
### Step 6: Get most recent assignment code.
Once your workspace is running run the following command to get the most recent code from github.
Select your class then select the current assignment short name: mid-term
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

5. **refresh-assignment-files.sh:** This script downloads a fresh copy of the assignment files into your workspace to a directory named mid-term.
    ```sh
    refresh-assignment-files.sh
    ```
    You will need to copy the files you want to replace from the mid-term directory.


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

