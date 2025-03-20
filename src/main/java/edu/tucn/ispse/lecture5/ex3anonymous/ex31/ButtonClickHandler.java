package edu.tucn.ispse.lecture5.ex3anonymous.ex31;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
public class ButtonClickHandler implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        new Win();
    }
}
