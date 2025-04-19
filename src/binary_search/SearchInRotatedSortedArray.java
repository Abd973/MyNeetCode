package binary_search;

public class SearchInRotatedSortedArray {
    //this is my solution (which is correct)
    //fails in some test cases so far
    public static int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) return mid;
            if (nums[l] > nums[r]) {//this means it's a rotated array, which means the left part greater than the right part
                if (nums[mid] > target)
                    l = mid + 1;
                else
                    r = mid - 1;
            }
            else {//normal binary search
                if (nums[mid] > target)
                    r = mid - 1;
                else
                    l = mid + 1;
            }
        }
        return -1;
    }

    //the following solution as same as explained in the video:
    public static int search2(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r ) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) return mid;
            //searching in the left sorted array:
            if (nums[l] <= nums[mid]) {
                if (target > nums[mid] || target < nums[l])//it might be in the right sorted array(which is smaller than the left)
                    l = mid + 1;
                else
                    r = mid - 1;
            }

//searching in the left sorted array:
            else {
                if (target < nums[mid] || target > nums[r]) //it might be in the left sorted array(which is greater than the right)
                    r = mid - 1;
                else
                    l = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{1, 3}, 3));
    }
}
