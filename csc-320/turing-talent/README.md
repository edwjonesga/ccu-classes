# Assignment Tasks
# **Turing's Got Talent: A Turing Machine Programming Assignment**

## **Objective**
In this assignment, you will implement a **Turing Machine** to perform basic computational operations. This will help reinforce concepts related to **computability theory, state transitions, and automata**.

---

## **Tasks**
You will implement **five Turing Machine programs**, each designed to perform a simple operation:

1. **Unary Adder**: Adds two numbers represented in unary notation.
2. **Binary Incrementer**: Increments a binary number by one.
3. **Binary Decrementer**: Decrements a binary number by one.
4. **Palindrome Checker**: Determines if a given binary string is a palindrome.
5. **Binary Adder**: Adds two binary numbers together by repeatedly incrementing.

Each task will involve defining **states, transition rules, and execution logic** using the Turing Machine class.

---

## **Instructions**

### **1. Implement the Unary Adder**
- Input format: Two unary numbers separated by `+`. Example: `111+11` (which represents `3+2`).
- Transition rules should **merge** the two numbers and produce a single unary number.
- Expected output: `11111_`.

### **2. Implement the Binary Incrementer**
- Input format: A binary number, e.g., `1011` (which is `11` in decimal).
- Implement rules to **add 1** to the number.
- Expected output: `1100_`.

### **3. Implement the Binary Decrementer**
- Input format: A binary number.
- Implement rules to **subtract 1** from the number.
- Expected output example: `1011 → 1010_`.

### **4. Implement the Palindrome Checker**
- Input format: A binary string.
- Implement rules to check if the string is a **palindrome**.
- Expected output: The machine should **accept** if it is a palindrome, otherwise **reject**.
- Example:
  - `11011_` → **Accepted**
  - `11010_` → **Rejected**

### **5. Implement the Binary Adder**
- Input format: Two binary numbers separated by `+`. Example: `1010+101` (10+5).
- The adder should **increment the first number** by the second number times.
- Expected output: `1111_` (which is `15` in binary).

---

## **Code Structure**
Each operation should be implemented as a **separate Java class** that:
- Contains a **TuringMachine instance**.
- Defines **transition rules** for solving the problem.
- Implements a `compute()` or `check()` method that returns the final **tape output**.

Use the `TuringMachine` class for your implementations.

---

## **Submission Requirements**
- **Java code** implementing all five operations.
- A **JUnit test suite** verifying correct functionality.
- Zip everything up and submit it in the usual ways

---

Happy coding! 🧠💻



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
docker build -t turing-talent .
```

### Step 5: Once the image is built, run the container using:
#### Linux/Mac:
```sh
docker run -it --rm -v "$(pwd)":/workspace turing-talent
```
#### Windows:
```sh
docker run -it --rm -v "%cd%":/workspace turing-talent
```
### Step 6: Get most recent assignment code.
Once your workspace is running run the following command to get the most recent code from github.
Select your class then select the current assignment short name: turing-talent
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

5. **refresh-assignment-files.sh:** This script downloads a fresh copy of the assignment files into your workspace to a directory named turing-talent.
    ```sh
    refresh-assignment-files.sh
    ```
    You will need to copy the files you want to replace from the turing-talent directory.


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

