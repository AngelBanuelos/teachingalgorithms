/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hcl.algorithms.performance;

/**
 *
 * @author Angel.Sahagun
 */
public interface PerformanceAnalysis {
    
    public long getSwapCount();
    public long getComparisonCount();
    public long getExecutionTime();
    public String getSortingName();
    public void printAnalysis();
    
}
