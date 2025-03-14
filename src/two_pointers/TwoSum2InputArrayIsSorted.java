package two_pointers;

public class TwoSum2InputArrayIsSorted {

    public static int[] twoSum1(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target)
                    return new int[]{i + 1, j + 1};
            }
        }
        return new int[]{-1, -1};
    }
    public static int[] twoSum2(int[] numbers, int target) {
        for (int i = 0; i < numbers.length - 1; i++) {
            int l = i + 1, r = numbers.length - 1, complement = target - numbers[i];
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (numbers[mid] == complement)
                    return new int[]{i + 1, mid + 1};
                else if (numbers[mid] < complement)
                    r = mid - 1;
                else
                    l = mid + 1;
            }
        }
        return new int[]{-1, -1};
    }

    public static int[] twoSum3(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        while (l < r) {
            int sum = numbers[l] + numbers[r];
            if (sum == target)
                return new int[]{l + 1, r + 1};
            else if (sum <= target)
                l++;
            else
                r--;
        }
        return new int[2];
    }

    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum3(numbers, target);
        for (int n : result) {
            System.out.println(n);
        }
    }
}
