package de.labathome;

/**
 * Precise summation of many finite-relative-accuracy numbers of many different orders of magnitude
 * @author Jonathan Schilling (jonathan.schilling@ipp.mpg.de)
 */
public class PreciseSummation {

	/**
	 * Returns the precise sum of all elements of {@code x}.
	 * The values in {@code x} are put into a priority queue (min heap).
	 * Then, the two smallest numbers are drawn from the heap, added together and put back into the heap
	 * until the only element left in the heap is the sum of all elements of {@code x}.
	 * @param x [N] input array
	 * @return \sum_{i=0}^N x_i
	 */
	public static double preciseSum(final double[] x) {
		
		return 0.0;
	}
}
