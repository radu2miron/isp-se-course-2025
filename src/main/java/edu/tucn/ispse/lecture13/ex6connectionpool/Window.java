package edu.tucn.ispse.lecture13.ex6connectionpool;

import edu.tucn.ispse.lecture13.utils.TessUtils;
import edu.tucn.ispse.lecture13.utils.model.ProcessedFile;

import javax.swing.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
public class Window extends JFrame {
    public static final ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(10);
    public static final Set<String> PROCESSED_FILES = new HashSet<>();
    public static final ProcessedFileRepository processedFileRepo = new ProcessedFileRepository();

    public Window() {
        setTitle("Process images and save text in DB");
        setLayout(null);
        setSize(500, 350);

        JLabel label = new JLabel("Selected dir");
        label.setBounds(20, 20, 100, 20);
        this.add(label);

        JTextField textField = new JTextField();
        textField.setBounds(120, 20, 200, 20);
        textField.setEditable(false);
        this.add(textField);

        JButton selButton = new JButton("Select");
        selButton.setBounds(340, 20, 100, 20);

        selButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser("."); // project root dir
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int r = fileChooser.showSaveDialog(null);

            if (r == JFileChooser.APPROVE_OPTION) {
                // set the label to the path of the selected file
                textField.setText(fileChooser.getSelectedFile().getAbsolutePath());
            }
        });
        this.add(selButton);

        JTextArea jTextArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(jTextArea);
        scrollPane.setBounds(20, 80, 400, 200);
        this.add(scrollPane);

        JButton processButton = new JButton("Process files");
        processButton.setBounds(20, 50, 150, 20);
        processButton.addActionListener(e -> {
            String dir = textField.getText();
            if (!dir.isEmpty()) {
                jTextArea.setText("Start processing:\n");
                try {
                    Files.list(Path.of(dir))
                            .map(Path::toFile)
                            .filter(f -> f.getName().toLowerCase().endsWith(".png") && !PROCESSED_FILES.contains(f.getName()))
                            .forEach(f -> {
                                jTextArea.append(f.getAbsolutePath() + "\n");
                                EXECUTOR_SERVICE.submit(() -> {
                                    String text = TessUtils.readText(f);
                                    ProcessedFile processedFile = new ProcessedFile(null, f.getAbsolutePath(), text);
                                    processedFileRepo.insertProcessedFile(processedFile);
                                    PROCESSED_FILES.add(f.getName());
                                });
                            });
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            } else {
                jTextArea.append("Select a directory!\n");
            }
        });
        this.add(processButton);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
