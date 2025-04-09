package edu.tucn.ispse.lecture8.ex4_components;

import javax.swing.*;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
public class LabelTextFieldTextAreaExample extends JFrame {
    public LabelTextFieldTextAreaExample() {
        //setup the window
        super("JLabel JTextField JTextArea Example");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setBounds(200, 200, 400, 400);

        //create and add components
        JLabel label = new JLabel("Enter some text:");
        label.setBounds(20, 20, 160, 20);
        this.add(label);

        JTextField textField = new JTextField();
        textField.setBounds(220, 20, 120, 20);
        this.add(textField);

        JButton button = new JButton("Add text to text area");
        button.setBounds(20, 60, 320, 20);
        this.add(button);

        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(20, 100, 320, 200);
        this.add(scrollPane);

        //add event listener
        button.addActionListener(e -> textArea.append(textField.getText() + "\n"));

        //display
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new LabelTextFieldTextAreaExample();
    }
}
