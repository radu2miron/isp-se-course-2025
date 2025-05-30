package edu.tucn.ispse.lecture13.ex1createdropdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static edu.tucn.ispse.lecture13.utils.ConnectionUtils.*;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
public class DropDB {
    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(SERVER_URL, USER, PASS); // open a connection
             Statement stmt = conn.createStatement()) { // create a statement
            String sql = "DROP DATABASE universities";
            stmt.executeUpdate(sql); // execute the statement
            System.out.println("Deleted 'universities' DB");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
