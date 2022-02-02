package codility;

import java.util.Arrays;

/**
 NumberOfDiscIntersections
 START
 Compute the number of intersections in a sequence of discs.
 We draw N discs on a plane. The discs are numbered from 0 to N − 1. An array A of N non-negative integers, specifying
 the radiuses of the discs, is given. The J-th disc is drawn with its center at (J, 0) and radius A[J].

 We say that the J-th disc and K-th disc intersect if J ≠ K and the J-th and K-th discs have at least one common point
 (assuming that the discs contain their borders).

 The figure below shows discs drawn for N = 6 and A as follows:

 A[0] = 1
 A[1] = 5
 A[2] = 2
 A[3] = 1
 A[4] = 4
 A[5] = 0


 There are eleven (unordered) pairs of discs that intersect, namely:

 discs 1 and 4 intersect, and both intersect with all the other discs;
 disc 2 also intersects with discs 0 and 3.
 Write a function:

 class Solution { public int solution(int[] A); }

 that, given an array A describing N discs as explained above, returns the number of (unordered) pairs of intersecting
 discs. The function should return −1 if the number of intersecting pairs exceeds 10,000,000.

 Given array A shown above, the function should return 11, as explained above.

 Write an efficient algorithm for the following assumptions:

 N is an integer within the range [0..100,000];
 each element of array A is an integer within the range [0..2,147,483,647].
 */
public class C_06_NumberOfDiscIntersections {
    public int solution(int[] A) {
        final int MAX_INTERSECTIONS = 10_000_000;
        int length = A.length;
        int [] startPoints = new int [length];
        int [] endPoints = new int [length];
        for (int i = 0; i < length; i++) {
            startPoints[i] = i - A[i];
            if (Integer.MAX_VALUE - A[i] < i) {
                endPoints[i] = Integer.MAX_VALUE;
            }
            else {
                endPoints[i] = i + A[i];
            }
        }
        Arrays.sort(startPoints);
        Arrays.sort(endPoints);
        int startDiscIndex= 0;
        int endDiscIndex = 0;
        int openDiscs = 0;
        int result = 0;
        while(startDiscIndex < length) {
            if (startPoints[startDiscIndex] <= endPoints[endDiscIndex]) {
                result = result + openDiscs;
                if (result > MAX_INTERSECTIONS) {
                    return -1;
                }
                openDiscs++;
                startDiscIndex++;
            } else {
                openDiscs--;
                endDiscIndex++;
            }
        }
        return result;
    }
}
