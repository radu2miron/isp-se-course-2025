package edu.tucn.ispse.lecture13.ex6connectionpool;

import edu.tucn.ispse.lecture13.utils.CpUtils;
import edu.tucn.ispse.lecture13.utils.model.ProcessedFile;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
public class ProcessedFileRepository {
    private static final String INSERT = "INSERT INTO processed_files(file_path, text) VALUES (?, ?)";

    public void insertProcessedFile(ProcessedFile processedFile) {
        try (Connection conn = CpUtils.getConnection();
             PreparedStatement stmt = conn.prepareStatement(INSERT)) {
            stmt.setString(1, processedFile.filePath());
            stmt.setString(2, processedFile.text());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
