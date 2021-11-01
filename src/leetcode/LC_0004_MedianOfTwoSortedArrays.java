package leetcode;

public class LC_0004_MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        if (length == 0) {
            return 0;
        }
        int i = 0;
        int j = 0;
        int k = 0;
        int limit = length / 2 + 1;
        int previous = 0;
        int current = 0;
        while (i < nums1.length && j < nums2.length && k < limit) {
            previous = current;
            if (nums1[i] < nums2[j]) {
                current = nums1[i++];
            }
            else {
                current = nums2[j++];
            }
            k++;
        }
        while (k < limit) {
            previous = current;
            if (i < nums1.length) {
                current = nums1[i++];
            } else {
                current = nums2[j++];
            }
            k++;
        }
        if (length % 2 == 0 ) {
            return ((double) previous + current) / 2;
        }
        return current;
    }
}
