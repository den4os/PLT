package task4;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testutils.TempFileCreateUtil;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class MinMovesTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(System.out);
    }

    @Test
    public void testMinMovesToEqualizeArray() {
        String inputContent = "1\n10\n2\n9";
        String inputFile = TempFileCreateUtil.createTempFileWithContent(inputContent);
        TempFileCreateUtil.setConsoleOutput("16");

        MinMoves.main(new String[]{inputFile});
        String actualOutput = outContent.toString().trim();

        String expectedOutput = TempFileCreateUtil.getConsoleOutput().trim();
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testMinMovesToEqualizeArraySingleElement() {
        String inputContent = "10\n10\n10";
        String inputFile = TempFileCreateUtil.createTempFileWithContent(inputContent);
        TempFileCreateUtil.setConsoleOutput("0");

        MinMoves.main(new String[]{inputFile});
        String actualOutput = outContent.toString().trim();

        String expectedOutput = TempFileCreateUtil.getConsoleOutput().trim();
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testMinMovesToEqualizeArrayEmptyList() {
        String inputContent = "";
        String inputFile = TempFileCreateUtil.createTempFileWithContent(inputContent);
        TempFileCreateUtil.setConsoleOutput("0");

        MinMoves.main(new String[]{inputFile});
        String actualOutput = outContent.toString().trim();

        String expectedOutput = TempFileCreateUtil.getConsoleOutput().trim();
        assertEquals(expectedOutput, actualOutput);
    }
}