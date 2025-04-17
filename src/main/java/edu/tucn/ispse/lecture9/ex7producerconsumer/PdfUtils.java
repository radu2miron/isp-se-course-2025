package edu.tucn.ispse.lecture9.ex7producerconsumer;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
public class PdfUtils {
    public static String getText(File pdfFile) throws IOException {
        PDDocument doc = Loader.loadPDF(pdfFile);
        return new PDFTextStripper().getText(doc);
    }
}
