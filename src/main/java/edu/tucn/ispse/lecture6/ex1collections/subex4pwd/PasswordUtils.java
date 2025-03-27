package edu.tucn.ispse.lecture6.ex1collections.subex4pwd;

import org.mindrot.jbcrypt.BCrypt;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
public class PasswordUtils {

    public static String hashPassword(String password) {
        int workload = 12; // You can adjust the workload (strength) of the encryption here
        String salt = BCrypt.gensalt(workload);
        String hashedPassword = BCrypt.hashpw(password, salt);
        return hashedPassword;
    }

    public static boolean checkPassword(String password, String hashedPassword) {
        return BCrypt.checkpw(password, hashedPassword);
    }
}
