# Assignment Tasks
# Smart Home Automation - SOLID Refactoring

## Overview
In this assignment, you will take the existing **Smart Home Automation System** and refactor it to follow the **SOLID principles** of software design. The goal is to improve maintainability, scalability, and modularity while preserving the core functionality of the system.

## Objectives
- Apply **Single Responsibility Principle (SRP)** by refactoring `HomeController` to delegate storage responsibilities.
- Implement the **Open/Closed Principle (OCP)** so new device types can be added without modifying existing classes.
- Ensure **Liskov Substitution Principle (LSP)** by correctly designing the class hierarchy.
- Follow the **Interface Segregation Principle (ISP)** by breaking `SmartDevice` into smaller, focused interfaces.
- Use **Dependency Inversion Principle (DIP)** by injecting dependencies into `HomeController`.

---

## **Assignment Tasks**
### **1. Apply the Single Responsibility Principle (SRP)**
- Modify `HomeController` so that it no longer manages device storage.
- Create a new class **`SmartHomeRepository`** to handle **device storage and retrieval**.
- `HomeController` should only manage interactions between devices.

### **2. Apply the Open/Closed Principle (OCP)**
- Ensure that **new devices can be added without modifying `HomeController`**.
- Replace **specific lists (`List<SmartLight>`, `List<SmartLock>`)** with a **generic list (`List<SmartDevice>`)**.
- Modify methods so that they **work dynamically with any new device type**.

### **3. Apply the Liskov Substitution Principle (LSP)**
- Ensure that **substituting subclasses does not break the system**.
- Remove security-related methods (`operate()`) from `SmartDevice`.
- Introduce a new **`SecureDevice`** interface for security-related functionality.

### **4. Apply the Interface Segregation Principle (ISP)**
- Break `SmartDevice` into **smaller, focused interfaces**:
  - `Powerable` - For devices that can be turned on/off.
  - `Dimmable` - For devices with adjustable brightness.
  - `TemperatureControllable` - For thermostats.
  - `MotionSensing` - For motion detection devices.
  - `CameraEnabled` - For security cameras.
- Modify existing devices to **only implement the interfaces they need**.

### **5. Apply the Dependency Inversion Principle (DIP)**
- Modify `HomeController` to **accept `SmartHomeRepository` as a constructor parameter**.
- Ensure `HomeController` **does not instantiate `SmartHomeRepository` directly**.
- Devices should be passed dynamically via **constructor injection**.

---

## **Evaluation Criteria**
| **Criteria** | **Weight (%)** |
|-------------|--------------|
| **SRP Compliance (Separation of Responsibilities)** | **20%** |
| **Open/Closed Principle (Adding New Devices Without Modification)** | **20%** |
| **Liskov Substitution Principle (Proper Inheritance & Substitution)** | **15%** |
| **Interface Segregation (Focused Interfaces)** | **15%** |
| **Dependency Inversion (Decoupling via Injection)** | **15%** |
| **Code Readability & Documentation** | **15%** |

---

## **Submission Instructions**
1. **Modify and submit the following files:**
   - `HomeController.java`
   - `SmartHomeRepository.java`
   - `SmartDevice.java`, `Powerable.java`, `SecureDevice.java`, `Dimmable.java`, `TemperatureControllable.java`, etc.
   - **All relevant device classes** (`SmartLight`, `SmartLock`, `SecurityCamera`, etc.)
   - `Main.java` (entry point for testing functionality)
   - `MainTest.java` (JUnit tests for verification)
2. Ensure that **your code compiles and passes all unit tests**.
3. Submit your project in a **zip file** .

---

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
docker build -t solid-state-home .
```

### Step 5: Once the image is built, run the container using:
#### Linux/Mac:
```sh
docker run -it --rm -v "$(pwd)":/workspace solid-state-home
```
#### Windows:
```sh
docker run -it --rm -v "%cd%":/workspace solid-state-home
```
### Step 6: Get most recent assignment code.
Once your workspace is running run the following command to get the most recent code from github.
Select your class then select the current assignment short name: solid-state-home
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

5. **refresh-assignment-files.sh:** This script downloads a fresh copy of the assignment files into your workspace to a directory named solid-state-home.
    ```sh
    refresh-assignment-files.sh
    ```
    You will need to copy the files you want to replace from the solid-state-home directory.


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

