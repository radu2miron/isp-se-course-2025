package edu.tucn.ispse.lecture8.ex2_layouts;

import javax.swing.*;
import java.awt.*;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
public class NoLayoutExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Null Layout Example");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Container pane = frame.getContentPane();
        pane.setLayout(null);

        JButton b1 = new JButton("Button 1");
        b1.setBounds(10, 10, 100, 20);
        pane.add(b1);

        JButton b2 = new JButton("Button 2");
        b2.setBounds(30, 40, 100, 20);
        pane.add(b2);

        frame.setSize(200, 100);
        frame.setVisible(true);
    }
}
