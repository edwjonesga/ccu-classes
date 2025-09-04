# Assignment Tasks
# **Assignment: "Design Patterns - The Smart Way Home"**

## **Overview**
In this assignment, you will enhance a **Smart Home Automation System** by implementing **key software design patterns**. Building on the existing system, you will refactor and extend functionality using:
- **Singleton**
- **Observer**
- **Factory**
- **Builder**
- **Decorator**

Your goal is to **improve scalability, maintainability, and modularity** while maintaining the **existing SOLID principles** you have already implemented.

---

## **Objectives**
- Convert `HomeController` into a **Singleton** to ensure only one instance exists.
- Implement an **Observer Pattern** so devices can respond to **home events** dynamically.
- Refactor `SmartDeviceFactory` to use the **Factory Pattern** for flexible device creation.
- Introduce a **Builder Pattern** for `SmartHomeRepository` to simplify configuration.
- Create a **Decorator Pattern** that tracks how long a `SmartLight` has been turned on.

---

## **Tasks**
### **1️⃣ Singleton Pattern: HomeController**
- Convert `HomeController` into a **Singleton**.
- Ensure it only has **one instance** controlling the smart home.
- Note: It is slightly controversial, but **OK**, to pass parameters into `getInstance(...)`.

### **2️⃣ Observer Pattern: SmartHomeEventManager**
- Create a `SmartHomeEventManager` to manage event subscriptions.
- Implement an interface `SmartHomeObserver` that devices can implement.
- Devices should **respond to relevant home events** (e.g., a motion sensor triggering lights).
- **Extra Credit**: Create a base class that devices can extend **instead of implementing the interface directly**.

### **3️⃣ Factory Pattern: SmartDeviceFactory**
- Implement `SmartDeviceFactory` to **encapsulate device creation logic**.
- Ensure new devices can be **created dynamically based on type**.
- Modify `HomeController` so it **retrieves devices from the factory instead of directly instantiating them**.

### **4️⃣ Builder Pattern: SmartHomeRepositoryBuilder**
- Implement a **Builder Pattern** for `SmartHomeRepository`.
- The builder should allow adding **multiple device types** before calling `.build()`.
- This removes the need for manually configuring devices one by one.

### **5️⃣ Decorator Pattern: SmartLight Usage Tracker**
- Implement a **Decorator Pattern** for tracking how long a `SmartLight` has been turned on.
- The decorator should **wrap an existing `SmartLight`** and store **total active time**.
- Ensure that the tracking starts when `turnOn()` is called and stops when `turnOff()` is called.

## Extra Credit
1. You are only expected to implement 4 of these if you do 5 you will get 5 extra points
2. Notice how the observer pattern just implements a helper class and infrastructure. 5 extra points if you figure out how to use it in one of your smart devices.
---

## **Submission Instructions**
1. **Modify and submit the following files:**
   - `HomeController.java`
   - `SmartHomeEventManager.java`
   - `SmartHomeObserver.java`
   - `SmartDeviceFactory.java`
   - `SmartHomeRepositoryBuilder.java`
   - `SmartLightUsageTracker.java`
   - Any **other relevant files** for the implementation.
2. Ensure that **your code compiles and passes all unit tests**.
3. Submit your project in a **zip file** or via your **Git repository link**.

---

## **💡 Pro Tip**
_Think of design patterns as "blueprints" for solving common software design problems!_ 🏡✨

### **Good Luck! 🚀**

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
docker build -t design-smart-home .
```

### Step 5: Once the image is built, run the container using:
#### Linux/Mac:
```sh
docker run -it --rm -v "$(pwd)":/workspace design-smart-home
```
#### Windows:
```sh
docker run -it --rm -v "%cd%":/workspace design-smart-home
```
### Step 6: Get most recent assignment code.
Once your workspace is running run the following command to get the most recent code from github.
Select your class then select the current assignment short name: design-smart-home
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

5. **refresh-assignment-files.sh:** This script downloads a fresh copy of the assignment files into your workspace to a directory named design-smart-home.
    ```sh
    refresh-assignment-files.sh
    ```
    You will need to copy the files you want to replace from the design-smart-home directory.


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

