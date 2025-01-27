// File: PalindromeChecker.java
// Author: Ayanle A
// Date: 01/24/2025
// Assignment: Assignment 1
// Description: This class implements a palindrome checker that determines
// if a given integer reads the same backward as forward

package Assignments.Assignment1;

import java.util.Scanner;

public class PalindromeChecker {
    /**
     * Checks if the given integer is a palindrome
     * 
     * @param x the integer to check
     * @return true if x is a palindrome, false otherwise
     * @approach Two pointers approach: Compare characters from both ends moving
     */

    public static boolean isPalindrome(int x) {
        // Negative numbers are not palindromes
        if (x < 0) {
            return false;
        }

        // Convert to string for easy comparison
        String numStr = String.valueOf(x);
        int left = 0;
        int right = numStr.length() - 1; // Index of last character also also can just be -1 for the last index

        // Compare characters from both ends moving inward
        while (left < right) {
            if (numStr.charAt(left) != numStr.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int terms = 3; // Number of times to run the program

        for (int i = 0; i < terms; i++) {
            System.out.print("Enter an integer: ");
            int number = scanner.nextInt();

            long startTime = System.nanoTime();
            boolean result = isPalindrome(number);
            long endTime = System.nanoTime();
            System.out.println(number + " is" + (result ? "" : " not") + " a palindrome.");
            System.out.println("Time taken: " + (endTime - startTime) + " nanoseconds");
            System.out.println();
        }

        scanner.close();
    }
}