/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hcl.algorithms.sort;

import com.hcl.algorithms.performance.PerformanceAnalysis;

/**
 *
 * @author Angel.Sahagun
 */
public interface Sort extends PerformanceAnalysis {
    
    public int[] sort(int[] array);

    public void reset();
    
}
