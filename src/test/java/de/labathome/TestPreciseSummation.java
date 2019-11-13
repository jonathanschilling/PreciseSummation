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
    public void testPreciseSum() {
        
        // 1.0 
    	double spoiler = 1.0;
    	
    	// + 1000 * 2e-18
    	int n1 = 1000;
        double fill1 = 2.0e-18;
        double[] x1 = new double[n1];
        Arrays.fill(x1, fill1);
        
        // + 1000000*2e-22
        int n2 = 1000000;
        double fill2 = 2.0e-22;
        double[] x2 = new double[n2];
        Arrays.fill(x2, fill2);
        
        // assemble all bits and pieces into one common array
        double[] x = new double[1+n1+n2];
        x[0] = spoiler;
        System.arraycopy(x1, 0, x, 1, n1);
        System.arraycopy(x2, 0, x, 1+n1, n2);
        		
        System.out.println("testing evaluation of 1.0 + "+n1+"*"+fill1+" + "+n2+"*"+fill2);
        
        // primitive implementation of summation of array elements
        double sumUnsorted = 0.0;
        for (int i=0; i<1+n1+n2; ++i) {
            sumUnsorted += x[i];
        }
        System.out.println(String.format(Locale.ENGLISH, " unsorted sum: %.25f", sumUnsorted));
        
        /**
         * Interestingly, the Java built-in Stream API already does what we want ;-)
         */
        double sumStream = Arrays.stream(x).sum();
        System.out.println(String.format(Locale.ENGLISH, "   stream sum: %.25f", sumStream));
        
        double sumSorted = preciseSum(x);
        System.out.println(String.format(Locale.ENGLISH, "   sorted sum: %.25f", sumSorted));
        
        double diff = fill1*n1+fill2*n2;
        System.out.println(String.format(Locale.ENGLISH, "expected diff: %.25f",  diff));
        
        assertEquals(sumSorted, sumUnsorted+diff);
    }
	
}
