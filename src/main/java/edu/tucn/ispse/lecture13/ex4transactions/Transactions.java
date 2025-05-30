package edu.tucn.ispse.lecture13.ex4transactions;

import edu.tucn.ispse.lecture13.utils.model.Address;
import edu.tucn.ispse.lecture13.utils.model.Student;
import edu.tucn.ispse.lecture13.utils.model.StudentAddr;

import java.sql.*;
import java.time.LocalDate;

import static edu.tucn.ispse.lecture13.utils.ConnectionUtils.*;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
public class Transactions {
    private static final String INSERT_STUDENT = "INSERT INTO students_addr(first_name, last_name, date_of_birth, address_id) VALUES (?, ?, ?, ?)";
    private static final String INSERT_ADDRESS = "INSERT INTO addresses(street, city, country) VALUES (?, ?, ?)";

    public static void main(String[] args) {
        createTablesIfNotExist();

        // execute successful transaction
        executeTransaction(new StudentAddr(null, "Monica", "Popescu", Date.valueOf(LocalDate.parse("2006-01-10")), null),
                new Address(null, "1st Long Street", "Cluj-Napoca", "Romania"));

        // execute unsuccessful transaction
        executeTransaction(new StudentAddr(null, "Levi", "Johnson-DeLuca-Alhambra-Dux", Date.valueOf(LocalDate.parse("2006-01-10")), null),
                new Address(null, "3rd Clean Street", "Wellington", "New-Zealand"));
        // the second transaction fails because the city name is too long (city VARCHAR(30))
    }

    private static void executeTransaction(StudentAddr student, Address address) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) { // open a connection
            try (PreparedStatement stmtStud = conn.prepareStatement(INSERT_STUDENT); // create statement
                 PreparedStatement stmtAddr = conn.prepareStatement(INSERT_ADDRESS, Statement.RETURN_GENERATED_KEYS)) { // create a statement that returns the generated key
                conn.setAutoCommit(false); // open transaction

                //INSERT ADDRESS
                stmtAddr.setString(1, address.street());
                stmtAddr.setString(2, address.city());
                stmtAddr.setString(3, address.country());
                stmtAddr.executeUpdate(); // execute the statement

                // retrieve the auto generated address id
                int addressId = -1;
                ResultSet generatedKeys = stmtAddr.getGeneratedKeys();
                if (generatedKeys.next()) {
                    addressId = generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Unable to retrieve primary key for address");
                }

                // INSERT STUDENT
                stmtStud.setString(1, student.firstName());
                stmtStud.setString(2, student.lastName());
                stmtStud.setDate(3, new Date(student.dateOfBirth().getTime()));
                stmtStud.setInt(4, addressId);
                stmtStud.executeUpdate(); // execute the insert students statement

                conn.commit(); // commit the transaction
            } catch (SQLException ex) {
                conn.rollback(); // rollback the changes
                throw ex;
            } finally {
                conn.setAutoCommit(true);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createTablesIfNotExist() {
        String sqlCreateStudents = """
                    CREATE TABLE IF NOT EXISTS students_addr(
                        id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                        first_name VARCHAR(20),
                        last_name VARCHAR(20),
                        date_of_birth DATE,
                        address_id INT,
                        CONSTRAINT fk_address_id FOREIGN KEY (address_id)
                            REFERENCES addresses(id)
                            ON DELETE CASCADE
                            ON UPDATE CASCADE
                )""";

        String sqlCreateAddresses = """
                    CREATE TABLE IF NOT EXISTS addresses(
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        street VARCHAR(255),
                        city VARCHAR(30),
                        country VARCHAR(30)
                )""";

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) { // open a connection
            try (Statement stmt = conn.createStatement()) { // create a statement
                conn.setAutoCommit(false); // open transaction
                stmt.executeUpdate(sqlCreateAddresses); // execute the statement
                stmt.executeUpdate(sqlCreateStudents); // execute the statement
                System.out.println("Created 'addresses' and 'students' tables");
                conn.commit(); // commit the transaction
            } catch (SQLException ex) {
                conn.rollback(); // rollback the changes
                throw ex;
            } finally {
                conn.setAutoCommit(true);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
