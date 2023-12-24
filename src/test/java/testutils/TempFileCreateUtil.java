package testutils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TempFileCreateUtil {
    private static final StringBuilder consoleOutput = new StringBuilder();

    public static String createTempFileWithContent(String content) {
        try {
            File tempFile = File.createTempFile("temp", null);
            tempFile.deleteOnExit();
            try (FileWriter writer = new FileWriter(tempFile)) {
                writer.write(content);
            }
            return tempFile.getAbsolutePath();
        } catch (IOException e) {
            throw new RuntimeException("Error creating temporary file", e);
        }
    }

    public static void setConsoleOutput(String output) {
        consoleOutput.setLength(0);
        consoleOutput.append(output);
    }

    public static String getConsoleOutput() {
        return consoleOutput.toString();
    }
}
