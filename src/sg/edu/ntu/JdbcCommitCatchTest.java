package sg.edu.ntu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcCommitCatchTest {
    public static void main(String[] args) {
        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/ebookshop?useSSL=false", "murat", "muratbek");
                Statement stmt = conn.createStatement()
        ) {
            try {
                // Disable auto-commit
                conn.setAutoCommit(false);

                // Issue two INSERT statements
                stmt.executeUpdate("INSERT INTO books VALUES (4001, 'Paul Chan', 'Mahjong 101', 4.4, 4)");
                // Duplicate primary key, which triggers a SQLException
                stmt.executeUpdate("INSERT INTO books VALUES (4001, 'Peter Chan', 'Mahjong 102', 4.4, 4)");
                conn.commit(); // Commit changes only if all statements succeed.
            } catch (SQLException e) {
                System.out.println("-- Rolling back changes --");
                conn.rollback(); // Rollback to the last commit.
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
