package sg.edu.ntu;

import java.sql.*;

public class JdbcInsertTest { // Save as "JdbcUpdateTest.java"
    public static void main(String[] args) {
        try (
                // Step 1: Allocate a database 'Connection' object
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/ebookshop?useSSL=false", "murat", "muratbek");
                // Step 2: Allocate a 'Statement' object in the Connection
                Statement stmt = conn.createStatement()
        ) {
            // Step 3 & 4: Execute a SQL INSERT|DELETE statement via executeUpdate(),
            // which return an int indicating the number of rows affected.

            // DELETE records with id >= 3000 and id < 4000
            String sqlDelete = "delete from books where id >= 3000 and id < 4000";
            System.out.println("The SQL query is: " + sqlDelete); // Echo for debugging
            int countDeleted = stmt.executeUpdate(sqlDelete);
            System.out.println(countDeleted + " records deleted.\n");


            // INSERT a record
            String sqlInsert = "insert into books "
                    + "values (3001, 'Gone Fishing', 'Kumar', 11.11, 11)";
            System.out.println("The SQL query is: " + sqlInsert);
            int countInserted = stmt.executeUpdate(sqlInsert);
            System.out.println(countInserted + " records inserted.\n");

            // INSERT multiple records
            sqlInsert = "insert INTO books VALUES "
                    + "(3002, 'Gone Fishing 2', 'Kumar', 22.22, 22),"
                    + "(3003, 'Gone Fishing 3', 'Kumar', 33.33, 33)";
            System.out.println("The SQL query is: " + sqlInsert);
            countInserted = stmt.executeUpdate(sqlInsert);
            System.out.println(countInserted + " records inserted.\n");

            // INSERT a partial record
            sqlInsert = "insert INTO books (id, title, author) "
                    + "VALUES (3004, 'Fishing 101', 'Kumar')";
            System.out.println("The SQL query is: " + sqlInsert);
            countInserted = stmt.executeUpdate(sqlInsert);
            System.out.println(countInserted + " records inserted.\n");

            // Issue a SELECT to check the changes
            String strSelect = "select * from books";
            System.out.println("The SQL query is: " + strSelect);
            ResultSet rset = stmt.executeQuery(strSelect);
            while (rset.next()) { // Move the cursor to the next row
                System.out.println(rset.getString("id") + ", "
                        + rset.getString("author") + ", "
                        + rset.getString("title") + ", "
                        + rset.getDouble("price") + ", "
                        + rset.getInt("qty"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Step 5: Close the resources - Done automatically by try-with-resources
    }
}
