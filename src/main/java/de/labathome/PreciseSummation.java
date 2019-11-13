package de.labathome;

import java.util.Locale;
import java.util.PriorityQueue;

/**
 * Precise summation of many finite-relative-accuracy numbers of many different orders of magnitude
 * @author Jonathan Schilling (jonathan.schilling@ipp.mpg.de)
 */
public class PreciseSummation {
	
	/**
	 * Set this to true to get some debugging messages.
	 */
	public static boolean _debug = false;

	/**
	 * Returns the precise sum of all elements of {@code x}.
	 * The values in {@code x} are put into a priority queue (min heap).
	 * Then, the two smallest numbers are drawn from the heap, added together and put back into the heap
	 * until the only element left in the heap is the sum of all elements of {@code x}.
	 * @param x [N] input array
	 * @return \sum_{i=0}^N x_i
	 */
	public static double preciseSum(final double[] x) {
		
		if (x == null || x.length == 0) {
			throw new RuntimeException("x is empty; nothing to add up");
		} else if (x.length == 1) {
			// nothing to add
			return x[0];
		} else if (x.length == 2) {
			// if we have two elements, we have no choice as to simply add them
			return x[0] + x[1];
		}
		
		// x.length > 2, so we have at least one clever choice to make
		
		PriorityQueue<Double> q = new PriorityQueue<>(x.length);
		for (double x_i: x) {
			q.add(x_i);
		}
		
		double x1, x2;
		
		// As long as we have at least two elements...
		while (q.size() > 1) {
			
			// ... get the smallest two elements from the heap ...
			x1 = q.poll();
			x2 = q.poll();
			
			if (_debug) System.out.println(String.format(Locale.ENGLISH, "%.5e + %.5e = %.5e", x1, x2, x1+x2));
			
			// ... add them up and insert them back into the heap...
			q.add(x1+x2);
		}

		// ... so that finally the last element in the heap is the precise sum of all its elements.
		return q.poll();
	}
}
