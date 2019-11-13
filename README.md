# PreciseSummation
Precise summation of many finite-relative-accuracy numbers of many different orders of magnitude

Suppose you have an array `x`, which contains elements whose values span many different orders of magnitude.
Calculation of the sum of all elements in `x` cannot simply be done using a loop over all elements,
adding them up to a common sum one after another.
This is illustrated in the [test](https://github.com/jonathanschilling/PreciseSummation/blob/master/src/test/java/de/labathome/TestPreciseSummation.java).

The approach chosen in this code piece is to use a Java `PriorityQueue` to hold the elements of `x` ordered from smallest to largest.
Then, two elements are drawn, their sum is calculated and the sum is put back into the heap. This is repeated until there is only one element left
in the heap, which is the sum of all elements of `x`.

Interestingly, the Java Stream API already implements a similar method:
```
Arrays.stream(x).sum()
```

## Maven coordinates
```
<dependency>
	<groupId>de.labathome</groupId>
	<artifactId>PreciseSummation</artifactId>
	<version>1.0.0</version>
</dependency>
```