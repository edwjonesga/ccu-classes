# MySQL Database and Key DBMS Concepts
This assignment will guide you through performing basic operations in a MySQL database using SQL commands. We will cover viewing the catalog, creating tables, inserting, updating, and deleting data.

## Step 1: Setting Up MySQL
We will first set up MySQL in your environment and connect to our database.

## Step 2: Creating Tables
### Resources for Creating Other Tables


*   Schema Reference [here](https://docs.google.com/presentation/d/16FmWgXHp-Jj_JarRk-vCsmiYtQmNY6IUj2DpXf0N8dg/edit#slide=id.SLIDES_API963317716_5)
*   SQL Function Reference [here](https://docs.google.com/presentation/d/1sWq-pRfXJTcGcoQEKq-O8iOvpT5irTI9Xm12Qf8kQ84/edit#slide=id.g30088ebeae4_0_0)
*   SQL Advanced Function Reference [here](https://docs.google.com/presentation/d/1sWq-pRfXJTcGcoQEKq-O8iOvpT5irTI9Xm12Qf8kQ84/edit#slide=id.g2f9bcf455a1_0_0)
* Check previous Create code for how to do foreign keys


### Assignment Tasks

1.  **Intersection**: Write a query using `INTERSECT` to find any customers who also appear in a separate, manually created list of potential VIP customers.
2.  **Union**: Write two queries, one using `UNION` and one using `UNION ALL`, to combine a list of all customer first names with a list of all employee first names.
3.  **Nested Select Statements**: Write a query with at least two levels of nesting to find all customers who have a 'Premium' subscription and also have a Visa card on file. Do not use the example query from the instructions.
4.  **Adding Indexes**: Write the SQL statements to create the following types of indexes:
    *   A **unique index** on the `email` column of the `customer` table.
    *   A **non-unique index** on the `city` column of the `customer` table.
    *   A **composite index** on the `FirstName` and `LastName` columns of the `customer` table.

## Conclusion
In this assignment, we covered the following:
- Viewing the database catalog
- Determining the schema of a table
- Creating tables and inserting data
- Updating and deleting data

These operations demonstrate basic DBMS concepts and SQL commands.