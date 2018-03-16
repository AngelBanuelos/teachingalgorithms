/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hcl.algorithms.sort;

import com.hcl.algorithms.performance.PerformanceAnalysis;
import com.hcl.algorithms.utils.Utils;

/**
 *
 * @author Angel.Sahagun
 */
public class BubbleSort implements PerformanceAnalysis, Sort {

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
        return BubbleSort.class.getName();
    }

    @Override
    public int[] sort(int[] array) {
        int N = array.length -1;
        boolean swap = false;
        long startTime = System.currentTimeMillis();
        do {
            swap = false;
            for (int i = 0; i < N; i++) {
                comparisonCount++;
                if(array[i] > array[i+1]) {
                    Utils.swap(array, i, i+1);
                    swap = true;
                    swapCount++;
                }
            }
            N--;
        } while(swap);
        long endTime =  System.currentTimeMillis();
        executionTime = endTime - startTime;
        return array;
    }

    @Override
    public void printAnalysis() {
        System.out.println(getSortingName() + ", " + getSwapCount()+ ", " + 
                getComparisonCount() + ", " + getExecutionTime());
    }

    @Override
    public void reset() {
        comparisonCount = 0L;
        swapCount = 0L;
        executionTime = 0L;
    }
    
}
