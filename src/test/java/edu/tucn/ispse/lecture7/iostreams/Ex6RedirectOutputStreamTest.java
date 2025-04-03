package edu.tucn.ispse.lecture7.iostreams;

import edu.tucn.ispse.lecture7.iostreams.Ex6RedirectOutputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * @author Radu Miron
 * @version 1
 */
public class Ex6RedirectOutputStreamTest {
    private static final String SOMETHING = "Something!";
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void testPrintSomething(){
        Ex6RedirectOutputStream.printSomething();
        Assertions.assertEquals(SOMETHING, outputStreamCaptor.toString().trim());
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}
