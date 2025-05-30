package edu.tucn.ispse.lecture13.ex3crudoperations;

import edu.tucn.ispse.lecture13.utils.model.Student;

import java.sql.*;
import java.time.LocalDate;

import static edu.tucn.ispse.lecture13.utils.ConnectionUtils.*;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
public class CrudOperations {
    private static final Student[] STUDENTS = new Student[]{
            new Student(null, "John", "Doe", Date.valueOf(LocalDate.parse("2006-01-10"))),
            new Student(null, "Jane", "Doe", Date.valueOf(LocalDate.parse("2006-02-12"))),
            new Student(null, "Morgan", "Smith", Date.valueOf(LocalDate.parse("2007-05-30"))),
            new Student(null, "Taylor", "Davis", Date.valueOf(LocalDate.parse("2007-07-14")))};

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS); // open a connection
             Statement stmt = conn.createStatement()) { // create a statement
            // Create (insert)
            String sql = "INSERT INTO students(first_name, last_name, date_of_birth)" +
                    "VALUES ('" + STUDENTS[0].firstName() + "', '" + STUDENTS[0].lastName() + "', '" + STUDENTS[0].dateOfBirth() + "')," +
                    "       ('" + STUDENTS[1].firstName() + "', '" + STUDENTS[1].lastName() + "', '" + STUDENTS[1].dateOfBirth() + "')," +
                    "       ('" + STUDENTS[2].firstName() + "', '" + STUDENTS[2].lastName() + "', '" + STUDENTS[2].dateOfBirth() + "')," +
                    "       ('" + STUDENTS[3].firstName() + "', '" + STUDENTS[3].lastName() + "', '" + STUDENTS[3].dateOfBirth() + "');";
            stmt.executeUpdate(sql); // execute the statement
            System.out.println("Inserted 4 records into 'students'");

            // Read (select)
            sql = "SELECT * FROM students WHERE date_of_birth > '2006-12-31';";
            try (ResultSet rs = stmt.executeQuery(sql)) { // execute query; the tuples will be put inside the result set
                while (rs.next()) { // iterate the result set
                    Student student = new Student(
                            rs.getInt("id"),
                            rs.getString("first_name"),
                            rs.getString("last_name"),
                            rs.getDate("date_of_birth"));
                    System.out.println(student);
                }
            }

            // Update
            sql = "UPDATE students SET first_name = 'Michael' WHERE first_name = 'John';";
            stmt.executeUpdate(sql);
            System.out.println("Updated record with first name 'John'");

            //Delete
            sql = "DELETE FROM students WHERE last_name = 'Davis';";
            stmt.executeUpdate(sql);
            System.out.println("Deleted record with last name 'Davis'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
