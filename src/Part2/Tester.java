package Part2;
// 
// Title: Main Class
// Author: Ceyda Kuşçuoğlu

// Description: This class runs the main method and tests the code by taking input from the user
//
import java.util.Random;
import java.util.Scanner;
import java.util.*;

public class Tester {

    private static Integer[] generateRandomArray(int size, Random rand)
    //
    // Summary: Genereates a random array
    // Precondition: takes integer size and Random object rand
    // Postcondition: The array is set
    //
    {
        Integer[] arr = new Integer[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt();
        }
        return arr;
    }

    private static Integer[] AscendingArray(Integer[] arr)
    //
    // Summary: Sorts the taken array by ascending order
    // Precondition: takes an Integer array
    // Postcondition: The array is sorted by ascending order
    //
    {
        Arrays.sort(arr);
        return arr;
    }

    private static Integer[] DescendingArray(Integer[] arr)
    //
    // Summary: Sorts the taken array by descending order
    // Precondition: takes an Integer array
    // Postcondition: The array is sorted by descending order
    //
    {
        Arrays.sort(arr);
        // reverse array
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
        return arr;
    }

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

        if (sortAlgorithm.equalsIgnoreCase("Selection")) {
            Selection.sort(arr);
        } else if (sortAlgorithm.equalsIgnoreCase("Insertion")) {
            Insertion.sort(arr);
        } else if (sortAlgorithm.equalsIgnoreCase("Merge")) {
            Merge.sort(arr);
        } else if (sortAlgorithm.equalsIgnoreCase("Quick")) {
            Quick.sort(arr);
        } else if (sortAlgorithm.equalsIgnoreCase("noSort")) {

        }

        // finds the mnAbsDiff and pair of the array
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

        System.out.println(
                minAbsDiff + " [" + Math.min(arr[minA], arr[minB]) + " " + Math.max(arr[minA], arr[minB]) + "]");

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long startTime, endTime, elapsedTime1, elapsedTime2, elapsedTime3;
        // variables for calculate methods ruuning time
        String[] sortOptions = { "Selection", "Insertion", "Merge", "Quick", "NoSort" }; // these are sort algorithms
        // for tests
        int[] sizes = { 250, 1000, 4000, 16000, 64000 }; // these are size for arrays
        System.out.println("Enter a seed to create random generated values :");
        int seed = sc.nextInt();
        // creating a object from random class
        Random rand = new Random(seed);
        System.out.println("Seed : " + seed);
        for (int i = 0; i < sizes.length; i++) {
            // generating a random array with sizes
            Integer[] randomArr = generateRandomArray(sizes[i], rand);
            System.out.println("Input size: " + sizes[i]);
            System.out.println();
            for (int j = 0; j < sortOptions.length; j++) {
                System.out.println("Sort option: " + sortOptions[j]);
                System.out.println("Random");
                startTime = System.currentTimeMillis();
                sortAndPrintSmallestDiff(randomArr, sortOptions[j]);
                endTime = System.currentTimeMillis();
                elapsedTime1 = endTime - startTime;
                startTime = System.currentTimeMillis();
                sortAndPrintSmallestDiff(randomArr, sortOptions[j]);
                endTime = System.currentTimeMillis();
                elapsedTime2 = endTime - startTime;
                startTime = System.currentTimeMillis();
                sortAndPrintSmallestDiff(randomArr, sortOptions[j]);
                endTime = System.currentTimeMillis();
                elapsedTime3 = endTime - startTime;
                // calculating the avarage time for method
                // System.out.println("Time For Random Array:" + (double) (elapsedTime1 +
                // elapsedTime2 + elapsedTime3) / 3.0);

                System.out.println("Ascending");
                // startTime = System.currentTimeMillis();
                sortAndPrintSmallestDiff(AscendingArray(randomArr), sortOptions[j]);
                // endTime = System.currentTimeMillis();
                // elapsedTime1 = endTime - startTime;
                // startTime = System.currentTimeMillis();
                sortAndPrintSmallestDiff(AscendingArray(randomArr), sortOptions[j]);
                // endTime = System.currentTimeMillis();
                // elapsedTime2 = endTime - startTime;
                // startTime = System.currentTimeMillis();
                sortAndPrintSmallestDiff(AscendingArray(randomArr), sortOptions[j]);
                // endTime = System.currentTimeMillis();
                // elapsedTime3 = endTime - startTime;
                // System.out.println(
                // "Time For Ascending Array:" + (double) (elapsedTime1 + elapsedTime2 +
                // elapsedTime3) / 3.0);

                System.out.println("Descending");
                // startTime = System.currentTimeMillis();
                sortAndPrintSmallestDiff(DescendingArray(randomArr), sortOptions[j]);
                // endTime = System.currentTimeMillis();
                // elapsedTime1 = endTime - startTime;
                // startTime = System.currentTimeMillis();
                sortAndPrintSmallestDiff(DescendingArray(randomArr), sortOptions[j]);
                // endTime = System.currentTimeMillis();
                // elapsedTime2 = endTime - startTime;
                // startTime = System.currentTimeMillis();
                sortAndPrintSmallestDiff(DescendingArray(randomArr), sortOptions[j]);
                // endTime = System.currentTimeMillis();
                // elapsedTime3 = endTime - startTime;
                // System.out.println(
                // "Time For Descending Array:" + (double) (elapsedTime1 + elapsedTime2 +
                // elapsedTime3) / 3.0);
                System.out.println();
            }
        }

    }
}