package assignments.SoftCon2020_Assignment_4;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class BackendTechnicianTest {

    @Test
    void fix_backend() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // After this all System.out.println() statements will come to outContent stream.

        // So, you can normally call,
        BackendTechnician bt = new BackendTechnician("K.", "L", 29);
        int ID = bt.getID();
        bt.fix_backend(ID);

        String expectedOutput  = "fixed!\n";

        // Do the actual assertion.
        assertEquals(expectedOutput, outContent.toString());
    }
}