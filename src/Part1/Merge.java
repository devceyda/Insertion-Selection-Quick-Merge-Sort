package Part1;

// 
// Title: Merge Sort Algorithm Class
// Author: Ceyda Kuşçuoğlu
// Description: This class runs the merge sort algorithm
//
public class Merge {

    private static boolean less(Comparable v, Comparable w)
    //
    // Summary:This method compares two taken parameter.
    // Precondition: Takes two object that needs to be paramatized as parameter.
    // Postcondition: Checked if second parameter is equal or bigger than first
    // parameter or not ,if bigger or equal than returned true
    //
    {
        return v.compareTo(w) > 0;
    }

    private static void show(Comparable[] a)
    //
    // Summary: This method prints the taken array
    // Precondition: Takes an array
    // Postcondition: Printed the taken array
    //
    {
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    private static Comparable[] aux; // auxiliary array for merges

    public static void sort(Comparable[] a)
    //
    // Summary: This method sorts the array in ascending order
    // Precondition: Takes an array
    // Postcondition: The taken array is sorted in ascending order
    //
    {
        aux = new Comparable[a.length]; // Allocate space just once.
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi)
    //
    // Summary: This method implements the merge sort algorithm to sort a subarray
    // a[lo..hi].
    // Precondition: Takes an array ,intger lo and hi
    // Postcondition: The subarray a[lo..hi] is sorted in ascending order.
    //
    { // Sort a[lo..hi].
        if (hi <= lo)
            return;
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid); // Sort left half.
        sort(a, mid + 1, hi); // Sort right half.
        merge(a, lo, mid, hi); // Merge results

    }

    public static void merge(Comparable[] a, int lo, int mid, int hi)
    //
    // Summary: Merges two sorted subarrays of the input array a: a[lo..mid] and
    // a[mid+1..hi] into a single sorted subarray a[lo..hi].
    // Preconditions: Takes an array ,intger lo,mid and hi
    // Postconditions: The input array a is now sorted in non-decreasing order from
    // index lo to index hi.
    //
    { // Merge a[lo..mid] with a[mid+1..hi].
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) // Copy a[lo..hi] to aux[lo..hi].
            aux[k] = a[k];
        for (int k = lo; k <= hi; k++) // Merge back to a[lo..hi].
            if (i > mid)
                a[k] = aux[j++];
            else if (j > hi)
                a[k] = aux[i++];
            else if (less(aux[j], aux[i]))
                a[k] = aux[j++];
            else
                a[k] = aux[i++];
    }

}
