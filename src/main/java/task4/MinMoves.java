package task4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinMoves {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java MinMovesToEqualizeArray <input_file>");
            System.exit(1);
        }
        String inputFile = args[0];
        List<Integer> nums = readNumbersFromFile(inputFile);
        if (nums.isEmpty()) {
            System.out.println("0");
            return;
        }
        int minMoves = minMovesToEqualizeArray(nums);
        System.out.println(minMoves);
    }

    private static List<Integer> readNumbersFromFile(String inputFile) {
        List<Integer> nums = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                nums.add(Integer.parseInt(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return nums;
    }

    private static int minMovesToEqualizeArray(List<Integer> nums) {
        Collections.sort(nums);
        int median = nums.get(nums.size() / 2);
        int moves = 0;
        for (int num : nums) {
            moves += Math.abs(num - median);
        }
        return moves;
    }
}