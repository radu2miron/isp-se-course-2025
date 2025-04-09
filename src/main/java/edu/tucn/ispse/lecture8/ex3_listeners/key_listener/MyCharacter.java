package edu.tucn.ispse.lecture8.ex3_listeners.key_listener;

import javax.swing.*;
import java.awt.*;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
public class MyCharacter extends JComponent {
    @Override
    public void paint(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(0,0,20,20);
    }
}
