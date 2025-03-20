package edu.tucn.ispse.lecture5.ex3anonymous.ex31;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
public class Win extends JFrame {
    public Win() {
        this.setLocation(new Random().nextInt(1500), new Random().nextInt(700));
        this.setSize(300, 100);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        JButton button = new JButton("Click me!");

        // standalone class that implements ActionListener
//        ActionListener clickHandler = new ButtonClickHandler();
//        button.addActionListener(clickHandler);

        // ActionListener as an anonymous class
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new Win();
            }
        });

        // ActionListener as a lambda expression
//        button.addActionListener(e -> new Win());

        this.add(button);
        this.setVisible(true);
    }
}
