/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hcl.algorithms.sort;

import com.hcl.algorithms.utils.Utils;

/**
 *
 * @author Angel.Sahagun
 */
public class HeapSort implements Sort {

    private long swapCount;
    private long comparisonCount;
    private long executionTime;

    @Override
    public long getSwapCount() {
        return swapCount;
    }

    @Override
    public long getComparisonCount() {
        return comparisonCount;
    }

    @Override
    public long getExecutionTime() {
        return executionTime;
    }

    @Override
    public String getSortingName() {
        return HeapSort.class.getCanonicalName();
    }

    @Override
    public void printAnalysis() {
        System.out.println(getSortingName() + ", " + getSwapCount() + ", "
                + getComparisonCount() + ", " + getExecutionTime());
    }

    @Override
    public int[] sort(int[] array) {
        final int N = array.length;
        final long start = System.currentTimeMillis();
        //Step 1 Heap
        for (int i = 1; i < N; i++) {
            int child = i + 1;
            int parent = child / 2;
            comparisonCount++;
            while (parent > 0 && array[child - 1] > array[parent - 1]) {
                comparisonCount++;
                Utils.swap(array, child - 1, parent - 1);
                swapCount++;
                if (child != parent) {
                    child = parent;
                    parent = child / 2;
                }
            }
        }

        //Step 2
        for (int i = N - 1; i > 0; i--) {
            int j = 0;
            swapCount++;
            Utils.swap(array, j, i);
            int leftChild = 1;
            int rightChild = 2;
            while (leftChild < i) {
                int k = j;
                comparisonCount++;
                if (rightChild >= i || array[leftChild] > array[rightChild]) {
                    j = leftChild;
                } else {
                    j = rightChild;
                }
                comparisonCount++;
                if (j < i && array[k] < array[j]) {
                    swapCount++;
                    Utils.swap(array, k, j);
                }
                leftChild = (j + 1) * 2 - 1;
                rightChild = leftChild + 1;
            }
        }
        
        final long end = System.currentTimeMillis();
        executionTime = end - start;
        return array;
    }
    
    @Override
    public void reset() {
        comparisonCount = 0L;
        swapCount = 0L;
        executionTime = 0L;
    }
}
