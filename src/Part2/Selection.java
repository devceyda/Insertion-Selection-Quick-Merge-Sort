package Part2;

// 
// Title: Selection Sort Algorithm Class
// Author: Ceyda Kuşçuoğlu

// Description: This class runs the selection sort algorithm
//
public class Selection {

    private static boolean less(Comparable v, Comparable w)
    //
    // Summary:This method compares two taken parameter.
    // Precondition: Takes two object that needs to be paramatized as parameter.
    // Postcondition: Checked if second parameter is equal or bigger than first
    // parameter or not ,if bigger or equal than returned true
    //
    {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j)
    //
    // Summary: This method swaps the elements at the specified indices i and j in
    // the given array a.
    // Precondition: Takes an array "a" that is not null,i and j is integer
    // Postcondition: The elements at indices i and j in array a are swapped.
    //
    {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(Comparable[] a)
    //
    // Summary: This method prints the taken array
    // Precondition: Takes an array
    // Postcondition: Printed the taken array
    //
    { // Print the array, on a single line.
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    public static boolean isSorted(Comparable[] a)
    //
    // Summary: This method checks whether the taken array is sorted or not
    // Precondition: Takes an array
    // Postcondition: Checked the taken array and if it is sorted returned true else
    // returned false
    //
    { // Test whether the array entries are in order.
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i - 1]))
                return false;
        return true;
    }

    public static void sort(Comparable[] a)
    //
    // Summary: This method sorts the array in ascending order
    // Precondition: Takes an array
    // Postcondition: The taken array is sorted in ascending order
    //
    { // Sort a[] into increasing order.
        int N = a.length; // array length
        for (int i = 0; i < N; i++) { // Exchange a[i] with smallest entry in a[i+1...N).
            int min = i; // index of minimal entr.
            for (int j = i + 1; j < N; j++)
                if (less(a[j], a[min]))
                    min = j;
            exch(a, i, min);
        }
    }
}

