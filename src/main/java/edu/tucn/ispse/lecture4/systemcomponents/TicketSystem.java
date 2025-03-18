package edu.tucn.ispse.lecture4.systemcomponents;

import edu.tucn.ispse.lecture4.model.Client;
import edu.tucn.ispse.lecture4.model.Ticket;
import edu.tucn.ispse.lecture4.model.User;

import java.io.File;
import java.util.UUID;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
public class TicketSystem {
    private AuthenticationModule authenticationModule;
    private QrModule qrModule;
    private User loggedInUser;
    private Ticket[] tickets = new Ticket[100];
    private int ticketCounter = 0;

    public TicketSystem(AuthenticationModule authenticationModule) {
        this.authenticationModule = authenticationModule;
        this.qrModule = new QrModule();
    }

    public User login(String username, String password) {
        User user = authenticationModule.checkCredentials(username, password);

        if (user != null) {
            loggedInUser = user;
            return loggedInUser;
        }

        System.err.println("Bad credentials");

        return null;
    }

    public void cancelTicket(String serialNumber) {
        Ticket ticket = findTicket(serialNumber);
        ticket.cancel();
    }

    public Ticket buyTicket() {
        if (ticketCounter == 100) {
            throw new RuntimeException("No more tickets!");
        }

        String serialNumber = UUID.randomUUID().toString();
        Ticket ticket = new Ticket(serialNumber);
        qrModule.createQRImage(new File(ticket.getImagePath()), serialNumber);

        if (loggedInUser instanceof Client) {
            ((Client) loggedInUser).setTicket(ticket);
        }

        tickets[ticketCounter++] = ticket;

        return ticket;
    }

    public boolean scanTicket(String imagePath) {
        // if there is no qr code image path provided we'll try getting it from the user
        if (imagePath == null && loggedInUser instanceof Client) {
            Ticket ticket = ((Client) loggedInUser).getTicket();

            if (ticket != null) {
                imagePath = ticket.getImagePath();
            }
        }

        if (imagePath != null) {
            String serialNumber = qrModule.readQrCode(new File(imagePath));
            Ticket ticket = findTicket(serialNumber);

            if (ticket != null && ticket.isValid()) {
                ticket.cancel();
                return true;
            }
        }

        return false;
    }

    private Ticket findTicket(String serialNumber) {
        for (Ticket ticket : tickets) {
            if (ticket != null && serialNumber.equals(ticket.getSerialNumber())) {
                return ticket;
            }
        }

        return null;
    }
}
