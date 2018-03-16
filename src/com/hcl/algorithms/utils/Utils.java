/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hcl.algorithms.utils;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Angel.Sahagun
 */
public class Utils {
    
    public static int[] createArray(int n, int min, int max) {
        Random rmd = new Random();
        int[] array = new int[n];
        int bound = max - min + 1;

        for (int i = 0; i < array.length; i++) {
            array[i] = rmd.nextInt(bound) + min;
        }

        return array;
    }

    public static void printArray(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    public static void swap(int[] array, int i1, int i2) { // Tempotal = 6 , Espacial = 1 
        int temp = array[i1];
        array[i1] = array[i2];
        array[i2] = temp;  
    }

    public static boolean isSorted(int[] array) { 
        for (int i = 0; i < array.length - 1; i++) { 
            if (array[i] > array[i + 1]) { // N(3)
                return false;
            }
        }
        return true;
    }

    public static int[] partialSortArray(int n) {
        int[] array = new int[n];
        for (int i = 0; i < (int) (n - (n / 10)); i++) {
            array[i] = i;
        }
        for (int i = 0; i < (n / 10); i++) {
            array[(n - (n / 10)) + i] = (n - (n / 10)) - (i * 2);
        }
        return array;
    }

    public static int[] invertedArray(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = (n - i);
        }
        return array;
    }

    public static int[] createSortedArray(int elements) {
        int [] array = new int[elements];
        for (int i = 0; i < elements; i++) {
            array[i] = i;
        }
        return array;
    }
}
