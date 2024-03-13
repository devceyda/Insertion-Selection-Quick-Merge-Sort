package Part2;
// 
// Title: Main Class
// Author: Ceyda Kuşçuoğlu

// Description: This class runs the main method and tests the code by taking input from the user
//
import java.util.Scanner;

public class Main {

    public static void sortAndPrintSmallestDiff(Integer[] arr, String sortAlgorithm)
    //
    // Summary:Prints the smallest pairwise absolute difference along with the
    // corresponding pair of numbers.
    // The running time complexity is O(n).
    // Precondition: Takes an array and String sortAgorithm
    // Postcondition: Printed the smallest pairwise absolute difference along with
    // the corresponding pair of numbers.
    //
    {
        // starts the timer for calculate this methods run time
        // long startTime = System.currentTimeMillis();
        // sorts the taken array by using the wanted sort algorithm
        if (sortAlgorithm.equalsIgnoreCase("Selection")) {
            Selection.sort(arr);
        } else if (sortAlgorithm.equalsIgnoreCase("Insertion")) {
            Insertion.sort(arr);
        } else if (sortAlgorithm.equalsIgnoreCase("Merge")) {
            Merge.sort(arr);
        } else if (sortAlgorithm.equalsIgnoreCase("Quick")) {
            Quick.sort(arr);
        } else if (sortAlgorithm.equalsIgnoreCase("noSort")) {
            // finds the minDiff and minPair without sorting the algorithm
            int minDiff = Integer.MAX_VALUE;
            int[] minPair = new int[2];
            for (int i = 0; i < arr.length; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    int diff = Math.abs(arr[i] - arr[j]);
                    if (diff < minDiff) {
                        minDiff = diff;
                        minPair[0] = arr[i];
                        minPair[1] = arr[j];
                    } else if (diff == minDiff && arr[i] + arr[j] < minPair[0] + minPair[1]) {
                        minPair[0] = arr[i];
                        minPair[1] = arr[j];
                    }
                }
            }
            System.out.println("ABS:" + minDiff + ", Min=" + minPair[1] + ", Max="
                    + minPair[0]);
            return;
        }
        // finds the mnAbsDiff and pair of the sorted array
        int minAbsDiff = Integer.MAX_VALUE;
        int minSum = Integer.MAX_VALUE;
        int minA = -1;
        int minB = -1;
        for (int i = 0; i < arr.length - 1; i++) {
            int absDiff = Math.abs(arr[i] - arr[i + 1]);
            if (absDiff < minAbsDiff) {
                minAbsDiff = absDiff;
                minSum = arr[i] + arr[i + 1];
                minA = i;
                minB = i + 1;
            } else if (absDiff == minAbsDiff) {
                int sum = arr[i] + arr[i + 1];
                if (sum < minSum) {
                    minSum = sum;
                    minA = i;
                    minB = i + 1;
                }
            }
        }
        // ends the timer
        // long endTime = System.currentTimeMillis();
        System.out.println("ABS:" + minAbsDiff + ", Min=" + Math.min(arr[minA], arr[minB]) + ", Max="
                + Math.max(arr[minA], arr[minB]));
        // calculates the time for this method
        // System.out.println("Time: " + (endTime - startTime) + "ms");
    }
    // takes array and the sort algorithm name from user
    /*
     * public static void main(String[] args) {
     * Scanner sc = new Scanner(System.in);
     * int size = 10;
     * Integer[] arr = new Integer[size];
     * System.out.println("Enter the sort you want to use:");
     * String option = sc.next();
     * System.out.println("Enter array:");
     * for (int i = 0; i < size; i++) {
     * arr[i] = sc.nextInt();
     * }
     * 
     * if (option.equalsIgnoreCase("Selection")) {
     * sortAndPrintSmallestDiff(arr, "Selection");
     * } else if (option.equalsIgnoreCase("Insertion")) {
     * sortAndPrintSmallestDiff(arr, "Insertion");
     * } else if (option.equalsIgnoreCase("Merge")) {
     * sortAndPrintSmallestDiff(arr, "Merge");
     * } else if (option.equalsIgnoreCase("Quick")) {
     * sortAndPrintSmallestDiff(arr, "Quick");
     * } else if (option.equalsIgnoreCase("noSort")) {
     * sortAndPrintSmallestDiff(arr, "noSort");
     * }
     * 
     * }
     */

}