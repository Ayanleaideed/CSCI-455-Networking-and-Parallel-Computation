// File: RandomNumber.java
// Author: Ayanle A
// Date: 01/24/2025
// Assignment: Assignment 1
// Description: This class implements two tasks:
// Task 1: Generates random numbers, calculates frequencies, and finds median
// Task 2: Sorts frequency pairs and writes to a new file

package Assignments.Assignment1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class RandomNumber {
    /**
     * Task 1: Generates 1000 random numbers and processes them
     * a) Generates random integers between 1-100
     * b) Calculates frequencies
     * c) Writes to output1.txt
     * d) Prints median
     * e) Uses fixed seed for reproducibility
     */
    public static void task1() {
        try {
            // Set seed for reproducible results
            Random rand = new Random(12345);
            int[] numbers = new int[1000];

            // Generate 1000 random numbers
            for (int i = 0; i < 1000; i++) {
                numbers[i] = rand.nextInt(100) + 1;
            }

            // Calculate frequencies using TreeMap for automatic sorting
            Map<Integer, Integer> frequencies = new TreeMap<>();
            for (int num : numbers) {
                frequencies.put(num, frequencies.getOrDefault(num, 0) + 1);
            }

            // Write to output1.txt
            try (PrintWriter writer = new PrintWriter("output1.txt")) {
                for (Map.Entry<Integer, Integer> entry : frequencies.entrySet()) {
                    writer.println(entry.getKey() + " " + entry.getValue());
                }
            }

            // Calculate and print median
            Arrays.sort(numbers);
            double median;
            if (numbers.length % 2 == 0) {
                median = (numbers[numbers.length / 2 - 1] + numbers[numbers.length / 2]) / 2.0;
            } else {
                median = numbers[numbers.length / 2];
            }
            System.out.println("Median: " + median);

        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    /**
     * Task 2: Reads frequency pairs and sorts them by frequency
     * a) Reads from output1.txt
     * b) Sorts pairs by frequency in descending order
     * c) Writes results to output2.txt
     */
    public static void task2() {
        try {
            // Read from output1.txt
            Map<Integer, Integer> frequencies = new HashMap<>();
            try (BufferedReader reader = new BufferedReader(new FileReader("output1.txt"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(" ");
                    frequencies.put(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
                }
            }

            // Sort by frequency in descending order
            List<Map.Entry<Integer, Integer>> sortedFreq = new ArrayList<>(frequencies.entrySet());
            sortedFreq.sort((a, b) -> b.getValue().compareTo(a.getValue()));

            // Write to output2.txt
            try (PrintWriter writer = new PrintWriter("output2.txt")) {
                for (Map.Entry<Integer, Integer> entry : sortedFreq) {
                    writer.println(entry.getKey() + " " + entry.getValue());
                }
            }

        } catch (IOException e) {
            System.err.println("Error processing files: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        task1();
        task2();
    }
}
