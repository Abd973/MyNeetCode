package binary_search;

import java.util.Arrays;

public class FindMinimumInRotatedArray {
    // this is my initial solution which is incorrect
    public static int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((mid + 1) >= nums.length)
                mid = 0;
            if (nums[mid + 1] < nums[mid])
                return nums[mid + 1];
            else
                l = mid + 1;
        }
        return nums[l];
    }

    //A simple solution using java built-in functions:
    public static int findMin2(int[] nums) {
        return Arrays.stream(nums).min().getAsInt();
    }

    public static int findMin3(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int res = nums[0];

        while(l <= r) {
            if (nums[l] < nums[r]) {
                res = Math.min(res, nums[l]);
                break;
            }
            int mid = l + (r - l) / 2;
            res = Math.min(res, nums[mid]);
            if (nums[mid] >= nums[l])
                l = mid + 1;
            else
                r = mid - 1;
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(findMin(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
    }
}
