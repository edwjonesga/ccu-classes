CREATE DATABASE IF NOT EXISTS exampledb; 
USE exampledb;
-- ========================================
-- Queryosity: SQL Week 5 Assignment Starter
-- ========================================
-- This file sets up the database schema and data.
-- It also includes commented tasks for you to complete.
-- Just write your SQL queries below each comment.

-- ----------------------------------------
-- DROP TABLES IF THEY EXIST (clean start)
-- ----------------------------------------
DROP TABLE IF EXISTS Customers;
DROP TABLE IF EXISTS Products;

-- ----------------------------------------
-- CREATE TABLES
-- ----------------------------------------
CREATE TABLE Customers (
  CustomerID INT PRIMARY KEY,
  FirstName VARCHAR(50),
  LastName VARCHAR(50),
  City VARCHAR(50)
);

CREATE TABLE Products (
  ProductID INT PRIMARY KEY,
  ProductName VARCHAR(50),
  Price DECIMAL(10,2),
  Quantity INT
);

-- ----------------------------------------
-- INSERT SAMPLE DATA
-- ----------------------------------------
INSERT INTO Customers (CustomerID, FirstName, LastName, City) VALUES
(1, 'Alice', 'Smith', 'Los Angeles'),
(2, 'Bob', 'Johnson', 'New York'),
(3, 'Carol', 'Williams', 'Chicago'),
(4, 'Dave', 'Brown', 'New York'),
(5, 'Eve', 'Davis', 'Houston'),
(6, 'Frank', 'Miller', 'Miami'),
(7, 'Grace', 'Wilson', 'Seattle'),
(8, 'Henry', 'Moore', 'Chicago'),
(9, 'Ivy', 'Taylor', 'Los Angeles'),
(10, 'Jack', 'Anderson', 'Houston'),
(11, 'Karen', 'Thomas', 'Denver'),
(12, 'Leo', 'Jackson', 'Phoenix'),
(13, 'Mia', 'White', 'New York'),
(14, 'Noah', 'Harris', 'Chicago'),
(15, 'Olivia', 'Martin', 'San Francisco'),
(16, 'Paul', 'Thompson', 'Boston'),
(17, 'Quinn', 'Garcia', 'Dallas'),
(18, 'Ruby', 'Martinez', 'Miami'),
(19, 'Sam', 'Robinson', 'Seattle'),
(20, 'Tina', 'Clark', 'Chicago');

INSERT INTO Products (ProductID, ProductName, Price, Quantity) VALUES
(1, 'Laptop', 800.45, 12),
(2, 'Smartphone', 600.78, 25),
(3, 'Tablet', 400.12, 15),
(4, 'Monitor', 300.99, 10),
(5, 'Headphones', 150.49, 30),
(6, 'Keyboard', 75.20, 40),
(7, 'Mouse', 45.99, 50),
(8, 'Printer', 220.35, 8),
(9, 'Webcam', 95.60, 22),
(10, 'External Hard Drive', 180.80, 18);

-- ========================================
-- ASSIGNMENT TASKS
-- Write your queries below each section
-- ========================================

-- Part 1 – Basic SELECT
-- 1. Retrieve all customer names and cities.


-- 2. Retrieve all products with their prices and quantities.


-- 3. Retrieve only the first names of customers who live in New York.


-- 4. Retrieve products with a price greater than 400.


-- Part 2 – Filtering & Ordering
-- 5. Retrieve customers from New York, ordered by LastName.


-- 6. Retrieve all products, ordered by price (highest first).


-- 7. Retrieve customers from Chicago OR Houston.


-- 8. Retrieve customers with CustomerID greater than 10 AND living in Miami.


-- 9. Retrieve customers whose last name is not Brown.


-- Part 3 – Aggregates & Grouping
-- 10. Count how many customers live in each city.


-- 11. Find the average product price.


-- 12. Calculate the total revenue (Price * Quantity) for each product.


-- 13. Show the city with the highest number of customers.


-- 14. Show the most expensive product.


-- Part 4 – Aliases & Functions
-- 15. Show all products with Price * Quantity labeled as TotalValue.


-- 16. Use ROUND() to show product prices rounded to 1 decimal place.


-- 17. Rename FirstName to First and LastName to Last in your query results.


-- Part 5 – Research & Stretch Goals 🚀
-- 18. Use DISTINCT to list all the unique cities that customers live in.


-- 19. Use LIKE to find customers whose first name starts with “A”.


-- 20. Use LIMIT to return only the first 3 products.


-- 21. Research how to use CASE in SQL and classify products into price tiers
--     (e.g., “Low”, “Medium”, “High”).


-- ========================================
-- END OF ASSIGNMENT
-- ========================================
