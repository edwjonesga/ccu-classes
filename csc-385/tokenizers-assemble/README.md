## 🦸‍♂️ Tokenizers Assemble: The First Phase

*A Lexical Analysis Assignment*

### 🔍 Overview

Welcome to the **first heroic mission** in your compiler journey! In this assignment, you will build a team of Deterministic Finite Automata (DFAs)—each one responsible for recognizing a specific type of token. Working together under the direction of a central orchestrator, your tokenizers will scan an input stream character-by-character and classify each piece of the code as a meaningful symbol.

This is **Phase One** of compilation: **Lexical Analysis**. Your tokenizer team lays the groundwork for the parser, the semantic analyzer, and beyond.

---

### 🧠 Tokens to Recognize

Your tokenizer team must recognize the following symbols of power:

* **Keywords**: e.g., `if`, `print`
* **Identifiers**: e.g., `x`, `variableName`
* **Integer Literals**: e.g., `10`, `42`
* **Operators**:

  * Assignment: `=`
  * Comparison: `==`
* **Arithmetic**: e.g., `+`

---

### 🛠️ Instructions

1. **Implement Individual DFAs**
   Create a separate DFA for each token type. Each DFA should:

   * Accept input **one character at a time**
   * Track its internal state using a **transition table**
   * Know when it’s in an **accepting state**
   * Know when it has reached a **dead state**

2. **Build the Orchestrator**
   Create a driver that:

   * Accepts an input string (e.g., a tiny code snippet)
   * Feeds characters sequentially to each DFA
   * Detects and records which DFA matches each token
   * Returns a **list of tokens** as `(tokenType, matchedString)`

3. **Example Input**
   Your orchestrator should correctly tokenize this example:

   ```txt
   if x == 10
   print x
   x = x + 1
   ```

   Expected Output:

   ```
   Keyword: if
   Identifier: x
   Comparison: ==
   Number: 10
   Keyword: print
   Identifier: x
   Identifier: x
   Assignment: =
   Identifier: x
   Arithmetic: +
   Number: 1
   ```

---

### 🧪 Testing

Be sure to test:

* Each DFA independently using unit tests
* The full tokenizer pipeline using orchestrated tests
* Edge cases like:

  * `=` vs. `==`
  * Invalid tokens (e.g., `@`)
  * Mixed whitespace spacing

---

### 💡 Hint

> The **order** in which you run your DFAs may influence the result. Subtle bugs may emerge when one DFA claims a token that another was better suited for. You're building a team—**choose your lineup wisely.**

---

Let me know if you'd like the README in markdown format or with GitHub-flavored additions like badges, file structure, or TODOs!
