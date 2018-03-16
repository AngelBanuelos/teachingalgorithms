/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hcl.algorithms.search;

/**
 *
 * @author Angel.Sahagun
 */
public class BinarySearch implements Search {

    @Override
    public int search(int[] array, int elementTofind) {
        int end = array.length;
        int start = 0;
        return bSearch(array, elementTofind, start, end -1);
    }

    private int bSearch(int array[], int elementToFind, int start, int end) {
        int half = (end - start) / 2;
        if (half < 0) {
            // Does not exists
            return -1;
        }
        int newStart = half + start;
        int num = array[newStart];
        if (num == elementToFind) {
            return newStart;
        }
        if (half == 0) {
            return -1;
        }
        if (num < elementToFind) {
            // Find in the right
            return bSearch(array, elementToFind, newStart + 1, end);
        } else {
            // Find in the left
            return bSearch(array, elementToFind, start, newStart - 1);
        }
    }

}
