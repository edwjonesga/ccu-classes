-- List all tables in the database
-- Create a database named 'subscription_service' if it doesn't exist
CREATE DATABASE IF NOT EXISTS subscription_service;
-- Use the 'subscription_service' database
USE subscription_service;

SHOW TABLES;

-- Whack Tables
drop table customer;
drop table payment_method;
drop table subscription;

-- Create Tables
CREATE TABLE IF NOT EXISTS customer (
    customer_id INT PRIMARY KEY AUTO_INCREMENT,
    FirstName VARCHAR(255) NOT NULL,
    LastName VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    street VARCHAR(255) NOT NULL,
    city VARCHAR(255) NOT NULL,
    state VARCHAR(255) NOT NULL,
    zip_code VARCHAR(255) NOT NULL
);

-- Create the payment_method table
CREATE TABLE IF NOT EXISTS payment_method (
    payment_method_id INT PRIMARY KEY AUTO_INCREMENT,
    customer_id INT,
    payment_type VARCHAR(255) NOT NULL,
    card_number VARCHAR(255) UNIQUE,
    expiration_date VARCHAR(255),
    FOREIGN KEY (customer_id) REFERENCES customer(customer_id)
);

CREATE TABLE IF NOT EXISTS subscription (
    subscription_id INT PRIMARY KEY AUTO_INCREMENT,
    customer_id INT NOT NULL,
    subscription_type VARCHAR(255) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES customer (customer_id)
);

-- Insert Data
INSERT INTO customer (FirstName, LastName, email, street, city, state, zip_code)
VALUES ('John', 'Doe', 'john.doe@example.com', '123 Main St', 'Springfield', 'IL', '62701');

-- Scratch Area
