package edu.tucn.ispse.lecture3.ex2polymorphism.wpoly;

import java.util.Scanner;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Input: 1. Dacia, 2. BMW, 3. Exit");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();

        Car car = switch (choice) {
            case "1" -> new Dacia();
            case "2" -> new BMW();
            default -> throw new IllegalStateException("Unexpected value: " + choice);
        };

        car.start();
        car.go();
        car.stop();
    }
}
