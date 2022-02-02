package codility;

import java.util.Arrays;

public class C_06_Triangle {
    public int solution(int[] A) {
        int length = A.length;
        if (length < 3) {
            return 0;
        }
        Arrays.sort(A);
        for (int i = 0; i < length - 2; i++) {
            if ((long)A[i] + (long) A[i + 1] > (long) A[i + 2]) {
                return 1;
            }
        }
        return 0;
    }
}
