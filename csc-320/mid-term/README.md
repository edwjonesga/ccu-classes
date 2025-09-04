# Assignment Tasks
---

# **CSC 320 Midterm Exam - Coding Section**

## **Instructions**
- Implement all required methods while following the given method signatures.
- Ensure proper **object-oriented design** and use **accessor methods** where applicable.
- Submit your solution as a **`.zip` file** containing all Java files.
- The total points for this section: **200 points**.

Before starting please get the most recent code from the repository by running `refresh-assignment-files.sh` and chosing to overwrite existing files. **Be sure to select CSC-320->mid-term**

---

## **1. Hiking Packing (50 points)**
- Create a `Backpack` class with a **capacity** and a list of **packed items**.
- Create an `Item` inner class with **weight** and **value**.
- Implement `packForHiking(Backpack backpack, List<Item> items)`, which returns a **Backpack** with the best selection of items.

---

## **2. Degrees of Separation (40 points)**
- Implement a `DegreesOfSeparation` class.
- Store and manage connections between users.
- Implement `addConnection(int userA, int userB)`.
- Implement `findDegreesOfSeparation(int startUser, int targetUser)`, returning the shortest path length or `-1` if no connection exists.

---

## **3. Smart Bookshelf (35 points)**
- Implement a `SmartBookshelf` class.
- Implement `findBook(int[] bookIDs, int targetID)`, which returns the **index** or `-1` if not found.

---

## **4. Playlist Organizer (45 points)**
- Implement a `PlaylistOrganizer` class.
- Create an `Song` inner class with **name, artist, and ranking**.
- Implement `sortPlaylist(List<Song> songs)`, sorting songs in ascending order.

---

## **5. GCD Calculator (30 points)**
- Implement a `GCDCalculator` class.
- Implement `gcd(int a, int b)`.
- Implement `findGCD(int[] numbers)`, computing the GCD for a list of numbers.

---

## **Submission Instructions**
- Submit all Java files in a **`.zip` file**.
- Ensure your code **compiles** and **follows OOP principles**.
- Include **comments where necessary**.



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

