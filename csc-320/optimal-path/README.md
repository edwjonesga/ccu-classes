# Assignment Tasks
# **Dynamic Programming Optimization Exercise**

## **Overview**
This exercise will test your ability to apply **dynamic programming (DP) to optimization problems**, where the goal is to either **maximize** or **minimize** a result. You will implement the following problems using **bottom-up DP**, **memoization**, and **solution reconstruction** where applicable. **Note you must use bottom-up for at least 1 of these problems**

## **Learning Objectives**
By completing this exercise, you will:
- Learn how to **formulate an optimization problem** using DP.
- Apply the **five-step DP framework**:
  1. **Define the objective function**  
  2. **Identify base cases**  
  3. **Find the recurrence relation**  
  4. **Determine the order of computation**  
  5. **Identify where the final answer is stored**  
- Implement **solution reconstruction** to track optimal decisions.

---

## **Problem 1: Coin Change (Minimization)**
### **Problem Statement**
You are given an array of coin denominations `[c1, c2, ..., ck]` and a target amount `N`. Your goal is to find the **minimum number of coins** needed to make `N`. If it is not possible, return `-1`.

### **Example**
#### **Input:**
```plaintext
Coins: [1, 5, 10]
Target: 14
```
#### **Output:**
```plaintext
Minimum Coins: 4
```

---

## **Problem 2: Rod Cutting (Maximization)**
### **Problem Statement**
You are given a rod of length `N` and a table of **prices** for rods of different lengths. Determine the **maximum value obtainable** by **cutting the rod into pieces**.

### **Example**
#### **Input:**
```plaintext
Rod Length: 5
Prices: [2, 5, 7, 8, 10]  (Prices for lengths 1, 2, 3, 4, 5)
```
#### **Output:**
```plaintext
Maximum Value: 12
```

---

## **Problem 3: Chess Endgame - Knight’s Shortest Path (Minimization)**
### **Problem Statement**
Given an `N × N` chessboard, find the **minimum number of moves** required for a **knight** to move from `(0,0)` to `(X,Y)`.

### **Example**
#### **Input:**
```plaintext
Board Size: 8×8
Start: (0,0)
Target: (7,7)
```
#### **Output:**
```plaintext
Minimum Moves: 6
```

---

## **Problem 4: Coin Change with Solution Reconstruction (Minimization)**
### **Problem Statement**
In addition to finding the minimum number of coins to make `N`, reconstruct the exact **coins used** to form the solution.

### **Example**
#### **Input:**
```plaintext
Coins: [1, 5, 10]
Target: 14
```
#### **Output:**
```plaintext
Minimum Coins: 4
Used Coins: [10, 1, 1, 1]
```

---

## **Problem 5: Knapsack with Solution Reconstruction (Maximization)**
### **Problem Statement**
Given a set of items, each with a **weight** and **value**, and a **knapsack with a weight limit**, determine the **maximum value** that can be obtained by selecting items **without exceeding the weight limit**. Additionally, **reconstruct** the set of items that make up this optimal value.

### **Example**
#### **Input:**
```plaintext
Items: [("A", weight: 3, value: 60), ("B", weight: 2, value: 100), ("C", weight: 4, value: 120)]
Knapsack Weight: 7
```
#### **Output:**
```plaintext
Maximum Value: 220
Selected Items: [B, C]
```

---

## **Implementation Guidelines**
- Implement **all five** of the above problems in **Java**.
- Write functions following the **five-step DP framework**.
- Use a **bottom-up DP table**.
- Store **backtracking information** to reconstruct solutions where required.


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
docker build -t optimal-path .
```

### Step 5: Once the image is built, run the container using:
#### Linux/Mac:
```sh
docker run -it --rm -v "$(pwd)":/workspace optimal-path
```
#### Windows:
```sh
docker run -it --rm -v "%cd%":/workspace optimal-path
```
### Step 6: Get most recent assignment code.
Once your workspace is running run the following command to get the most recent code from github.
Select your class then select the current assignment short name: optimal-path
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

5. **refresh-assignment-files.sh:** This script downloads a fresh copy of the assignment files into your workspace to a directory named optimal-path.
    ```sh
    refresh-assignment-files.sh
    ```
    You will need to copy the files you want to replace from the optimal-path directory.


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

