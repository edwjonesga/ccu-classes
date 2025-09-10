---
# Assignment 3: **Lex the Halls** 🎄

### A Token of Our Appreciation for Language Structure

## Preamble

In this assignment, we’re taking a significant step up from the DFAs and regular expressions you’ve been working with so far. It’s time to give our language some real expressive power.

You’ll be building a **JavaCC-based tokenizer (lexer)** for a miniature programming language. Think of this as preparing the ingredients for a full compiler — your lexer will recognize identifiers, numbers, strings, operators, keywords, comments, and more. But don’t worry — we’re still in **Phase 1**, which means **no syntax checking or parsing logic yet**. We’re just slicing the input into tokens and returning them in order.

By the end of this assignment, you’ll have a lexer that recognizes a much richer language and skips over whitespace and comments, just like the pros.

---

## What You’ll Be Implementing

Using **JavaCC**, you will define a `.jj` grammar file that can tokenize code snippets written in a simplified C-like language.

Your lexer must recognize the following:

### ✅ Keywords
- `if`, `else`, `while`, `for`, `int`, `print`

### ✅ Identifiers
- A sequence of letters (a–z, A–Z) and digits (0–9), starting with a letter

### ✅ Literals
- **Integer literals** (e.g., `42`, `0`, `9999`)
- **String literals** using double quotes (e.g., `"hello"`, `"abc123"`)

### ✅ Operators
- Arithmetic: `+`, `-`, `*`, `/`
- Assignment and equality: `=`, `==`
- Comparison: `<`, `<=`, `>`, `>=`
- Grouping: `(`, `)`, `{`, `}`, `[`, `]`
- Separators: `,`, `;`

### ✅ Comments
- **Single-line:** `// this is a comment`
- **Multi-line:** `/* this is a \n multi-line comment */`

These should be **skipped**, i.e., not included in the token list.

---

## Example of Valid Code

```java
int x = 10;
if (x > 5) {
    print("x is greater than 5");
} else {
    print("x is 5 or less");
}

/* A comment */
for (int i = 0; i <= 5; i = i + 1) {
    print(i);
}
````

Expected tokens:

```
[int, x, =, 10, ;, if, (, x, >, 5, ), {, print, (, "x is greater than 5", ), ;, }, else, {, print, (, "x is 5 or less", ), ;, }, for, (, int, i, =, 0, ;, i, <=, 5, ;, i, =, i, +, 1, ), {, print, (, i, ), ;, }]
```

---

## Example of **Invalid Input**

```java
int x = 42;
x = x + 1;
@notAllowedToken
```

This code contains an **invalid token**: `@notAllowedToken`, which is not a recognized symbol. Your lexer should throw a `ParseException` when it encounters an unrecognized token like this.

---

## Provided Starter Files

* `grammar.jj` — a minimal JavaCC grammar file
* `MainTest.java` — a JUnit test that verifies your tokens are being returned in the correct order and that invalid input triggers errors

---

## How to Run

### Step 1: Generate Java source from grammar

```bash
javacc grammar.jj
```

This will produce several `.java` files including `MyParser.java`.

### Step 2: Compile generated Java files

```bash
compile.sh
```

### Step 3: Run your parser (optional)

```bash
java MyParser
```

This will start parsing from standard input.

---

## Expectations

* Your lexer should **return a `List<String>`** of tokens in the order they appear.
* **Whitespace and comments must be skipped**.
* If any invalid token is encountered (e.g., `@`, `#`, or an unterminated string), your program should throw a `ParseException`.
* Your `Start()` method can be used to test the full file and return the list of tokens.

---

## 💡 Pro Tips

* Start by getting simple expressions working (e.g., `x = 5 + 1;`)
* Then add in keywords, comments, and strings.
* Make sure your test suite passes!
* Think modularly — organize your `TOKEN` declarations in categories.

---

## Deliverables

* Your completed `grammar.jj` file
* Any supporting Java files you created
* A passing `MainTest.java` (included, but you can add tests!)

---

## 🎯 Stretch Goal

Once you’ve completed this and passed all the tests, try extending the language to support:

* Boolean literals: `true`, `false`
* Logical operators: `&&`, `||`, `!`
* Character literals: `'a'`

But **only if you finish the required part first.**

---

## 🎄 Why “Lex the Halls”?

Because it’s festive, it’s punny, and after all — you're decking the code with token rules. Fa-la-la-la-la, la-la-la-lex.

Happy Lexing!

