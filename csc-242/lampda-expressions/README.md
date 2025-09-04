# Assignment Tasks
# 🏠 Lampda Expressions

## ⚠️ Special Notes on Testing & Docker

This assignment involves Java Swing GUI code, which **cannot easily run inside the Docker container** used in previous assignments. There are no automated tests provided because **testing GUI code is hard** and often requires human interaction.

### 🧪 How to Test Your Code

1. Open a **new terminal window** in the same location as your assignment.
2. Use `./compile.sh` to verify your code compiles **inside the Docker container**.
3. To run the GUI and test functionality, use:
   ```sh
   java Main
   ```

Make sure any GUI windows open and behave as expected when toggling switches or turning the light off.

---

## 🌟 Overview

You're tasked with creating a visually responsive smart light controller called `AuroraSmartLight`. It should manage a single smart light and allow interaction through **multiple switch panels**. The system should also display a glowing light bulb whenever the light is turned on. This project combines **functional interfaces**, **constructor references**, **anonymous classes**, and **event-driven programming** using Java Swing.

---

## 🎯 Objectives

By completing this assignment, you will:

- Practice building custom controller-like wrappers in Java.
- Use constructor references (`ClassName::new`) to trigger event-based object creation.
- Apply anonymous classes for event listening.
- Gain experience with GUI components and event-driven UI.

---

## 🧩 What You Must Implement

### 1. `AuroraSmartLight.java`

- Wrap a regular `SmartLight` instance.
- Maintain a **list of ********`SmartSwitchFrame`******** instances**.
- Allow adding **any number of switches** through a public method.
- Whenever a switch is toggled **on**, a new `LightBulbFrame` should be created using a **constructor method reference**:\
  `LightBulbFrame::new`
- Every switch should be updated to reflect the current state of the light
- Think carefully about the role of this class. Include reflection in your comments:
  - Is it a controller?
  - Is it a decorator on a powerable interface?
  - Should it implement `SmartDevice`?

### 2. `SmartSwitchFrame.java`

- A `JFrame` UI component that allows toggling a `SmartLight`.
- Include a `JToggleButton`.
- Add a **lambda expression** to handle user interaction with the button:\
  `toggleButton.addActionListener(...);`
- Register a **method reference** listener to respond to `HomeEvent` and update the switch visually.

### 3. `LightBulbFrame.java`

- An **undecorated**, centered `JFrame` that simulates a light bulb using a white panel.
- Takes a `HomeEvent` in the constructor and extracts the device from it.
- Use an **anonymous class** as a `SmartHomeObserver` to listen to the device.
- When the light turns off, the frame should **dispose itself**.

### 4. `Main.java`

- Your entry point.
- Instantiate an `AuroraSmartLight`.
- Add at least **two** `SmartSwitchFrame` instances to it.
- Demonstrate the light responding to switch toggles and opening multiple bulb frames when turned on.

---

## 🔍 Tips and Hints

- Constructor method references allow you to treat `LightBulbFrame::new` as a `Function<HomeEvent, SmartHomeObserver>`.
- Use `SwingUtilities.invokeLater(...)` for all GUI setup to ensure it runs on the Event Dispatch Thread.
- Test with multiple toggles and observe how your system reacts.
- Use `setLocationRelativeTo(null)` to center `JFrames`.

---

## ✅ Submission Checklist

Please note that the Docker container is used only for **compilation**. Run your GUI code **outside of Docker** using the steps listed above under "Special Notes on Testing & Docker."

Make sure your project includes:

-

---

I'm expecting to see a GUI when I run your code. Also expecting at least one person to go Ham on this. Happy coding! 💡



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
docker build -t lampda-expressions .
```

### Step 5: Once the image is built, run the container using:
#### Linux/Mac:
```sh
docker run -it --rm -v "$(pwd)":/workspace lampda-expressions
```
#### Windows:
```sh
docker run -it --rm -v "%cd%":/workspace lampda-expressions
```
### Step 6: Get most recent assignment code.
Once your workspace is running run the following command to get the most recent code from github.
Select your class then select the current assignment short name: lampda-expressions
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

5. **refresh-assignment-files.sh:** This script downloads a fresh copy of the assignment files into your workspace to a directory named lampda-expressions.
    ```sh
    refresh-assignment-files.sh
    ```
    You will need to copy the files you want to replace from the lampda-expressions directory.


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

