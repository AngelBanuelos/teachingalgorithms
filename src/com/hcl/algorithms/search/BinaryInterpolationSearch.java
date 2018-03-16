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
public class BinaryInterpolationSearch implements Search {

    @Override
    public int search(int[] array, int elementTofind) {
        int end = array.length;
        int start = 0;
        int partition = (end - start) / 2;
        return bISearch(array, elementTofind, start, partition, end - 1);
    }

    private int bISearch(int array[], int elementToFind, int start, int partition, int end) {
        int aux = partition;
        int left = array[start], rigth = array[end];
        if (partition < 0 || partition > end || (rigth - left) == 0) {
            // Does not exists
            return -1;
        }
        partition = ((end - start) * (elementToFind - left) / (rigth - left)) + start;
        if (partition < 0 || partition > end) {
            // Does not exists
            return -1;
        }
        int num = array[partition];
        if (num == elementToFind) {
            return partition;
        }
        if (num < elementToFind) {
            // Find in the right
            return bISearch(array, elementToFind, aux, partition, end);
        } else {
            // Find in the left
            return bISearch(array, elementToFind, start, partition, aux);
        }
    }

}
