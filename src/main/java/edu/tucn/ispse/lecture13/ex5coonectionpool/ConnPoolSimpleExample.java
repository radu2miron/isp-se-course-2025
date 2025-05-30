package edu.tucn.ispse.lecture13.ex5coonectionpool;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static edu.tucn.ispse.lecture13.utils.ConnectionUtils.*;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
public class ConnPoolSimpleExample {
    public static void main(String[] args) {
        // configure HikariCP
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(DB_URL);
        config.setUsername(USER);
        config.setPassword(PASS);
        config.setMaximumPoolSize(2);
        config.setMinimumIdle(1);

        // create the datasource
        HikariDataSource dataSource = new HikariDataSource(config);

        try (Connection connection = dataSource.getConnection(); // get a connection from the pool
             Statement statement = connection.createStatement(); // create a statement
             ResultSet resultSet = statement.executeQuery("SELECT * FROM students")) { // execute query

            // Process the result set
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                System.out.println(String.format("ID: %d, Name: %s %s", id, firstName, lastName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the datasource
            dataSource.close();
        }
    }
}
