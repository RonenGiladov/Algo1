package Targil1;

import java.util.Scanner;

public class Main {

    public static void main(String args[]) {
        // Main program entry point

        System.out.println("Enter decimal number: ");
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();

        System.out.println("The result in base-15: " + baseFifhteen(num)); // Print result
    }

    // Function to check for digits repeated 3 times or more
    private static boolean hasRepeatedDigits(int num, int arr[]) {

        int tempNum = 0; // Temporary variable to store digit

        if (num <= 0) {
            return false; // Base case: non-positive number has no repeats
        }

        tempNum = num % 10; // Extract last digit
        arr[tempNum]++; // Increment count of the digit in the array

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 3) {
                return true; // Found a digit with count exceeding 2
            }
        }

        return hasRepeatedDigits(num / 10, arr); // Recursive call for remaining digits
    }

    // Function to convert decimal number to base-15
    public static String baseFifhteen(int num) {
        int arr[] = new int[10]; // Array to store digit counts (0-9)

        if (hasRepeatedDigits(num, arr)) {
            return "-1"; // Early exit if digits are repeated
        }

        if (num <= 0) {
            return ""; // Base case: non-positive number is empty string
        }

        switch (num % 15) {
            case 10:
                return String.valueOf(baseFifhteen(num / 15)) + "A";
            case 11:
                return String.valueOf(baseFifhteen(num / 15)) + "B";
            case 12:
                return String.valueOf(baseFifhteen(num / 15)) + "C";
            case 13:
                return String.valueOf(baseFifhteen(num / 15)) + "D";
            case 14:
                return String.valueOf(baseFifhteen(num / 15)) + "E";
        }
        // Handle digits 0-9
        return String.valueOf(baseFifhteen(num / 15)) + "" +
                String.valueOf(num % 15);
    }
}
