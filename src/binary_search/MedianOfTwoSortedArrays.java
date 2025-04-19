package binary_search;

public class MedianOfTwoSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        for (int i = 0; i < nums2.length; i++) {
            int l = 0;
            int r = nums1.length - 1;
            while (l <= r) {
                int mid = l + (r - l ) / 2;
                int idx = 0;
                if (nums1[mid] >= nums2[i]) {
                    r = mid - 1;
                    idx = (mid >= 1)? Math.min(mid - 1, idx) : 0;
                }
                else
                    l = mid + 1;
            }
        }
        return -1.0;
    }

    //two pointers (which is merge-based approach) O(n + m)
    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int len1 = nums1.length,  len2 = nums2.length;
        int i = 0, j = 0;
        int median1 = 0, median2 = 0;
        for(int count = 0; count < (len1 + len2)  / 2 + 1; count++) {
            median2 = median1;
            if (i < len1 && j < len2) {
                if (nums1[i] > nums2[j]) {
                    median1 = nums2[j];
                    j++;
                }
                else {
                    median1 = nums1[i];
                    i++;
                }
            }
            else if (i < len1) {
                median1 = nums1[i];
                i++;
            }
            else {
                median1 = nums2[j];
                j++;
            }
        }
        if((len1 + len2) % 2 == 1) {
            return (double) median1;
        } else
            return (median1 + median2) / 2.0;
    }
}
