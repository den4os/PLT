package task1;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class CircularArrayTest {
    @Test
    public void testCircularArray() {
        assertEquals("13", performCircularArray(4, 3));
        assertEquals("14253", performCircularArray(5, 4));
    }

    private String performCircularArray(int n, int m) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        CircularArray.main(new String[]{String.valueOf(n), String.valueOf(m)});

        return outputStream.toString().trim();
    }
}