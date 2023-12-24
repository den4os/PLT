package task3;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;

public class ReportGenerator {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            ObjectNode testsNode = (ObjectNode) objectMapper.readTree(new File(args[0]));
            JsonNode valuesNode = objectMapper.readTree(new File(args[1]));
            generateReport(testsNode, valuesNode);
            ObjectWriter writer = objectMapper.writerWithDefaultPrettyPrinter();
            writer.writeValue(new File("report.json"), testsNode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void generateReport(ObjectNode testsNode, JsonNode valuesNode) {
        for (JsonNode test : testsNode.get("tests")) {
            fillTestValues((ObjectNode) test, valuesNode);
        }
    }

    private static void fillTestValues(ObjectNode test, JsonNode valuesNode) {
        if (test.has("values")) {
            for (JsonNode value : test.get("values")) {
                fillTestValues((ObjectNode) value, valuesNode);
            }
        }

        int testId = test.get("id").asInt();
        for (JsonNode value : valuesNode.get("values")) {
            int valueId = value.get("id").asInt();
            if (valueId == testId) {
                test.put("value", value.get("value").asText());
                break;
            }
        }
    }
}