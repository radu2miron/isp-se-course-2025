package edu.tucn.ispse.lecture13.utils;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

import static edu.tucn.ispse.lecture13.utils.ConnectionUtils.*;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
public class CpUtils {
    private static volatile HikariDataSource dataSource;

    private CpUtils() {
    }

    private static synchronized HikariDataSource getDataSource() {
        if (dataSource == null) {
            HikariConfig config = new HikariConfig();
            config.setJdbcUrl(DB_URL_2);
            config.setUsername(USER);
            config.setPassword(PASS);
            config.setMaximumPoolSize(3);
            config.setMinimumIdle(1);

            dataSource = new HikariDataSource(config);
        }

        return dataSource;
    }

    public static Connection getConnection() throws SQLException {
        return getDataSource().getConnection();
    }
}
