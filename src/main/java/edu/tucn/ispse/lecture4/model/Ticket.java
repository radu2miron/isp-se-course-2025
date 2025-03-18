package edu.tucn.ispse.lecture4.model;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
public class Ticket {
    private String serialNumber;
    private String imagePath;
    private boolean valid;

    public Ticket(String serialNumber) {
        this.serialNumber = serialNumber;
        this.imagePath = "tickets/" + serialNumber + ".png";
        this.valid = true;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public boolean isValid() {
        return valid;
    }

    public void cancel() {
        this.valid = false;
    }

    public String getImagePath() {
        return imagePath;
    }
}
