package binary_search;

public class BinarySearch {
    //this is the recursive binary search:
    //O(log(n)) time, and O(log(n)) space, due to stack calls
    public static int binarySearch(int[] nums, int target) {
        return search(0, nums.length - 1, nums, target);
    }
    private static int search(int l, int r, int[] arr, int target) {
        if (l > r) return -1;
        int mid = l + (r - l) / 2;
        if (arr[mid] == target) return mid;
        return (arr[mid] < target)? // if the arr[mid] < target, then the target is in the greater side
                search(mid + 1, r, arr, target):
                search(l, mid - 1, arr, target);
    }

    //this is the iterative search:
    //O(log(n)) time, and O(1) space
    public static int binarySearch2(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            //the traditional way to compute mid is: (l + r) /2
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return -1;
    }


    public static void main(String[] args) {
        System.out.println(binarySearch2(new int[]{-1,0,3,5,9,12}, 9));
    }
}
