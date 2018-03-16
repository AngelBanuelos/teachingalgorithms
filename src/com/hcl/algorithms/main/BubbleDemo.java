/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hcl.algorithms.main;

import com.hcl.algorithms.sort.BubbleSort;
import com.hcl.algorithms.utils.Utils;

/**
 *
 * @author Angel.Sahagun
 */
public class BubbleDemo {
    
    public static void main(String[] args) {
        
        int[] array  = Utils.createArray(100_000, 0, 100);
        BubbleSort bubble = new BubbleSort();
        array = bubble.sort(array);
        if(Utils.isSorted(array)){
            System.out.println("Is Sorted!");
        }
        bubble.printAnalysis();
              
    }
    
}
