package task1;

import java.util.Arrays;

public class CircularArray {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Please provide two arguments: n and m");
            return;
        }

        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);

        if (n <= 0 || m <= 0) {
            System.out.println("Arguments n and m must be positive numbers");
            return;
        }

        int[] circularArray = new int[n];
        Arrays.setAll(circularArray, i -> ++i);

        int currentIndex = 0;
        StringBuilder path = new StringBuilder();

        do {
            path.append(circularArray[currentIndex]);
            currentIndex = (currentIndex + m - 1) % n;
        } while (currentIndex != 0);

        System.out.println(path.toString().trim());
    }
}
