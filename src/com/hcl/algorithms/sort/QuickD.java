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
public class QuickD implements Sort {

    private static int contDontCross = 0;

    @Override
    public int[] sort(int[] array) {
        return quicksort(array, 0, array.length - 2, array.length - 1);
    }

    private static int[] quicksort(int[] arrayToSort, int pointer1, int pointer2, int pivote) {
        int startPos = pointer1;
        int endPos = pointer2;

        if (pointer1 == pivote) {
            return arrayToSort;
        }

        while (pointer1 < pivote && !(arrayToSort[pointer1] > arrayToSort[pivote])) {
            // move to next
            pointer1++;
        }
        while (pointer2 > pointer1 && !(arrayToSort[pointer2] < arrayToSort[pivote])) {
            pointer2--;
        }

        if (pointer1 >= pointer2) {
            // Se cruzaron
            Utils.swap(arrayToSort, pivote, pointer1);
            // Llamo recursivamente a quicksort para ambos extremos
            if (pointer1 - 1 > startPos) {// Aqui podemos ver cuando sea de 1, sin el = en la cond
//                   System.out.println("Llamada cruzaron: " + startPos + ", " + (pointer1 - 2) + ", " + (pointer1 - 1));
                quicksort(arrayToSort, startPos, pointer1 - 2, pointer1 - 1);
            }
            if (pointer1 + 1 < pivote) {
//                   System.out.println("Llamada cruzaron: " + (pointer1 + 1) + ", " + (pivote - 1) + ", " + pivote);
                quicksort(arrayToSort, pointer1 + 1, pivote - 1, pivote);
            }
        } else {
            // No se cruzaron
            Utils.swap(arrayToSort, pointer1, pointer2);
            // Mejoro las posiciones de los apuntadores
//              System.out.println("Llamada no cruce: " + pointer1 + ", " + (pointer2) + ", " + pivote);
            quicksort(arrayToSort, pointer1, pointer2, pivote);
        }
        return arrayToSort;
    }

    @Override
    public void reset() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long getSwapCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long getComparisonCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long getExecutionTime() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSortingName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void printAnalysis() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void main(String[] args) {
        QuickD quickD = new QuickD();
        int[] array = Utils.createArray(1000, 0, 100_000);
        quickD.sort(array);
        if (!Utils.isSorted(array)) {
            System.err.println("Error");
        }
//        Utils.printArray(array);
    }

}
