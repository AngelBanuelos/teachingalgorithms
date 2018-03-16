/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hcl.algorithms.sort;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;

/**
 *
 * @author Angel.Sahagun
 */
public class RadixSort implements Sort {

    private long swapCount;
    private long comparisonCount;
    private long executionTime;

    private HashMap<Integer, Queue<Integer>> hashMap1 = new HashMap();
    private HashMap<Integer, Queue<Integer>> hashMap2 = new HashMap();

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
        return RadixSort.class.getName();
    }

    @Override
    public void printAnalysis() {
        System.out.println(getSortingName() + ", " + getSwapCount() + ", "
                + getComparisonCount() + ", " + getExecutionTime());
    }

    @Override
    public int[] sort(int[] array) {
        final int N = array.length;
        int maxNum = 0;
        long start = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
//            swapCount++;
            int num = array[i];
            int unid = (num % 10);
            if (!hashMap1.containsKey(unid)) {
                Queue<Integer> queue = new ArrayDeque();
                queue.offer(num);
                hashMap1.put(unid, queue);
            } else {
                hashMap1.get(unid).offer(num);
            }
            if (maxNum < num) {
                maxNum = num;
            }
        }
        int iterationNumber = String.valueOf(maxNum).length();
        HashMap<Integer, Queue<Integer>> hashMapTemp = hashMap1;
        int i = 0;
        int mod = 100;
        int div = 10;
        while (i < iterationNumber) {
//            Set<Integer> tempL = hashMapTemp.keySet();
            for (int pivot = 0; pivot < 10; pivot++) {
                Queue<Integer> l = hashMapTemp.get(pivot);
                while (l != null && !l.isEmpty()) {
                    Integer x = l.poll();
                    int helper1 = x % mod / div;
                    if (!hashMap2.containsKey(helper1)) {
                        Queue<Integer> queue = new ArrayDeque<>();
                        queue.offer(x);
                        hashMap2.put(helper1, queue);
                    } else {
                        hashMap2.get(helper1).offer(x);
                    }
//                    swapCount++;
                }
            }
            hashMapTemp = hashMap2;
            hashMap2 = new HashMap();
            div = mod;
            mod *= 10;
            i++;
        }
        long end = System.currentTimeMillis();
        executionTime = (end - start);
        i = 0;
        for (Integer num : hashMapTemp.get(0)) {
            array[i] = num;
            i++;
        }
        return array;
    }
    
    @Override
    public void reset() {
        comparisonCount = 0L;
        swapCount = 0L;
        executionTime = 0L;
    }

}
