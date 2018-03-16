/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hcl.algorithms.main;

import com.hcl.algorithms.sort.QuickSort;
import com.hcl.algorithms.utils.Utils;

/**
 *
 * @author Angel.Sahagun
 */
public class QuickSortDemo {

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] array =  Utils.createArray(10, 0, 20);//{9, 8, 7, 6, 5, 4, 3, 2, 1, 0};//{1, -1, 0, 5, 3, 5, -9, 10, 0, -5}; //{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};// 
        quickSort.sort(array);
        if(!Utils.isSorted(array)){
            System.err.println("Its not sorted!");
            Utils.printArray(array);
        }
//        Utils.printArray(array);
        

    }
}
