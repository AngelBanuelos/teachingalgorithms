/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hcl.algorithms.main;

import com.hcl.algorithms.performance.DataBank;
import com.hcl.algorithms.sort.HeapSort;
import com.hcl.algorithms.utils.Utils;
import java.util.HashMap;


/**
 *
 * @author Angel.Sahagun
 */
public class HeapDemo {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            int[] array = Utils.createArray(100_000_000, 0, 10_000_000);
            HeapSort heap = new HeapSort();
            heap.sort(array);
            if (Utils.isSorted(array)) {
                System.out.println("its Working");
            } else {
                System.err.println("it NOT Working");
            }
            heap.printAnalysis();
        }
    }
}
