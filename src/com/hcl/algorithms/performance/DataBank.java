/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hcl.algorithms.performance;

import com.hcl.algorithms.sort.Sort;
import com.hcl.algorithms.utils.Utils;
import java.util.HashMap;
import java.util.Hashtable;

/**
 *
 * @author Angel.Sahagun
 */
public class DataBank {

    private Sort sortingAnalysis;
    private HashMap<Integer, AVG> avgTable = new HashMap();

    public enum ElementTypes {

        RANDOM,
        PARTIAL,
        SORTED,
        INVERTED
    }

    public DataBank(Sort sortingAnalysis) {
        this.sortingAnalysis = sortingAnalysis;
    }

    public StringBuilder getSortDataAnalysis(int numberOfExecutions, int elements,
            int min, int max, ElementTypes type, int scalar) {
        StringBuilder sb = new StringBuilder();
        int[] array;
        long swapAverange = 0L;
        long comparisonAverange = 0L;
        long executionAverange = 0L;
        for (int i = 1; i <= elements; i++) {
            int n = i * scalar;
            long swapSum = 0L;
            long comparisonSum = 0L;
            long executionSum = 0L;
            for (int j = 0; j < numberOfExecutions; j++) {
                switch (type) {
                    case INVERTED:
                        array = Utils.invertedArray(n);
                        break;
                    case PARTIAL:
                        array = Utils.partialSortArray(n);
                        break;
                    case RANDOM:
                        array = Utils.createArray(n, min, max);
                        break;
                    case SORTED:;
                        array = Utils.createSortedArray(n);
                        break;
                    default:
                        array = new int[n];
                }
                sortingAnalysis.sort(array);
                sb.append(n).append(", ").append(sortingAnalysis.getSortingName()).append(", ").append(sortingAnalysis.getSwapCount()).append(", ").append(sortingAnalysis.getComparisonCount()).append(", ").append(sortingAnalysis.getExecutionTime()).append("\n");
                swapSum += sortingAnalysis.getSwapCount();
                comparisonSum += sortingAnalysis.getComparisonCount();
                executionSum += sortingAnalysis.getExecutionTime();
                if(!Utils.isSorted(array)){
                    System.err.println("NOt WORKIng");
                }
                sortingAnalysis.reset();
            }
            swapAverange = swapSum / numberOfExecutions;
            comparisonAverange = comparisonSum / numberOfExecutions;
            executionAverange = executionSum / numberOfExecutions;
            sb.append(sortingAnalysis.getSortingName()).append(" avg ").append(swapAverange).append(", ").append(comparisonAverange).append(", ").append(executionAverange).append("\n");
            avgTable.put(n, new AVG(swapAverange, comparisonAverange, executionAverange));
        }

        return sb;
    }

    public HashMap<Integer, AVG> getAvgTable() {
        return avgTable;
    }

    public class AVG {

        private long swapAverange;
        private long comparisonAverange;
        private long executionAverange;

        public AVG(long swapAverange, long comparisonAverange, long executionAverange) {
            this.swapAverange = swapAverange;
            this.comparisonAverange = comparisonAverange;
            this.executionAverange = executionAverange;
        }

        public long getSwapAverange() {
            return swapAverange;
        }

        public long getComparisonAverange() {
            return comparisonAverange;
        }

        public long getExecutionAverange() {
            return executionAverange;
        }

        public String printAvg() {
            return getComparisonAverange() + ", " + getSwapAverange() + ", " + getExecutionAverange();
        }

    }

    public void createAVG(int numberOfExecutions, int elements,
            int min, int max, ElementTypes type, int scalar) {
        int[] array;
        long swapAverange = 0L;
        long comparisonAverange = 0L;
        long executionAverange = 0L;
        for (int i = 1; i <= elements; i++) {
            int n = i * scalar;
            long swapSum = 0L;
            long comparisonSum = 0L;
            long executionSum = 0L;
            for (int j = 0; j < numberOfExecutions; j++) {
                switch (type) {
                    case INVERTED:
                        array = Utils.invertedArray(n);
                        break;
                    case PARTIAL:
                        array = Utils.partialSortArray(n);
                        break;
                    case RANDOM:
                        array = Utils.createArray(n, min, max);
                        break;
                    case SORTED:;
                        array = Utils.createSortedArray(n);
                        break;
                    default:
                        array = new int[n];
                }
                sortingAnalysis.sort(array);
                swapSum += sortingAnalysis.getSwapCount();
                comparisonSum += sortingAnalysis.getComparisonCount();
                executionSum += sortingAnalysis.getExecutionTime();
                sortingAnalysis.reset();
            }
            swapAverange = swapSum / numberOfExecutions;
            comparisonAverange = comparisonSum / numberOfExecutions;
            executionAverange = executionSum / numberOfExecutions;
            avgTable.put(n, new AVG(swapAverange, comparisonAverange, executionAverange));
        }
    }

}
