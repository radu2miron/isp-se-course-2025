package edu.tucn.ispse.lecture13.ex3crudoperations;

import edu.tucn.ispse.lecture13.utils.model.Student;

import java.sql.*;
import java.time.LocalDate;

import static edu.tucn.ispse.lecture13.utils.ConnectionUtils.*;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
public class CrudOperationsPreparedStmt {
    private static final Student[] STUDENTS = new Student[]{
            new Student(null, "John", "Doe", Date.valueOf(LocalDate.parse("2006-01-10"))),
            new Student(null, "Jane", "Doe", Date.valueOf(LocalDate.parse("2006-02-12"))),
            new Student(null, "Morgan", "Smith", Date.valueOf(LocalDate.parse("2007-05-30"))),
            new Student(null, "Taylor", "Davis", Date.valueOf(LocalDate.parse("2007-07-14")))};

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) { // open a connection

            // Create (insert)
            String sql = "INSERT INTO students(first_name, last_name, date_of_birth) VALUES (?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                for (Student student : STUDENTS) {
                    stmt.setString(1, student.firstName());
                    stmt.setString(2, student.lastName());
                    stmt.setDate(3, new Date(student.dateOfBirth().getTime()));
                    stmt.executeUpdate();
                }
                System.out.println("Inserted 4 records into 'students'");
            }

            // Read (select)
            sql = "SELECT * FROM students WHERE date_of_birth > ?;";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setDate(1, Date.valueOf("2006-12-31"));

                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        Student student = new Student(
                                rs.getInt("id"),
                                rs.getString("first_name"),
                                rs.getString("last_name"),
                                rs.getDate("date_of_birth"));
                        System.out.println(student);
                    }
                }
            }

            // Update
            sql = "UPDATE students SET first_name = ? WHERE first_name = ?;";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, "Michael");
                stmt.setString(2, "John");
                stmt.executeUpdate();
                System.out.println("Updated record with first name 'John'");
            }

            //Delete
            sql = "DELETE FROM students WHERE last_name = ?;";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, "Davis");
                stmt.executeUpdate();
                System.out.println("Deleted record with last name 'Davis'");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
