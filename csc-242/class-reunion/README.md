# Assignment Tasks

# Class Reunion - Bringing it All Together

## Overview
This assignment will test your understanding of Object-Oriented Programming by having you design and implement multiple classes that interact through inheritance, interfaces, and composition. You'll apply key OOP principles to create a fully functioning system with multiple related components.

## Steps to Complete

### 1. Implement a Timer Class
- Create a `Timer` class that tracks elapsed time in seconds.
- Implement methods to:
  - Start the timer
  - Stop the timer
  - Reset the timer
  - Retrieve the elapsed time

### 2. Create a Song and Playlist System
- Implement a `Song` class with attributes for title, artist, and duration.
- Implement a `Playlist` class that:
  - Stores multiple `Song` objects.
  - Allows adding and removing songs.
  - Checks if a song exists in the playlist.

### 3. Establish a Document Hierarchy
- Create a `Document` base class.
- Extend `Document` to create `Report` and `Invoice` subclasses.

### 4. Model a Student-Course Enrollment System
- Create a `Student` class with attributes like name and enrolled courses.
- Create a `Course` class with attributes like course title and a list of enrolled students.
- Create an `Enrollment` class to manage relationships between students and courses.

### 5. Implement Payment Processing with Interfaces
- Define a `PaymentMethod` interface with a `processPayment(double amount)` method.
- Implement `CreditCard` and `PayPal` classes that adhere to `PaymentMethod`.
- Ensure that both classes can process payments and track the last transaction amount.

### 6. Design a Beautiful Inheritance Relationship
- Create an `Employee` class with attributes for name and salary.
- Implement a `Manager` class that is a specialized version of `Employee`.
- A `Manager` should receive an automatic 10% salary bump over the specified salary.

## Guidelines
- Follow proper encapsulation and access control.
- Ensure proper use of inheritance, interfaces, and composition.
- Avoid redundant code by leveraging OOP principles.
- Write clean, readable, and well-documented code.
- Your implementations should pass all provided test cases in `MainTest.java`.

Good luck, and have fun bringing it all together!



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
docker build -t class-reunion .
```

### Step 5: Once the image is built, run the container using:
#### Linux/Mac:
```sh
docker run -it --rm -v "$(pwd)":/workspace class-reunion
```
#### Windows:
```sh
docker run -it --rm -v "%cd%":/workspace class-reunion
```
### Step 6: Get most recent assignment code.
Once your workspace is running run the following command to get the most recent code from github.
Select your class then select the current assignment short name: class-reunion
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

5. **refresh-assignment-files.sh:** This script downloads a fresh copy of the assignment files into your workspace to a directory named class-reunion.
    ```sh
    refresh-assignment-files.sh
    ```
    You will need to copy the files you want to replace from the class-reunion directory.


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

