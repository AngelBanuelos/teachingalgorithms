/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hcl.algorithms.main;

import com.hcl.algorithms.sort.InsertionSort;
import com.hcl.algorithms.utils.Utils;

/**
 *
 * @author Angel.Sahagun
 */
public class InsertionDemo {

    public static void main(String[] args) {
        int[] array = Utils.createArray(100_000, 0, 100);//{ 5, 2, -1, 0, 3, -2, 2};
        InsertionSort insertion = new InsertionSort();
        array = insertion.sort(array);
        if (Utils.isSorted(array)) {
            System.out.println("Is Sorted!");
        }
        insertion.printAnalysis();
    }
}
