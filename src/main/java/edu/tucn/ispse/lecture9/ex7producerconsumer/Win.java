package edu.tucn.ispse.lecture9.ex7producerconsumer;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
public class Win extends JFrame {
    private ArrayBlockingQueue<File> queue;
    private JTextArea logArea;

    Win(ArrayBlockingQueue<File> queue) {
        this.queue = queue;
        setTitle("Pdf Text Extractor");
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
            FileFilter filter = new FileNameExtensionFilter("PDF file", "pdf", "PDF"); // pdfs only filter
            JFileChooser fileChooser = new JFileChooser("testfiles/pdfs"); // open file chooser in 'testfiles' dir
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY); // enables file choosing only
            fileChooser.addChoosableFileFilter(filter);
            fileChooser.setFileFilter(filter);

            int r = fileChooser.showSaveDialog(null);

            if (r == JFileChooser.APPROVE_OPTION) {
                // set the text to the path of the selected file
                filePathInput.setText(fileChooser.getSelectedFile().getAbsolutePath());
            }
        });

        JButton processButton = new JButton("Process Files");
        processButton.setBounds(20, 60, 340, 20);

        logArea = new JTextArea();
        JScrollPane scrollableResults = new JScrollPane(logArea);
        scrollableResults.setBounds(20, 100, 340, 300);

        processButton.addActionListener(ae -> { // 'Process Files' click handler
            File file = new File(filePathInput.getText());

            try {
                queue.put(file); // add file to queue
            } catch (InterruptedException ignored) {
            }

            logArea.append(String.format("Thread %s added %s for processing%s",
                    Thread.currentThread().getName(), file.getName(), "\n"));
        });

        add(filePathInput);
        add(processButton);
        add(scrollableResults);
        add(selButton);

        setVisible(true);
    }

    public JTextArea getLogArea() {
        return logArea;
    }
}
