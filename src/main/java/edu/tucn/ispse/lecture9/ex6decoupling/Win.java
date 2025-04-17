package edu.tucn.ispse.lecture9.ex6decoupling;

import javax.swing.*;
import java.util.Map;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
public class Win extends JFrame {
    Win() {
        setTitle("Character Frequency Calculator");
        setBounds(800, 300, 380, 460);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JTextField filePathInput = new JTextField();
        filePathInput.setBounds(200, 20, 160, 20);
        filePathInput.setEnabled(false);

        JButton selButton = new JButton("Select File");
        selButton.setBounds(20, 20, 160, 20);

        selButton.addActionListener(e -> { // 'Select File click handler'
            JFileChooser fileChooser = new JFileChooser("testfiles"); // open file chooser in 'testfiles' dir
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY); // enables file choosing only
            int r = fileChooser.showSaveDialog(null);

            if (r == JFileChooser.APPROVE_OPTION) {
                // set the label to the path of the selected file
                filePathInput.setText(fileChooser.getSelectedFile().getAbsolutePath());
            }
        });

        JButton processButton = new JButton("Process File");
        processButton.setBounds(20, 60, 340, 20);

        JTextArea resultsSection = new JTextArea();
        JScrollPane scrollableResults = new JScrollPane(resultsSection);
        scrollableResults.setBounds(20, 100, 340, 300);

        processButton.addActionListener(ae -> { // 'Process File' click handler
//            new Thread(() -> { // todo: uncomment this line
            String filePath = filePathInput.getText();
            Map<String, Integer> results = FileUtils.processFile(filePath);
            StringBuilder builder = new StringBuilder();
            builder.append(Thread.currentThread().getName() + " processed file: \n");
            builder.append("    " + filePath + "\n");
            builder.append("Results: \n");
            results.forEach((k, v) ->
                    builder.append("    " + k + ": " + v + "\n"));
            builder.append("------------------------------------------\n\n");
            resultsSection.append(builder.toString());
//            }).start(); // todo: ... and this line to decouple the file processing on a new Thread
        });

        add(filePathInput);
        add(processButton);
        add(scrollableResults);
        add(selButton);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Win();
    }
}
