package edu.tucn.ispse.lecture3.ex2polymorphism.wopoly;

import java.util.Scanner;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Input: 1. Dacia, 2. BMW, 3. Exit");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();

        switch (choice){
            case "1" -> {
                Dacia dacia = new Dacia();
                dacia.start();
                dacia.go();
                dacia.stop();
            }
            case "2" -> {
                BMW bmw = new BMW();
                bmw.start();
                bmw.go();
                bmw.stop();
            }
        }
    }
}
