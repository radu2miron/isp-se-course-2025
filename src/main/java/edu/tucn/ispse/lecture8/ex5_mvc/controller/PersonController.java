package edu.tucn.ispse.lecture8.ex5_mvc.controller;

import edu.tucn.ispse.lecture8.ex5_mvc.model.PersonModel;
import edu.tucn.ispse.lecture8.ex5_mvc.view.PersonView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
public class PersonController implements ActionListener {
    private PersonModel model;
    private PersonView view;

    public PersonController(PersonModel model, PersonView view) {
        this.model = model;
        this.view = view;
        this.view.addSubmitListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        String id = view.getId();
        String firstName = view.getFirstName();
        String lastName = view.getLastName();
        try {
            model.addPerson(Integer.parseInt(id), firstName, lastName);
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null,
                    "Person Id should be a number",
                    "Invalid id!",
                    JOptionPane.INFORMATION_MESSAGE);
        }
        view.updatePersonList(model.getPersons());
    }
}

