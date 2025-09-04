# Assignment Tasks
# **Approximately Good**

Welcome to your journey through approximation algorithms! In this assignment, you will explore two fundamental NP-hard problems—**Vertex Cover** and **Partition**—and implement algorithms that demonstrate the power and limits of approximation.

## **Overview**

This assignment has two parts:

1. **Vertex Cover (Greedy and 2-Approximation)**
2. **Partition Problem (Brute Force, Greedy, and PTAS)**

You will implement and compare approximation strategies, investigate pathological examples, and deepen your understanding of how clever algorithms can deliver near-optimal solutions efficiently.

---

## **Part 1: The Vertex Cover Conspiracy**

### **Objective**
Implement two approximation algorithms for the **Vertex Cover** problem and demonstrate how they behave on regular and specially constructed graphs.

### **What You'll Do**
- Implement `approxVertexCover()` using the classic 2-approximation algorithm.
- Implement `greedyByDegreeCover()` which picks the vertex with the highest degree at each step.
- Implement `getPathologicalGraph()` that returns a graph showing the greedy approach can perform worse than the 2-approximation.
- All of this should be implemented in the `VertexCoverAssignment.java` class.

### **Requirements**
- Do **not** modify `MainTest.java`. All logic should be inside `VertexCoverAssignment.java`.
- You will be tested on correctness and your ability to generate a valid **pathological case** where greedy fails.

---

## **Part 2: A Part-Time Partition-er**

### **Objective**
Work with the **Partition Problem**, designing algorithms that trade accuracy for speed.

### **What You'll Do**
- Implement `bruteForcePartition()` to exhaustively search all subsets.
- Implement `greedyPartition()` that adds the next largest number to the smaller pile.
- Implement `ptasPartition(double epsilon)` which scales values and uses dynamic programming to approximate the best partition.

All of this should be implemented in `Partition.java`.

### **Requirements**
- Your brute-force algorithm should always return the optimal solution for small arrays.
- Your greedy algorithm must be efficient and valid but is not expected to be optimal.
- Your PTAS method should accept an epsilon and improve accuracy as epsilon decreases.
- Tests are included in `MainTest.java` to verify functionality and improvements.

---

## **Submission Checklist**
- [ ] `VertexCoverAssignment.java` with:
  - `approxVertexCover()`
  - `greedyByDegreeCover()`
  - `getPathologicalGraph()`
- [ ] `Partition.java` with:
  - `bruteForcePartition(int[] A)`
  - `greedyPartition(int[] A)`
  - `ptasPartition(int[] A, double epsilon)`
- [ ] All tests in `MainTest.java` must pass.
- [ ] Comment your code and explain your logic where appropriate.

---

## **Bonus Challenge**
Include a method in `Partition.java` that visualizes the partitions using ASCII art. Make it fun!

---

### **Deadline:** Check your LMS for the due date  
### **Have questions?** Come to office hours.

> Good luck, and remember: if you can’t solve it exactly, cover it up or divide it cleverly!


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
docker build -t aprox-good .
```

### Step 5: Once the image is built, run the container using:
#### Linux/Mac:
```sh
docker run -it --rm -v "$(pwd)":/workspace aprox-good
```
#### Windows:
```sh
docker run -it --rm -v "%cd%":/workspace aprox-good
```
### Step 6: Get most recent assignment code.
Once your workspace is running run the following command to get the most recent code from github.
Select your class then select the current assignment short name: aprox-good
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

5. **refresh-assignment-files.sh:** This script downloads a fresh copy of the assignment files into your workspace to a directory named aprox-good.
    ```sh
    refresh-assignment-files.sh
    ```
    You will need to copy the files you want to replace from the aprox-good directory.


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

