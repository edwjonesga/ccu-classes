# 🛡️ Regex Rangers: Pattern Matching Protocol

Welcome, Ranger.

Your mission this week is to tokenize a stream of code using the power of **regular expressions**. You won't be building DFAs by hand like last time. Instead, you'll write **one class per token type**, each using a regular expression internally to match that kind of token.

Each of your tokenizers will be coordinated by an **orchestrator** that scans the input from left to right, always choosing the **longest matching token**, and breaking ties based on the **order in which tokenizers were registered**.

---

## 🎯 Objectives

- Use Java's `Pattern` and `Matcher` APIs for token recognition.
- Apply greedy matching and token prioritization.
- Build a modular, extensible tokenizer system using regex.
- Design clean object-oriented code with extensibility in mind.

---

## 🧱 Components You'll Implement

| Component                        | Description                                                                 |
|----------------------------------|-----------------------------------------------------------------------------|
| `RegexTokenizer` (interface)     | Defines how individual tokenizers match tokens using regex.                |
| `RegexOrchestrator` (interface)  | Manages tokenizers and performs the overall tokenization process.          |
| `TokenizerOrchestratorImplementation` | Your orchestrator implementation.                                    |
| `Token`                          | A simple class to hold the type and lexeme of a token.                     |
| Tokenizer classes                | One class per token type (see below).                                      |

---

## 🔨 Tokenizers You Must Create

You must implement the following tokenizer classes. Each should implement the `RegexTokenizer` interface.

| Token Type   | Class to Implement       | Description                     |
|--------------|--------------------------|---------------------------------|
| Keyword      | `IfTokenizer`            | Matches the keyword `if`       |
| Keyword      | `PrintTokenizer`         | Matches the keyword `print`    |
| Identifier   | `IdentifierTokenizer`    | Variable/function names        |
| Comparison   | `EqualEqualTokenizer`    | Matches `==`                   |
| Assignment   | `EqualTokenizer`         | Matches `=`                    |
| Arithmetic   | `PlusTokenizer`          | Matches `+`                    |
| Number       | `NumberTokenizer`        | Matches integer numbers        |

> ⚠️ Do **not** create one generic class for all of these.  
> ✅ Do use **inheritance** and shared logic where it makes sense (see below).

---

## ♻️ OOP Guidelines

You're encouraged to apply good object-oriented design:

- ✅ Use an abstract base class (e.g., `AbstractRegexTokenizer`) to share common logic.
- ✅ Group similar tokenizers (like keywords) under a shared parent class.
- ❌ Don't just make one `RegexTokenizer("if", "Keyword")` and call it done.
- ✅ Each class should be **distinct**, **named**, and **registered** individually.

**Example (allowed):**

```java
public class IfTokenizer extends AbstractRegexTokenizer {
    public IfTokenizer() {
        super("regex", "Keyword");
    }
}


# ⚠️ Important Grading Rules ⚠️
1. Code that does not compile will recieve an automatic 50% penalty or more depending on if I want to go digging through your code to see why it isn't working. Happy to help during office hours tho :-)
2. Gratuitous modification of test code to make your code pass if it doesn't will also recieve a significant up to 50% penalty (at my discression). Please check with me before modifying tests.
3. With the exception of cases where I'm in a good mood :-) you can expect to receive a 0 for any assignment that is not turned in before the deadline if arrangements for a late submission are not made before hand.

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
docker build -t regex-rangers .
```

### Step 5: Once the image is built, run the container using:
#### Linux/Mac:
```sh
docker run -it --rm -v "$(pwd)":/workspace regex-rangers
```
#### Windows:
```sh
docker run -it --rm -v "%cd%":/workspace regex-rangers
```
### Step 6: Get most recent assignment code.
Once your workspace is running run the following command to get the most recent code from github.
Select your class then select the current assignment short name: regex-rangers
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

5. **refresh-assignment-files.sh:** This script downloads a fresh copy of the assignment files into your workspace to a directory named regex-rangers.
    ```sh
    refresh-assignment-files.sh
    ```
    You will need to copy the files you want to replace from the regex-rangers directory.


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

