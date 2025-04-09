package edu.tucn.ispse.lecture8.ex1_simple_app;

import javax.swing.*;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
public class Window {
    public static void main(String[] args) {
        // create components
        JFrame frame = new JFrame("My Frame");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        JLabel label = new JLabel("This is a label");
        JButton button = new JButton("Button");

        button.addActionListener(e-> System.out.println("click"));

        // add components to the panel
        panel.add(label); panel.add(button);

        // sets the windows main container
        frame.setContentPane(panel);
        frame.pack(); // sets the components to preferred sizes

        // make the window visible
        frame.setVisible(true);
    }
}
