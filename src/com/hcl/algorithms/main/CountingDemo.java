/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hcl.algorithms.main;

import com.hcl.algorithms.sort.CountingSort;
import com.hcl.algorithms.utils.Utils;

/**
 *
 * @author Angel.Sahagun
 */
public class CountingDemo {

    public static void main(String[] args) {
        CountingSort countingSort = new CountingSort();
        for (int i = 0; i < 1; i++) {
            int[] array = Utils.createArray(100_000_000, -10_000_000, 10_000_000);
            countingSort.sort(array);
            if (Utils.isSorted(array)) {
                System.out.println("It's Sorted");
            }else{
                System.err.println("It isn't sorted");
            }
            countingSort.printAnalysis();
        }
    }

}
