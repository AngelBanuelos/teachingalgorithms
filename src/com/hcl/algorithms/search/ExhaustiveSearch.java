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
public class ExhaustiveSearch implements Search {

    @Override
    public int search(int[] array, int elementTofind) {
        int positionFound = -1;
        final int N = array.length;
        for (int i = 0; i < N; i++) {
            if(elementTofind == array[i]){
                return i;
            }
        }
        return positionFound;
    }

}
