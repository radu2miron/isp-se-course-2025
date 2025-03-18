package edu.tucn.ispse.lecture4.systemcomponents;

import edu.tucn.ispse.lecture4.model.Admin;
import edu.tucn.ispse.lecture4.model.User;

import java.util.Scanner;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
public class UserInterface {
    private TicketSystem ticketSystem;
    private Scanner scanner;

    public UserInterface(TicketSystem ticketSystem) {
        this.ticketSystem = ticketSystem;
        scanner = new Scanner(System.in);
    }

    public void loadGeneralUserInterface() {
        String choice = "";

        while (!choice.equals("2")) {
            System.out.println("1. login; 2. exit");
            choice = scanner.nextLine();

            if (choice.equals("1")) {
                System.out.println("Username:");
                String userName = scanner.nextLine();
                System.out.println("Password:");
                String password = scanner.nextLine();

                User loggedInUser = ticketSystem.login(userName, password);

                if (loggedInUser != null) {
                    if (loggedInUser instanceof Admin) {
                        loadAdminInterface();
                    } else {
                        loadClientInterface();
                    }
                }
            }
        }
    }

    private void loadAdminInterface() {
        String choice = "";

        while (!choice.equals("2")) {
            System.out.println("1. cancel ticket; 2. exit");
            choice = scanner.nextLine();

            if (choice.equals("1")) {
                System.out.println("Ticket serial number: ");
                ticketSystem.cancelTicket(scanner.nextLine());
            }
        }
    }

    private void loadClientInterface() {
        String choice = "";

        while (!choice.equals("3")) {
            System.out.println("1. buy ticket; 2. scan ticket; 3.exit");
            choice = scanner.nextLine();

            if (choice.equals("1")) {
                ticketSystem.buyTicket();
            } else if (choice.equals("2")) {
                boolean scanResult = ticketSystem.scanTicket(null);
                if (scanResult) {
                    System.out.println("Valid ticket! Enjoy!");
                } else {
                    System.err.println("INVALID TICKET!");
                }
            }
        }
    }
}
