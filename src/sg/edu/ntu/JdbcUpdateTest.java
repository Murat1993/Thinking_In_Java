package sg.edu.ntu;

import java.sql.*;

public class JdbcUpdateTest {
    public static void main(String[] args) {
        try (
                // Step 1: Allocate a database 'Connection' object
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/ebookshop?useSSL=false", "murat", "muratbek");

                // Step 2: Allocate a 'Statement' object in the Connection
                Statement stmt = conn.createStatement()
        ) {
            // Step 3 & 4: Execute a SQL UPDATE via executeUpdate()
            // which return an int indicating the number of rows affected.
            // Increase the price by 7% and qty by 1 for id=1001
            String strUpdate = "update books set price = price * 0.7, qty = qty + 1 where id = 1001";
            System.out.println("The SQL query is: " + strUpdate); // Echo for debugging
            int countUpdated = stmt.executeUpdate(strUpdate);
            System.out.println(countUpdated + " records affected.");

            // Step 3 & 4: Issue a SELECT to check the UPDATE.
            String strSelect = "select * from books where id = 1001";
            System.out.println("The SQL query is: " + strSelect); // Echo for debugging
            ResultSet resultSet = stmt.executeQuery(strSelect);

            while (resultSet.next()) { // Move the cursor to the next row
                System.out.println(resultSet.getInt("id") + ", "
                        + resultSet.getString("author") + ", "
                        + resultSet.getString("title") + ", "
                        + resultSet.getDouble("price") + ", "
                        + resultSet.getInt("qty"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Step 5: Close the resources - Done automatically by try-with-resources
    }
}
