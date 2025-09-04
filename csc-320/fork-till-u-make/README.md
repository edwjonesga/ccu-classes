# Assignment Tasks

# 🧵 Fork It Till You Make It: A Fork-Join Assignment

This multi-part assignment introduces you to the **Fork-Join parallelism model** using Java. You'll explore recursive task decomposition, build a parallel merge sort, and apply parallelism to matrix multiplication.

---

## 📚 Learning Objectives

By the end of this assignment, you will be able to:

- Understand how `RecursiveTask` and `RecursiveAction` work in Java’s `ForkJoinPool`.
- Apply the fork-join model to recursive divide-and-conquer algorithms.
- Compare the performance and structure of parallel vs. sequential algorithms.
- Implement real-world data processing using multithreaded parallelism.

---

## ✅ Part 1: Fork-Join Warm-Up (Simple Sum)

**Goal:** Get comfortable with creating and running fork-join tasks.

### 🧩 Task
- Create a class `SimpleForkJoinTask` that extends `RecursiveTask<Integer>`.
- Given an integer array and a range `[start, end)`, return the sum of all elements in that range.
- Use a threshold (e.g. 10 elements) to determine when to stop dividing and do the computation directly.
- Use `fork()` and `join()` to divide the task into subtasks.

### 🧪 Example

```java
int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
SimpleForkJoinTask task = new SimpleForkJoinTask(arr, 0, arr.length);
int result = ForkJoinPool.commonPool().invoke(task);
System.out.println(result); // Should print 36
```

---

## ✅ Part 2: Parallel Merge Sort

**Goal:** Implement merge sort using fork-join parallelism.

### 🧩 Task
- Create a class `ParallelMergeSort` that extends `RecursiveTask<int[]>`.
- Recursively sort left and right halves of the array using `fork()` and `join()`.
- Merge the results and return the sorted array.
- Use a sequential fallback for small subarrays (e.g. size ≤ 1000).

### 🧪 Example

```java
int[] unsorted = {4, 2, 9, 1, 7};
int[] sorted = ForkJoinPool.commonPool().invoke(new ParallelMergeSort(unsorted));
System.out.println(Arrays.toString(sorted)); // [1, 2, 4, 7, 9]
```

---

## ✅ Part 3: Parallel Matrix Multiplication

**Goal:** Use fork-join to perform matrix multiplication in parallel.

### 🧩 Task
- Implement `ParallelMatrixMultiplyTask` as a `RecursiveAction`.
- Given matrices `A (m×n)` and `B (n×p)`, compute `C (m×p)` using the naive triple-loop method.
- Divide the work by **row blocks**: each task handles a subset of output rows.
- Use a threshold (e.g. 64 rows) to determine when to compute sequentially.

### 🧪 Example

```java
double[][] A = ...; // m x n
double[][] B = ...; // n x p
double[][] C = new double[m][p];

ForkJoinPool.commonPool().invoke(new ParallelMatrixMultiplyTask(A, B, C, 0, m));
```

---

## 📤 What to Submit

- `SimpleForkJoinTask.java`
- `ParallelMergeSort.java`
- `ParallelMatrixMultiplyTask.java`
- `Main.java` (with test drivers for all 3)


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
docker build -t fork-till-u-make .
```

### Step 5: Once the image is built, run the container using:
#### Linux/Mac:
```sh
docker run -it --rm -v "$(pwd)":/workspace fork-till-u-make
```
#### Windows:
```sh
docker run -it --rm -v "%cd%":/workspace fork-till-u-make
```
### Step 6: Get most recent assignment code.
Once your workspace is running run the following command to get the most recent code from github.
Select your class then select the current assignment short name: fork-till-u-make
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

5. **refresh-assignment-files.sh:** This script downloads a fresh copy of the assignment files into your workspace to a directory named fork-till-u-make.
    ```sh
    refresh-assignment-files.sh
    ```
    You will need to copy the files you want to replace from the fork-till-u-make directory.


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

