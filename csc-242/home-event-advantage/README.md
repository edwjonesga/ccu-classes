# Assignment Tasks
#**Home Event Advantage 🏡⚖️**

---

### 🎓 Objective
Revamp your smart home system to support a fully immutable, event-driven architecture using modern Java design practices.

---

### 📆 What You Need To Do

**⚠️ Start by copying over your existing smart home system code from your previous assignments.**
You will be extending and modifying that code to support a new event-driven infrastructure.

#### 1. **Implement a `HomeEvent` Record**
- Replace the old `HomeEvent` enum.
- Must include:
  - `HomeEventType type` (from the existing enum)
  - `SmartDevice sourceDevice`
  - `LocalDateTime timestamp`
  - *(Optional)* additional metadata
- This record must be fully **immutable** and use a **builder** for construction if necessary.

---

#### 2. **Update `SmartHomeObserver` Interface**
- Modify it to accept `HomeEvent` instead of an enum:
  ```java
  void onSmartHomeEvent(HomeEvent event);
  ```

---

#### 3. **Modify All Smart Devices**
- Implement:
  ```java
  void addSmartHomeEventListener(SmartHomeObserver observer);
  ```
- Devices must fire `HomeEvent`s during meaningful actions (e.g., `turnOn()`, `operate()`).

---

#### 4. **Modify `SmartHomeEventManager`**
- Add support for `addObserver(...)` and `fireEvent(...)`.
- Dispatch `HomeEvent` to all registered `SmartHomeObserver`s.

---

#### 5. **Update `HomeController`**
- Must implement `SmartHomeObserver`
- Must support:
  ```java
  void addDevice(SmartDevice device);
  List<HomeEvent> getTelemetry();
  ```
- When a device is added, the controller should listen to it automatically.

---

#### 6. **Modify `Main.java`**
Stub out the following methods for use in testing:
```java
public class Main {
  public static SmartLight getNewSmartLight(String name) { return null; }
  public static SmartLock getNewSmartLock(String name) { return null; }
  public static HomeController getHomeController() { return null; }
}
```

---

### 🚀 Requirements
- All classes must reside in the appropriate packages:
  - `edu.ccu.students.<your_username>.smartHome.core`
  - `edu.ccu.students.<your_username>.smartHome.devices`
  - `edu.ccu.students.<your_username>.smartHome.observer`
  - `edu.ccu.students.<your_username>.smartHome.controller`
- You may copy and modify any relevant code from previous assignments.
- Use `record`, `enum`, and Java best practices around encapsulation and immutability.

---

### ✅ Deliverables
- All source code files
- A working `MainTest.java` passing the provided test suite
- Adherence to Java package structure and object-oriented principles

Good luck, and may your events always be fired immutably! 🚀



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
docker build -t home-event-advantage .
```

### Step 5: Once the image is built, run the container using:
#### Linux/Mac:
```sh
docker run -it --rm -v "$(pwd)":/workspace home-event-advantage
```
#### Windows:
```sh
docker run -it --rm -v "%cd%":/workspace home-event-advantage
```
### Step 6: Get most recent assignment code.
Once your workspace is running run the following command to get the most recent code from github.
Select your class then select the current assignment short name: home-event-advantage
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

5. **refresh-assignment-files.sh:** This script downloads a fresh copy of the assignment files into your workspace to a directory named home-event-advantage.
    ```sh
    refresh-assignment-files.sh
    ```
    You will need to copy the files you want to replace from the home-event-advantage directory.


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

