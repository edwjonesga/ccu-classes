# **Compiler Final Project Rubric**

## **Summary of Point Allocation**

| **Category**                                          | **Points** |
| ----------------------------------------------------- | ---------- |
| **Compiler Phases (Total)**                           | **70**     |
| - Lexer                                               | 15         |
| - Parser                                              | 20         |
| - Semantic Analysis (includes scope checking)         | 20         |
| - IR Generation                                       | 10         |
| - Bytecode Generation                                 | 10         |
| **Arithmetic Expressions**                            | **30**     |
| **Assignment Statements**                             | **40**     |
| **Control Flow**                                      | **50**     |
| **Function Calls**                                    | **40**     |
| **Object-Oriented Features**                          | **50**     |
| **Error Handling (Total)**                            | **55**     |
| - Meaningful Error Messages (Lexer, Parser, Semantic) | 30         |
| - Error Recovery (global)                             | 20         |
| - Scope Error Reporting                               | 5          |
| **Total**                                             | **340**    |

---

## **Extra Credit Opportunities**

* **Advanced Object-Oriented Features:** Inheritance, interface implementation, abstract classes. *(Recommended: +5 per feature)*
* **Advanced Error Recovery:** Beyond the basic requirements. *(Instructor‑defined bonus)*
* **Optimizations:** Each meaningful optimization implemented earns **+5 points**.

---

# **DETAILED RUBRIC**

# **1. Compiler Phases (70 Points)**

To earn full credit for each compiler phase, the compiler **must successfully process the full reference test program** (defined below). Successful processing means: lexing, parsing, semantic checking, IR generation, and bytecode generation that runs.

### **Lexer (15 pts)**

To earn full points, the lexer must:

* Correctly tokenize *all* elements of the reference test program.
* Handle identifiers, literals, operators, punctuation, keywords.
* Properly identify illegal tokens and produce a meaningful error message (error handling scored elsewhere).

### **Parser (20 pts)**

To earn full points, the parser must:

* Successfully parse the reference program into a valid AST.
* Correctly handle nested expressions, chained statements, and OO constructs.
* Produce clear error messages when syntax errors occur.

### **Semantic Analysis (20 pts)**

To earn full points, the semantic analyzer must:

* Perform type checking.
* Validate function signatures.
* Validate method invocation correctness.
* **Correctly enforce and track scope.** *(5 points specifically for scope checking.)*
* Detect undefined variables, type mismatches, incorrect return usage.
* Report errors with accurate messages and source locations.

### **IR Generation (10 pts)**

To earn full points, IR generation must:

* Produce correct TAC/IR for all constructs in the reference test program.
* Correctly represent control flow, branching, loops, expressions, and method calls.

### **Bytecode Generation (10 pts)**

To earn full points, the compiler must:

* Convert IR into valid JVM bytecode.
* The bytecode must successfully run and produce correct results.

---

# **2. Arithmetic Expressions (30 Points)**

To earn the full 30 points, the compiler must support:

### **Basic Arithmetic (10 pts)**

* +, -, *, /
* Integer and possibly boolean coercions

### **Operator Precedence & Grouping (10 pts)**

* Correct handling of parentheses
* Correct evaluation order

### **Complex Expressions (10 pts)**

* Multiple operations combined
* Expressions embedded in assignments and function calls

---

# **3. Assignment Statements (40 Points)**

Assignments include all forms of right-hand-side expressions.

### **Assignments to Literals & Variables (10 pts)**

* `int x = 5;`
* `y = x;`

### **Object Assignments (10 pts)**

* `Point p = new Point();`

### **Assignments involving Function Calls (10 pts)**

* `int z = compute(x);`

### **Assignments to Expressions (10 pts)**

* `int w = (a + b) * c - d;`

---

# **4. Control Flow (50 Points)**

Compiler must support all major control flow constructs.

### **If / If-Else / Else-If Chains (20 pts)**

* Correct AST structure
* Correct branching semantics

### **Loops (20 pts)**

* `while` loops
* `for` loops
* Nested loops

### **Nested Control Flow (10 pts)**

* Nested ifs inside loops
* Loops inside ifs

---

# **5. Function Calls (40 Points)**

### **Function Definitions (10 pts)**

* Correct parameter types
* Correct return type enforcement
* Semantic validation

### **Calling Functions With/Without Parameters (15 pts)**

* Arity validation
* Type correctness of arguments

### **Handling Return Values (15 pts)**

* Ensuring functions return the correct type
* Using returns correctly in assignments or expressions

---

# **6. Object-Oriented Features (50 Points)**

### **Class Definitions (20 pts)**

* Correct fields
* Correct constructors
* Method declarations

### **Object Instantiation (10 pts)**

* `new` operator support
* Correct constructor invocation

### **Method Invocation on Objects (20 pts)**

* Instance method calls
* Correct handling of `this`
* Resolving object types

---

# **7. Error Handling (55 Points)**

Error handling applies across the compiler.

### **Meaningful Error Messages (30 pts)**

* Lexer (10 pts): Illegal tokens, unterminated strings
* Parser (10 pts): Unexpected tokens, malformed structures
* Semantic (10 pts): Type errors, undefined variables

### **Error Recovery (20 pts)**

* Ability to continue parsing after errors
* Reporting multiple errors in a single compile

### **Scope Error Reporting (5 pts)**

* Undefined variable
* Redeclaration errors
* Using variables outside their declared scope

---

# **REFERENCE TEST PROGRAM (ALL PHASES MUST SUPPORT THIS)**

```java
class SampleClass {
    int value;

    SampleClass(int v) {
        this.value = v;
    }

    int add(int x) {
        return this.value + x;
    }
}

class Main {
    public static int addNumbers(int x, int y) {
        return x + y;
    }

    public static int computeFinal(int a, int b) {
        return a * 2 + b / 3;
    }

    public static void main() {
        int a = 5;
        int b = 10;
        int c = a + b * 2;

        if (c > 20) {
            c = c - 1;
        } else if (c == 20) {
            c = c + 2;
        } else {
            c = c + 3;
        }

        for (int i = 0; i < 5; i++) {
            c = c + i;
        }

        while (c < 50) {
            c = c + 1;
        }

        int result = addNumbers(a, b);
        int finalResult = computeFinal(result, c);

        SampleClass obj = new SampleClass(10);
        int objVal = obj.add(finalResult);
    }
}
```

---

Let me know if you want formatting refinements, color coding, or a printable PDF version!
