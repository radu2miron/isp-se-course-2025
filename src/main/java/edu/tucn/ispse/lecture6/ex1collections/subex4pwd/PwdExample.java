package edu.tucn.ispse.lecture6.ex1collections.subex4pwd;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
public class PwdExample {
    private static final Map<String, String> CREDENTIALS = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String choice = "1";

        while (!choice.equals("3")) {
            System.out.println("1. Add credentials, 2. Check credentials, 3. Exit");
            choice = scanner.nextLine();

            switch (choice) {
                case "1" -> {
                    System.out.println("Add username");
                    String usr = scanner.nextLine();
                    System.out.println("Add password");
                    String pwd = scanner.nextLine();
                    CREDENTIALS.put(usr, PasswordUtils.hashPassword(pwd));
                    System.out.println("Hashed pwd: " + PasswordUtils.hashPassword(pwd));
                }
                case "2" -> {
                    System.out.println("Username");
                    String usr = scanner.nextLine();
                    System.out.println("Password");
                    String pwd = scanner.nextLine();
                    String storedHashedPwd = CREDENTIALS.get(usr);

                    if (storedHashedPwd != null && PasswordUtils.checkPassword(pwd, storedHashedPwd)) {
                        System.out.println("Valid credentials!");
                    } else {
                        System.out.println("Invalid credentials!");
                    }
                }
            }
        }
    }
}
