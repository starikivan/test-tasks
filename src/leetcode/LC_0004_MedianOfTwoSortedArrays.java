package leetcode;

/**
 4. Median of Two Sorted Arrays
 Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted
 arrays.

 The overall run time complexity should be O(log (m+n)).



 Example 1:

 Input: nums1 = [1,3], nums2 = [2]
 Output: 2.00000
 Explanation: merged array = [1,2,3] and median is 2.
 Example 2:

 Input: nums1 = [1,2], nums2 = [3,4]
 Output: 2.50000
 Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 Example 3:

 Input: nums1 = [0,0], nums2 = [0,0]
 Output: 0.00000
 Example 4:

 Input: nums1 = [], nums2 = [1]
 Output: 1.00000
 Example 5:

 Input: nums1 = [2], nums2 = []
 Output: 2.00000


 Constraints:

 nums1.length == m
 nums2.length == n
 0 <= m <= 1000
 0 <= n <= 1000
 1 <= m + n <= 2000
 -106 <= nums1[i], nums2[i] <= 106
 */
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
