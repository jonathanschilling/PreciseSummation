package de.labathome;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Locale;

import org.junit.jupiter.api.Test;

import static de.labathome.PreciseSummation.preciseSum;

public class TestPreciseSummation {

	 /**
     * Test summing a vector ordered by magnitude
     */
    @Test
    public void testSortedSum() {
        
        int n = 1000;
        double fill = 2e-18;
        
        double[] x = new double[n];
        Arrays.fill(x, fill);
        x[0] = 1.0;
        
        System.out.println("testing evaluation of 1.0+"+n+"*"+fill);
        
        double sumUnsorted = 0.0;
        for (int i=0; i<n; ++i) {
            sumUnsorted += x[i];
        }
        System.out.println(String.format(Locale.ENGLISH, " unsorted sum: %.25f", sumUnsorted));
        
        double sumSorted = preciseSum(x);
        System.out.println(String.format(Locale.ENGLISH, "   sorted sum: %.25f", sumSorted));
        
        double diff = fill*n;
        System.out.println(String.format(Locale.ENGLISH, "expected diff: %.25f",  diff));
        
        assertEquals(sumSorted, sumUnsorted+diff);
    }
	
}
