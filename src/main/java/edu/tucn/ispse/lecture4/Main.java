package edu.tucn.ispse.lecture4;

import edu.tucn.ispse.lecture4.systemcomponents.AuthenticationModule;
import edu.tucn.ispse.lecture4.systemcomponents.TicketSystem;
import edu.tucn.ispse.lecture4.systemcomponents.UserInterface;
import edu.tucn.ispse.lecture4.model.Admin;
import edu.tucn.ispse.lecture4.model.Client;
import edu.tucn.ispse.lecture4.model.User;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
public class Main {
    public static void main(String[] args) {
        initializeSystem();
    }

    private static void initializeSystem() {
        // initialize components and ticket system
        User[] users = createUsers();
        AuthenticationModule authenticationModule = new AuthenticationModule(users);
        TicketSystem ticketSystem = new TicketSystem(authenticationModule);

        //initialize and load UI
        UserInterface userInterface = new UserInterface(ticketSystem);
        userInterface.loadGeneralUserInterface();
    }

    public static User[] createUsers() {
        User[] users = new User[3];
        users[0] = new Admin("admin", "pwd1");
        users[1] = new Client("client1", "pwd2", "id123");
        users[2] = new Client("client2", "pwd3", "id456");
        return users;
    }
}
