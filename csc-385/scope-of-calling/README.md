
# Assignment: The Scope of Our Calling ✝️🔍

This week, we build on your parser/AST work by implementing **symbol tables** and **scope tracking**.  
Your mission: ensure that when variables, functions, and parameters are declared, they can be properly tracked, looked up, and resolved across nested scopes.

---

## 🎯 Objectives

- Implement a `SymbolTable` interface that supports:
  - Declaring symbols
  - Looking up symbols locally and across enclosing scopes
  - Entering and exiting scopes
  - Returning a structured snapshot of current scopes for testing

- Integrate symbols with your existing **AST nodes** (e.g., `AssignmentNode`, `IfNode`, `FunctionDeclNode`).

- Explore the **Visitor pattern** to walk your AST cleanly, performing symbol table actions (declare/lookup) as you traverse.

---

## 🛠 Provided Interfaces

We’ve given you the following skeletons:

### `SymbolTable.java`
```java
public interface SymbolTable {
    boolean declare(Symbol symbol);
    Optional<Symbol> lookupLocal(String name);
    Optional<Symbol> lookup(String name);
    void enterScope();
    void exitScope();
    List<ScopeInfo> getScopeInfo();
}
````

### `Symbol.java`

```java
public record Symbol(String name, Kind kind, ASTNodeBase declaration) {}
```

### `Kind.java`

```java
public enum Kind {
    VARIABLE, FUNCTION, PARAMETER, CONSTANT
}
```

### `ScopeInfo.java`

```java
public record ScopeInfo(int level, List<Symbol> symbols) {}
```

---

## 📖 The Visitor Pattern

The **Visitor pattern** is a common way to separate algorithms from the objects they operate on.
Instead of writing ad-hoc recursive methods to traverse your AST, you define a `Visitor` interface with methods for each node type, and let each AST node "accept" the visitor.

This keeps your traversal logic modular and reusable. For example, one visitor can build symbol tables, another can type-check, and another can generate code — all without changing your AST node classes.

### Example

```java
// Visitor interface
public interface NodeVisitor {
    void visit(AssignmentNode node);
    void visit(FunctionNode node);
    // add other node types here
}

// AST node with accept method
public class AssignmentNode extends ASTNodeBase {
    private final ASTNodeBase var;
    private final ASTNodeBase value;

    public AssignmentNode(ASTNodeBase var, ASTNodeBase value) {
        this.var = var;
        this.value = value;
    }

    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visit(this);
    }
}

// Semantic analyzer visitor that uses the SymbolTable
public class SymbolTableBuilder implements NodeVisitor {
    private final SymbolTable table = new MySymbolTableImpl();

    @Override
    public void visit(AssignmentNode node) {
        String varName = node.getVarName(); // assume accessor
        if (table.lookup(varName).isEmpty()) {
            System.err.println("Error: variable '" + varName + "' not declared.");
        }
        // continue visiting child nodes
    }

    @Override
    public void visit(FunctionNode node) {
        table.enterScope();
        // declare params, visit body
        table.exitScope();
    }
}
```

---

## ✅ Deliverables

* Your `SymbolTable` implementation.
* Unit tests that demonstrate:

  * Declaring and looking up symbols
  * Shadowing in nested scopes
  * Duplicate declaration detection
  * Scope removal after exit
* A simple **Visitor-based semantic pass** that walks the AST and interacts with your symbol table.

---

