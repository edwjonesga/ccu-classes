# Assignment: **Queryosity**

*SQL Week 5 – Applied Data and Statistical Analysis*

## How to Run the Assignment

You can set up the assignment database in two different ways:

### Option 1 – Run and Exit (Batch Mode)

This will run the file and return you to your normal terminal shell:

```bash
mysql -u root -p < queryosity.sql
```

### Option 2 – Run and Stay Inside MySQL (Interactive Mode)

This will run the file and keep you in the MySQL prompt so you can continue experimenting:

```bash
mysql -u root -p
```

Then inside MySQL, type:

```sql
SOURCE /path/to/queryosity.sql;
```

---

## Overview

Welcome to **Queryosity** — your chance to sharpen SQL skills by exploring data with curiosity! This assignment focuses only on **DML queries** (`SELECT`, filters, ordering, grouping, aggregates, and functions).

You’ll use the provided database (with **Customers** and **Products** tables) to practice the SQL you’ve learned and investigate a few extra commands on your own.

---

## Provided Data

The database contains two pre-built tables with sample data already loaded:

**Customers**

* CustomerID
* FirstName
* LastName
* City

**Products**

* ProductID
* ProductName
* Price
* Quantity

No need to create or insert data — just focus on writing queries.

---

## Tasks

### Part 1 – Basic SELECT

1. Retrieve all customer names and cities.
2. Retrieve all products with their prices and quantities.
3. Retrieve only the first names of customers who live in `New York`.
4. Retrieve products with a price greater than 400.

### Part 2 – Filtering & Ordering

5. Retrieve customers from New York, ordered by `LastName`.
6. Retrieve all products, ordered by price (highest first).
7. Retrieve customers from `Chicago` **or** `Houston`.
8. Retrieve customers with `CustomerID` greater than 10 **and** living in `Miami`.
9. Retrieve customers whose last name is **not** `Brown`.

### Part 3 – Aggregates & Grouping

10. Count how many customers live in each city.
11. Find the average product price.
12. Calculate the total revenue (`Price * Quantity`) for each product.
13. Show the city with the highest number of customers (hint: combine `GROUP BY` and `ORDER BY`).
14. Show the most expensive product.

### Part 4 – Aliases & Functions

15. Show all products with `Price * Quantity` labeled as `TotalValue`.
16. Use `ROUND()` to show product prices rounded to 1 decimal place.
17. Rename `FirstName` to `First` and `LastName` to `Last` in your query results.

### Part 5 – Research & Stretch Goals 🚀

These commands were not explicitly covered in the slides — use **research skills** to figure them out:
18. Use `DISTINCT` to list all the unique cities that customers live in.
19. Use a `LIKE` query to find customers whose first name starts with “A”.
20. Use `LIMIT` to return only the first 3 products.
21. Research how to use `CASE` in SQL and write a query that classifies products into price tiers (e.g., “Low”, “Medium”, “High”).

---

## Deliverables

Submit a single file named **`queryosity.sql`** that contains:

* One query per task, numbered in order.
* A short comment above each query describing what it does.
* Any stretch goal queries you attempt.

---

✨ *Be curious. Be Queryous. Explore the data with SQL.*

---
