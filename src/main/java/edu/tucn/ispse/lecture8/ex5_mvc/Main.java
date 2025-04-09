package edu.tucn.ispse.lecture8.ex5_mvc;

import edu.tucn.ispse.lecture8.ex5_mvc.controller.PersonController;
import edu.tucn.ispse.lecture8.ex5_mvc.model.PersonModel;
import edu.tucn.ispse.lecture8.ex5_mvc.view.PersonView;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
public class Main {
    public static void main(String[] args) {
        PersonModel personModel = new PersonModel();
        PersonView personView = new PersonView();
        new PersonController(personModel, personView);
    }
}
