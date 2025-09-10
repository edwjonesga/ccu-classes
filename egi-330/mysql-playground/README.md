
# 📘 MySQL Playground Activities

Welcome! This guide walks you through basic SQL operations for exploring and manipulating a simple database inside your Docker container.

Once you're inside the MySQL client, follow these steps:

---

## 🏗️ 1. Create a Database

```sql
CREATE DATABASE exampledb;
USE exampledb;
````

---

## 🧱 2. Create a Table

```sql
CREATE TABLE IF NOT EXISTS employees (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    position VARCHAR(100),
    salary DECIMAL(10, 2)
);
```

---

## 📂 3. View Tables and Schema

```sql
-- List all tables
SHOW TABLES;

-- View table structure
DESCRIBE employees;
```

---

## ➕ 4. Insert Sample Data

```sql
INSERT INTO employees (name, position, salary) VALUES
('Alice Smith', 'Software Engineer', 90000.00),
('Bob Johnson', 'Data Analyst', 75000.00),
('Carol White', 'Designer', 68000.00);
```

---

## 📄 5. View Data

```sql
SELECT * FROM employees;
```

---

## ✏️ 6. Update Records

```sql
-- Give Alice a raise
UPDATE employees
SET salary = 95000.00
WHERE name = 'Alice Smith';

-- Verify
SELECT * FROM employees;
```

---

## ❌ 7. Delete Records

```sql
-- Remove all Designers
DELETE FROM employees
WHERE position = 'Designer';

-- Verify
SELECT * FROM employees;
```

---

## ✅ What You Practiced

* Creating databases and tables
* Viewing catalog and schema
* Inserting data
* Querying rows
* Updating rows
* Deleting rows

---

🌀 To start fresh at any time, just drop and recreate the database:

```sql
DROP DATABASE exampledb;
CREATE DATABASE exampledb;
USE exampledb;
```

Enjoy exploring SQL!

```

---

Let me know if you want this saved into an actual `.md` file or extended with bonus exercises (like sorting, filtering, joins, etc).
```
