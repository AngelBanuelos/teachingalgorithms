/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hcl.algorithms.sort;

/**
 *
 * @author Angel.Sahagun
 */
public class CountingSort implements Sort {

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
        return CountingSort.class.getName();
    }

    @Override
    public void printAnalysis() {
        System.out.println(getSortingName() + ", " + getSwapCount() + ", "
                + getComparisonCount() + ", " + getExecutionTime());
    }

    @Override
    public void reset() {
        comparisonCount = 0L;
        swapCount = 0L;
        executionTime = 0L;
    }

    @Override
    public int[] sort(int[] array) {
        long startTime = System.currentTimeMillis();
        final int N = array.length;
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < N; i++) {
            if (min > array[i]) {
                min = array[i];
            }
            if (max < array[i]) {
                max = array[i];
            }
        }
        int maxArrayLength = max - min + 1;
        int[] count = new int[maxArrayLength];
        for (int i = N - 1; i >= 0; i--) {
            count[array[i] - min]++;
        }
        int start = 0;
        for (int i = min; i <= max; i++) {
            if (count[i - min] == 0) {
                continue;
            }
            for (int j = 0; j < count[i - min]; j++) {
                array[start++] = i ;
            }
        }
        long endTime = System.currentTimeMillis();
        executionTime = endTime - startTime;
        return array;
    }
}
