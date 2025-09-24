
# Parsing Up the Right Tree 🌳

In last week’s assignment (*The Great Parsnership*), you built a working parser that could consume tokens and verify syntactic correctness. This week, you’ll take the next step: **building an Abstract Syntax Tree (AST)**.

The AST is the “right tree” for our compiler — a compact, meaningful representation of the program structure that eliminates grammar clutter and prepares us for semantic analysis.

---

## 🎯 Objectives

- Extend your parser to build an **AST** for your language.
- Demonstrate that **every parse produces an AST test tree** (our standard format for grading and validation).
- Explore both approaches:
  - Building ASTs by hand (custom node classes).
  - Using **JJTree** with your JavaCC grammar.
- Integrate `toASTTestTree()` so we can validate AST correctness regardless of your implementation choice.

---

## 🛠️ Requirements

1. **Start with last week’s grammar.**  
   You will extend your `.jj` file from *The Great Parsnership*.

2. **Add AST support.**  
   - Hand-rolled: Create Java node classes (`BinaryOpNode`, `IfNode`, etc.) and build them inside parser methods.  
   - JJTree: Annotate your grammar and let JJTree auto-generate AST nodes.

3. **ASTTestTree output.**  
   - Every AST node must implement a `toASTTestTree()` method.  
   - This converts your internal AST into an **`ASTTestTree`** (provided in starter code).  
   - Example output for `x + y * z`:
     ```
     (+ x (* y z))
     ```
   - Both **compact string form** (`(+ x (* y z))`) and **pretty-printed form** are supported.

4. **Update build environment (if needed).**  
   If you are using JJTree, you may need to:
   - Modify your `Dockerfile` to include the `jjtree` tool.  
   - Update `compile.sh` and other scripts to call `jjtree` before `javacc`.  
   - Reference the JJTree docs: [JJTree Manual](https://javacc.github.io/javacc/#jjtree).

5. **Testing.**  
   - Provide sample programs and their expected AST outputs.  
   - Use `prettyPrint()` or `toString()` from `ASTTestTree` to demonstrate correctness.  
   - Tests should fail if the tree shape is incorrect (wrong operator precedence, wrong nesting, etc.).

---

## 📦 Deliverables

- Your updated **grammar file** (`.jj`) and supporting AST classes.
- Your **ASTTestTree.java** class (provided, but you may extend).
- Implementation of `toASTTestTree()` for every AST node type.
- A `README-output.md` (or similar) showing:
  - Example source input.  
  - The resulting AST test tree (compact + pretty-print).  
- Updated **Dockerfile** and **scripts** (if needed) so the project compiles and runs in the standard environment.

---

## ✅ Grading

- **Parser correctness** (30%) — Your parser must still successfully parse valid input programs.  
- **AST construction** (40%) — ASTs must reflect correct structure (operator precedence, nesting, etc.).  
- **ASTTestTree output** (20%) — Must match expected structure in compact form.  
- **Build & Docker integration** (10%) — Your project must compile and run in the standard environment.  

*Bonus points (up to +5%):* If you add a visual AST printer (ASCII tree, Graphviz export, etc.).

---

## 🔍 Example Walkthrough

**Input:**
```c
if (x > 0) y = y * 2;
````

**Expected ASTTestTree (compact):**

```
(if (> x 0) (= y (* y 2)))
```

**Pretty-printed form:**

```
if
  >
    x
    0
  =
    y
    *
      y
      2
```

---

## 📌 Notes

* Either approach is acceptable (**hand-rolled** or **JJTree**).
* All implementations **must** produce an `ASTTestTree`.
* Your code should be **well-structured** and **readable** — AST node classes should be small, focused, and self-contained.
* If using JJTree, remember that your **build scripts** must run JJTree first, then JavaCC, then `javac`.

---

🌲 Have fun “Parsing Up the Right Tree”! This assignment marks the point where your compiler finally goes beyond raw syntax and begins to *understand* structure.

