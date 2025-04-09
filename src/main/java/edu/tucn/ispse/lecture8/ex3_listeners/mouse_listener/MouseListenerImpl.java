package edu.tucn.ispse.lecture8.ex3_listeners.mouse_listener;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
class MouseListenerImpl implements MouseListener {
    @Override
    public void mouseClicked(MouseEvent e) {
        JOptionPane.showMessageDialog(null,
                "You clicked the JButton!",
                "Mouse Clicked",
                JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("Mouse entered the button");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("Mouse exited the button");
    }
}
