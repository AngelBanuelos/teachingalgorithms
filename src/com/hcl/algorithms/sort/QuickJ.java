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
public class QuickJ {

    private int[] list;

    public static void main(String[] args) {
        QuickJ s = new QuickJ();
        int[] list = s.createRandomList(100_000);
        s.sort(list);
        if(!Utils.isSorted(list)){
            System.err.println("Not Sorted!");
        }
// System.out.println("\n"+toString(list));
    }

    public int[] sort(int[] list) {
        Crono c = new Crono();
        if (list == null || list.length == 1) {
            return list;
        }
        this.list = list;
        c.start();
        quickSort(0, list.length - 1);
        c.stop();
        System.out.println("Sorting list " + c);
        return list;
    }

    public int[] quickSort(int init, int end) {
        if (end - init <= 0) {
            return list;
        }
        if (end - init == 1) {
            if (list[init] > list[end]) {
                swap(init, end);
            }
            return list;
        }
        int pibot = list[end];
        int pr = end - 1;
        int pl = init;
// System.out.println(" s: "+init+" E:"+end+" p:"+pibot);
        while (true) {
//looks for an element bigger than pibot value
            while (list[pl] <= pibot && pl < end) {
                pl++;
            }
// System.out.print(" pl: "+pl);
// if pointers are crossed.
            if (pl >= pr) {
                swap(pl, end); // swap with the pibot
                quickSort(init, pl - 1); //process left side.
                quickSort(pl + 1, end); // process right side.
                break;
            }
// looking for element on the right side smaller than piboth
            while (list[pr] >= pibot && pr > 0) {
                pr--;
            }
// System.out.print(" pr: "+pr);
// if pointers are crossed.
            if (pl >= pr) {
                swap(pl, end); // swap with the pibot
                quickSort(init, pl - 1); //process left side.
                quickSort(pl + 1, end); // process right side.
                break;
            }

//pointer have not crossed so, swap pointers.
            swap(pl, pr);
        }
        return list;
    }

    private void swap(int x, int y) {
        int temp = list[x];
        list[x] = list[y];
        list[y] = temp;
// System.out.println(toString(list));
// System.out.println(x);
    }

    public int[] createRandomList(int size) {
        Crono c = new Crono();
        c.start();
        int[] list = Utils.invertedArray(size);//new NumberGenerator().randomIntArray(size, -1000_000, 1000_000);
        c.stop();
        System.out.println("Time creating list " + c);
        return list;
    }

    private static String toString(int[] list) {
        StringBuilder b = new StringBuilder();
        for (int i : list) {
            b.append(i + ", ");
        }
        return b.toString();
    }

    class Crono {

        private long start = 0;

        private long end = 0;

        private long time = 0;

        public void start() {
            start = System.currentTimeMillis();
        }

        public void stop() {
            end = System.currentTimeMillis();
            addMs(getLastLapMs());
        }

        public void addMs(long ms) {

            time += ms;
        }

        public long getLastLapMs() {

            return end - start;
        }

        public long getLastLapS() {

            return getLastLapMs() / 1000;
        }

        public void reset() {
            start = end = 0;
        }

        public long getMiliSeconds() {
            return time;
        }

        public long getSeconds() {
            return time / 1000;
        }

        public String toString() {

            return "Time: " + getMiliSeconds() + "ms, " + getSeconds() + "s";
        }
    }

//    class NumberGenerator {
//
//        public int[] randomIntArray(int size, int min, int max) {
//            int array[] = new int[size];
//            Random r = new Random();
//            int bound = max - min + 1;
//            for (int i = 0; i < size; i++) {
//                array[i] = r.nextInt(bound) + min;
//            }
//            return array;
//        }
//    }

}
