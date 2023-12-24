package test2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PointPosition {
    public static final int MAX_NUMBER_OF_POINTS = 100;
    public static final int MIN_NUMBER_OF_POINTS = 1;

    public static void main(String[] args) {

        if (args.length != 2) {
            System.out.println("Usage: java PointPosition <circle_file> <points_file>");
            return;
        }

        int numberOfPoints = 0;

        try (BufferedReader circleReader = new BufferedReader(new FileReader(args[0]));
             BufferedReader pointsReader = new BufferedReader(new FileReader(args[1]))) {

            String[] coordinateData = circleReader.readLine().split(" ");
            String radiusData = circleReader.readLine();

            float centerX = Float.parseFloat(coordinateData[0]);
            float centerY = Float.parseFloat(coordinateData[1]);
            float radius = Float.parseFloat(radiusData);

            String pointLine;
            while ((pointLine = pointsReader.readLine()) != null) {
                if (numberOfPoints >= MAX_NUMBER_OF_POINTS) {
                    System.out.println("Error: Number of points should be between 1 and 100");
                    break;
                }
                numberOfPoints++;
                String[] pointData = pointLine.split(" ");
                float pointX = Float.parseFloat(pointData[0]);
                float pointY = Float.parseFloat(pointData[1]);

                double distance = Math.sqrt(Math.pow(pointX - centerX, 2) + Math.pow(pointY - centerY, 2));

                if (distance == radius) {
                    System.out.println("0");
                } else if (distance < radius) {
                    System.out.println("1");
                } else {
                    System.out.println("2");
                }
            }
            if (numberOfPoints < MIN_NUMBER_OF_POINTS) {
                System.out.println("Error: Number of points should be between 1 and 100");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
