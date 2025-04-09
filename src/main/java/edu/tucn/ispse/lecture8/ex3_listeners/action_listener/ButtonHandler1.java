package edu.tucn.ispse.lecture8.ex3_listeners.action_listener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
public class ButtonHandler1 implements ActionListener {
    private JFrame parentContainer;

    public ButtonHandler1(JFrame parentContainer) {
        this.parentContainer = parentContainer;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JOptionPane.showMessageDialog(parentContainer,
                actionEvent.getActionCommand(),
                "Information",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
