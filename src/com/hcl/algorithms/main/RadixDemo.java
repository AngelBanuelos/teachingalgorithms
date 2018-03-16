/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hcl.algorithms.main;

import com.hcl.algorithms.performance.DataBank;
import com.hcl.algorithms.sort.HeapSort;
import com.hcl.algorithms.sort.RadixSort;
import com.hcl.algorithms.utils.Utils;
import java.util.HashMap;

/**
 *
 * @author Angel.Sahagun
 */
public class RadixDemo {

    public static void main(String[] args) {
        
        RadixSort radix = new RadixSort();
        int[] array = Utils.createArray(10_000_000, 0, 10);//{54, 100, 2, 0, 9, 8, 4, 2, 321, 101};
        radix.sort(array);
        if (Utils.isSorted(array)) {
            System.out.println("its Working");
        } else {
            System.err.println("it NOT Working");
        }
        radix.printAnalysis();
        
    }

}
