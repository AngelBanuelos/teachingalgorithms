/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hcl.algorithms.main;

import com.hcl.algorithms.sort.SelectionSort;
import com.hcl.algorithms.utils.Utils;

/**
 *
 * @author Angel.Sahagun
 */
public class SelectionDemo {
    
    public static void main(String[] args) {
        
        SelectionSort selection = new SelectionSort();
        int[] array = Utils.createArray(100_000, 0, 100);
        selection.sort(array);
        if(Utils.isSorted(array)){
            System.out.println("it is sorted! ");
        }
        selection.printAnalysis();
    }
    
}
