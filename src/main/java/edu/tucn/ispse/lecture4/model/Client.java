package edu.tucn.ispse.lecture4.model;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
public class Client extends User {
    private String idNumber; // currently not used
    private Ticket ticket;

    public Client(String userName, String password, String idNumber) {
        super(userName, password);
        this.idNumber = idNumber;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
