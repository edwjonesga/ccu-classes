# ✨ The Great Parse-nership

In this assignment, you and your parser are leveling up your relationship. It's time to move beyond simple tokenization and begin shaping the **syntax** of your language. You'll expand your tokenizer and start defining grammar rules to support basic language constructs. Think of it as the beginning of a beautiful parse-nership.

---

## 📜 Assignment Overview

Your goals for this week:

1. **Extend your scanner** to recognize a richer set of tokens (see below).
2. **Write grammar rules** for the foundational syntax structures (listed below).
3. **Validate your parser** against a sample input program.
4. You may use **AI tools for boilerplate**, but you must be able to explain all code and grammar you submit.

---

## 🔢 Required Tokens

### ✅ Keywords

```
if, else, while, for, int,
class, public, private, protected,
static, void, return, new, this,
null, true, false, break, continue
```

### ✅ Primitive Types

```
int, boolean, char, float, double,
long, short, byte, string
```

### ✅ Operators

```
+  -  *  /            (arithmetic)
=  ==  !=             (assignment, equality)
<  <=  >  >=          (comparison)
&&  ||  !             (logical)
++  --                (increment/decrement)
+=  -=  *=  /=        (compound assignment)
.                    (member access only)
```

### ✅ Literals

* Integer literals: `42`, `0`, `9999`
* Floating-point: `3.14`, `2.0e-5`
* Char literals: `'a'`, `'Z'`, `'\n'`
* String literals: `"hello"`, `"abc123"`
* Boolean: `true`, `false`
* Null: `null`

### ✅ Grouping Symbols

```
( )  { }  [ ]
```

### ✅ Separators

```
,  ;  :
```

### ✅ Comments

```java
// Single-line comment
/* Multi-line
   comment */
```

---

## 🌍 Grammar Goals

Your grammar should now handle the following structures:

1. **Variable Declarations**
   `int x;` or `Dog d;`

2. **Variable Assignments**
   `x = 5;` or `d = new Dog();`

3. **Function Invocation**
   `print("Hello");`, `d.speak();`

4. **Function Declaration**
   `void reset() { ... }`

5. **Expressions**
   Arithmetic and logical expressions with grouping: `(a + b) * c`

6. **If Statements**
   `if (...) { ... } else { ... }`

7. **For Loops**
   `for (int i = 0; i < 10; i++) { ... }`

8. **While Loops**
   `while (x < 10) { ... }`

> 📅 You don't need to check for types or scoping yet. Just parse the structure.

---

## 🔍 Example Program

Here is a sample program that your parser should accept:

```java
int count = 0;
boolean ready = false;
String name = "Fido";

Dog d;
Cat c;

void speak() {
    print(d.name);
    print("Meow: " + c.volume);
    d.bark();
}

void reset() {
    count = 0;
    d = new Dog();
    c = new Cat();
}

boolean isZero() {
    return count == 0;
}

void main() {
    speak();

    if (isZero()) {
        print("Still zero!");
    } else {
        print("Count is now " + count);
    }

    for (int i = 0; i < 10; i++) {
        count = count + 1;
    }

    while (count < 20) {
        count++;
    }

    reset();
}
```

---

## 🚀 Submission Checklist

* [ ] Tokenizer updated to include all required tokens
* [ ] Grammar rules defined for all listed constructs
* [ ] Parser can accept the example program (or equivalent)
* [ ] Clearly comment any AI-generated code and explain its function

---

Happy parsing! And remember: your parser is only as great as your parse-nership with it. ✨
