package edu.tucn.ispse.lecture4.systemcomponents;

import edu.tucn.ispse.lecture4.Main;
import edu.tucn.ispse.lecture4.model.Ticket;
import edu.tucn.ispse.lecture4.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
class TicketSystemTest {
    private TicketSystem ticketSystem;

    @BeforeEach
    void init() {
        User[] users = Main.createUsers();
        AuthenticationModule authenticationModule = new AuthenticationModule(users);
        ticketSystem = new TicketSystem(authenticationModule);
    }

    @Test
    void testBuyTickets() {
        Ticket ticket = ticketSystem.buyTicket();
        Assertions.assertNotNull(ticket, "the ticket should have been created");
        Assertions.assertTrue(ticket.isValid(), "initially, the ticket should be valid");
        Assertions.assertNotNull(ticket.getSerialNumber(), "the serial number should be not null");
        Assertions.assertNotNull(ticket.getImagePath(), "the image path number should be not null");
    }

    @Test
    void testScanTickets() {
        Ticket ticket = ticketSystem.buyTicket();
        Assertions.assertNotNull(ticket, "the ticket should have been created");

        Assertions.assertTrue(ticketSystem.scanTicket(ticket.getImagePath()), "the ticket should pass the scan");
        Assertions.assertFalse(ticket.isValid(), "the ticket should be invalidated after the scan");
    }

    @Test
    void testCancelTicket() {
        Ticket ticket = ticketSystem.buyTicket();
        Assertions.assertNotNull(ticket, "the ticket should have been created");
        ticketSystem.cancelTicket(ticket.getSerialNumber());
        Assertions.assertNotNull(ticket, "the ticket should be not null after the cancellation");
        Assertions.assertFalse(ticket.isValid());
    }
}
