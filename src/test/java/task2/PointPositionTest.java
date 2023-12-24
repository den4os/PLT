package task2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testutils.TempFileCreateUtil;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class PointPositionTest {
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
    public void testPointOutsideCircle() {
        String circleFileContent = "0 0\n5";
        String pointsFileContent = "1 6";
        String circleFilePath = TempFileCreateUtil.createTempFileWithContent(circleFileContent);
        String pointsFilePath = TempFileCreateUtil.createTempFileWithContent(pointsFileContent);
        TempFileCreateUtil.setConsoleOutput("2");

        PointPosition.main(new String[]{circleFilePath, pointsFilePath});
        String actualOutput = outContent.toString().trim();

        assertEquals(TempFileCreateUtil.getConsoleOutput().trim(), actualOutput);
    }

    @Test
    public void testPointOnCircle() {
        String circleFileContent = "0 0\n5";
        String pointsFileContent = "0 5";
        String circleFilePath = TempFileCreateUtil.createTempFileWithContent(circleFileContent);
        String pointsFilePath = TempFileCreateUtil.createTempFileWithContent(pointsFileContent);
        TempFileCreateUtil.setConsoleOutput("0");

        PointPosition.main(new String[]{circleFilePath, pointsFilePath});
        String actualOutput = outContent.toString().trim();

        assertEquals(TempFileCreateUtil.getConsoleOutput().trim(), actualOutput);
    }

    @Test
    public void testPointInsideCircle() {
        String circleFileContent = "0 0\n5";
        String pointsFileContent = "1 1";
        String circleFilePath = TempFileCreateUtil.createTempFileWithContent(circleFileContent);
        String pointsFilePath = TempFileCreateUtil.createTempFileWithContent(pointsFileContent);
        TempFileCreateUtil.setConsoleOutput("1");

        PointPosition.main(new String[]{circleFilePath, pointsFilePath});
        String actualOutput = outContent.toString().trim();

        assertEquals(TempFileCreateUtil.getConsoleOutput().trim(), actualOutput);
    }
}