package Part1;

// 
// Title: Main Class
// Author: Ceyda Kuşçuoğlu
// Description: This class runs the main method and tests the code
//
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        // Creating array for integer variables
        Integer[] randomArray;

        // Read the input file name from the command line argument
        // Read the input file and parse the integers
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader("integers.txt")));) {
            int lengthOfArray = scanner.nextInt();
            randomArray = new Integer[lengthOfArray];
            for (int i = 0; i < lengthOfArray; i++) {
                randomArray[i] = scanner.nextInt();
            }
        }
        // Copying the original array for using it later
        Integer[] originalArr = new Integer[randomArray.length];
        for (int i = 0; i < randomArray.length; i++) {
            originalArr[i] = randomArray[i];
        }
        System.out.println("Integers are reading from the integers.txt file, the array is:");
        for (Integer i : randomArray) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("The array has been sorted in increasing order by using the insertion sort algorithm:");
        // Sort using Insertion Sort by ascending order
        Insertion.sort(randomArray);

        System.out.println("Step 1 has been completed.");
        System.out.println();
        System.out.println(
                "The array of integers that has been sorted in decreasing order by using the insertion sort algorithm:");
        // Sort using Insertion Sort by descending order
        Insertion.ModifiedSort(randomArray);

        System.out.println("Step 2 has been completed.");
        System.out.println();
        // Creating array for double variables
        Double[] randomArray2;

        // Read the input file name from the command line argument
        // Read the input file and parse the doubles
        System.out.println("Doubles are reading from the doubles.txt file, the array is:");
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader("doubles.txt")));) {
            int lengthOfArray = scanner.nextInt();
            randomArray2 = new Double[lengthOfArray];
            for (int i = 0; i < lengthOfArray; i++) {
                randomArray2[i] = scanner.nextDouble();
            }
        }
        for (Double d : randomArray2) {
            System.out.print(d + " ");
        }
        System.out.println();
        System.out.println(
                "The array of double values has been sorted in increasing order by using the insertion sort algorithm:");
        // Sort using Insertion Sort by ascending order
        Insertion.sort(randomArray2);

        System.out.println("Step 3 has been completed.");
        System.out.println();
        System.out.println("The original array is:");
        for (Integer i : originalArr) {
            System.out.print(i + " ");
        }
        System.out.println();
        // Sort using Merge Sort by descending order
        Merge.sort(randomArray);
        System.out.println(
                "The array of integer values has been sorted in descending order by using the merge sort algorithm is:");
        for (Integer i : randomArray) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("Step 4 has been completed.");
        System.out.println();

        Student[] students = new Student[10];

        // Read student data from file
        try {
            int i = 0;
            BufferedReader reader = new BufferedReader(new FileReader("student.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String name = parts[0];
                long id = Long.parseLong(parts[1].trim());
                int semesterNo = Integer.parseInt(parts[2].trim());
                students[i] = new Student(name, id, semesterNo);
                i++;
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            return;
        }
        Quick.sort(students);
        System.out.println();
        for (Student student : students) {
            System.out.println(student.getId() + ": " + student.getName() + " " +
                    student.getSemesterNo());
        }
        System.out.println();
        System.out.println("Step 6 has been completed.");
        System.out.println();

        Quick.ModifiedSort(students);

        for (Student student : students) {
            System.out.println(student.getId() + ": " + student.getName() + " " +
                    student.getSemesterNo());
        }
        System.out.println();
        System.out.println("Step 7 has been completed.");

    }
}
