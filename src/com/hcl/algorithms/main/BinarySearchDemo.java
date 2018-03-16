package com.hcl.algorithms.main;

import com.hcl.algorithms.search.BinarySearch;
import com.hcl.algorithms.search.ExhaustiveSearch;
import com.hcl.algorithms.sort.CountingSort;
import com.hcl.algorithms.utils.Utils;

/**
 *
 * @author Angel.Sahagun
 */
public class BinarySearchDemo {

    public static void main(String[] args) {
        int[] array = Utils.createArray(100_000_000, -10_000_000, 10_000_000);
        CountingSort countingSort = new CountingSort();
        countingSort.sort(array);
        BinarySearch binarySearch = new BinarySearch();
        long start = System.currentTimeMillis();
        int p;
        if ((p = binarySearch.search(array, 5)) != -1) {
            System.out.println("Found! in position: " + p);
        }
        long end = System.currentTimeMillis();
        System.out.println(" binarySearch " + (end - start));
        ExhaustiveSearch exhaustiveSearch = new ExhaustiveSearch();
        start = System.currentTimeMillis();
        if ((p = exhaustiveSearch.search(array, 5)) != -1) {
            System.out.println("Found! in position: " + p);
        }
        end = System.currentTimeMillis();
        System.out.println(" exhaustiveSearch " + (end - start));
    }
}
