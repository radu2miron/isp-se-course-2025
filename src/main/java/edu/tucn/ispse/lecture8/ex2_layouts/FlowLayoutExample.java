package edu.tucn.ispse.lecture8.ex2_layouts;

import javax.swing.*;
import java.awt.*;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
public class FlowLayoutExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Flow Layout Example");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Container pane = frame.getContentPane();
        pane.setLayout(new FlowLayout());

        for (int i = 1; i <= 5; i++) {
            pane.add(new JButton("B" + i));
        }

//        frame.setSize(400, 200);
        frame.pack();
        frame.setVisible(true);
    }
}
