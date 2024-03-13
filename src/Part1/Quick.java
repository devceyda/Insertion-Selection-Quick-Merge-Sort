package Part1;

// 
// Title: Quick Sort Algorithm Class
// Author: Ceyda Kuşçuoğlu

// Description: This class runs the quick sort algorithm
//
public class Quick {

    private static boolean ModifiedLess(Comparable v, Comparable w)
    //
    // Summary: This method compares two taken parameter.
    // Precondition: Takes two object that needs to be paramatized as parameter.
    // Postcondition: Checked if first parameter is equal or bigger than first
    // parameter or not ,if bigger or equal than returned true
    //
    {
        return v.compareTo(w) > 0;
    }

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
    {
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
    {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i - 1]))
                return false;
        return true;
    }

    private static int ModifiedPartition(Comparable[] a, int lo, int hi)
    //
    // Summary: Partitions the given array into three parts, where the first part
    // has elements less than or equal to the pivot element, the second part
    // contains the pivot element, and the third part has elements greater than the
    // pivot element.
    // Precondition: Takes an array and integer lo and hi
    // Postcondition: The array a[lo..hi] is partitioned such that a[lo..j-1] <=
    // a[j] <= a[j+1..hi], where j is the index of the pivot element. The method
    // returns the index of the pivot element j.
    //
    { // Partition into a[lo..i-1], a[i],
      // a[i+1..hi].
        int i = lo, j = hi + 1; // left and right scan indices
        Comparable v = a[lo]; // partitioning item
        while (true) { // Scan right, scan left, check for scan complete, and exchange.
            while (ModifiedLess(a[++i], v))
                if (i == hi)
                    break;
            while (ModifiedLess(v, a[--j]))
                if (j == lo)
                    break;
            if (i >= j)
                break;
            exch(a, i, j);
        }
        exch(a, lo, j); // Put v = a[j] into position
        return j; // with a[lo..j-1] <= a[j] <= a[j+1..hi].
    }

    private static int partition(Comparable[] a, int lo, int hi)
    //
    // Summary: This method partitions an array a into three parts: elements less
    // than the partitioning item, the partitioning item itself, and elements
    // greater than the partitioning item.
    // Precondition: Takes an array and integer lo and hi
    // Postcondition: The array a[lo..hi] is partitioned into three parts:
    // a[lo..i-1], a[i], and a[i+1..hi] where all elements in a[lo..i-1] are less
    // than or equal to a[i], and all elements in a[i+1..hi] are greater than or
    // equal to a[i]. The index i is returned.
    //
    { // Partition into a[lo..i-1], a[i], a[i+1..hi].
        int i = lo, j = hi + 1; // left and right scan indices
        Comparable v = a[lo]; // partitioning item
        while (true) { // Scan right, scan left, check for scan complete, and exchange.
            while (less(a[++i], v))
                if (i == hi)
                    break;
            while (less(v, a[--j]))
                if (j == lo)
                    break;
            if (i >= j)
                break;
            exch(a, i, j);
        }
        exch(a, lo, j); // Put v = a[j] into position
        return j; // with a[lo..j-1] <= a[j] <= a[j+1..hi].
    }

    public static void ModifiedSort(Comparable[] a)
    //
    // Summary: Sorts the taken array using the quicksort algorithm
    // with a modified partitioning method.
    // Precondition: Takes an array
    // Postcondition: The array "a" sorted in descending order.
    //
    {
        StdRandom.shuffle(a); // Eliminate dependence on input.
        ModifiedSort(a, 0, a.length - 1);
    }

    private static void ModifiedSort(Comparable[] a, int lo, int hi)
    //
    // Summary: Partitions the subarray a[lo..hi] using a modified version of the
    // quicksort algorithm.
    // Precondition: Takes an array, integer lo and hi
    // Postcondition: The subarray a[lo..hi] is partitioned in-place into three
    // parts: a[lo..i-1], a[i], and a[i+1..hi],
    // where all elements in a[lo..i-1] are less than or equal to a[i], which is
    // less than or equal to all elements in a[i+1..hi].
    // The index i is returned.
    //
    {
        if (hi <= lo)
            return;
        int j = ModifiedPartition(a, lo, hi); // Partition.
        ModifiedSort(a, lo, j - 1); // Sort left part a[lo .. j-1].
        ModifiedSort(a, j + 1, hi); // Sort right part a[j+1 .. hi].
    }

    public static void sort(Comparable[] a)
    //
    // Summary: Sorts the taken array using the quicksort algorithm
    //// with a modified partitioning method.
    // Precondition: Takes an array
    // Postcondition: The array "a" sorted in ascending order.
    //
    {
        StdRandom.shuffle(a); // Eliminate dependence on input.
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi)
    //
    // Summary: Partitions the subarray a[lo..hi] using the quicksort algorithm.
    // Precondition: Takes an array, integer lo and hi
    // Postcondition: The subarray a[lo..hi] is partitioned in-place into three
    // parts: a[lo..i-1], a[i], and a[i+1..hi],
    // where all elements in a[lo..i-1] are less than or equal to a[i], which is
    // less than or equal to all elements in a[i+1..hi].
    // The index i is returned.
    //
    {
        if (hi <= lo)
            return;
        int j = partition(a, lo, hi); // Partition.
        sort(a, lo, j - 1); // Sort left part a[lo .. j-1].
        sort(a, j + 1, hi); // Sort right part a[j+1 .. hi].
    }
}
