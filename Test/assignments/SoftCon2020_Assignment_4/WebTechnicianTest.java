package assignments.SoftCon2020_Assignment_4;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class WebTechnicianTest {

    @Test
    void fix_website() throws InterruptedException {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // After this all System.out.println() statements will come to outContent stream.

        // So, you can normally call,
        WebTechnician wt = new WebTechnician("K.", "L", 29);
        int ID = wt.getID();
        wt.fix_website();

        String expectedOutput  = "reparations complete\n";

        // Do the actual assertion.
        assertEquals(expectedOutput, outContent.toString());
    }
}