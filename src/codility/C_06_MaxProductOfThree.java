package codility;

import java.util.Arrays;

public class C_06_MaxProductOfThree {
    public int solution(int[] A) {
        Arrays.sort(A);
        int max1 = A[A.length - 1] * A[A.length - 2] * A[A.length - 3];
        int max2 = A[0] * A[1] * A[A.length - 1];
        return Math.max(max1, max2);
    }
}
