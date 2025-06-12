# Overview
The Fourth Normal Form PostgreSQL database with simple Java user interface.

The server, username & password should be changed as needed in the getConnection() method.
The database was originally hosted on the university server, and every user had their own schema (same as their username).
So, schema should also be adjusted as necessary.

Not all functionality is implemented over JDBC (Java Database Connectivity), the `.sql` files itself can be found in the “database” directory.

# Tests
Tests in the “test” subfolder can be executed one by one, or by calling the `all.sql`
The function of each one:
1. Shows that there are no objects in the database (tables, indexes, virtual tables, triggers).
2. Creates the objects.
3. Shows that they have appeared (essentially the same process).
4. Shows where the virtual table query was saved.
5. Inserts data.
6. Shows that the data has appeared.
7. Demonstrates that a trigger is working (at least one).
8. Deletes the data.
9. Shows that the data has disappeared.
10. Deletes the objects.
11. Shows that the objects have disappeared.

> [!TIP]
> The files can be passed to `psql` like so: `psql -h host -U user -d database -f file`.

# Program
> [!TIP]
> Java program can be compiled as ussual: `javac Program.java`.
> 
> And run like so: `java -cp .:/usr/share/java/postgresql.jar program` (this was the path in Debian).
