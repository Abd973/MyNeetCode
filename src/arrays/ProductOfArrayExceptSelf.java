package arrays;

import java.util.*;

public class ProductOfArrayExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int[] answers = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            int product = 1;
            for(int j = 0; j < nums.length; j++) {
                if (j != i)
                    product *= nums[j];
            }
            answers[i] = product;
        }
        return answers;
    }

    // division method x1.x2.x3.x4 = 24
    //to get x2.x3.x4, you can divide 24 by x1
    public static int[] productExceptSelf2(int[] nums) {
        int product = 1, zeroCount = 0;
        for (int num : nums) {
            if (num != 0)
                product *= num;
            else
                zeroCount++;
        }

        if (zeroCount > 1)
            return new int[nums.length];// if there are more one zero, all elements of the answer array will be zeros

        int[] answers = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (zeroCount > 0)
                answers[i] = (nums[i] == 0) ? product : 0; //if the nums array has a zero in this place answer[i] will equal to product, if else the answers[i] will be definitely zero
            else
                answers[i] = product / nums[i];
        }
        return answers;
    }

    ///prefix and suffix method with time complexity of O(n) and space complexity of O(n)
    public static int[] productExceptSelf3(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        int[] answer = new int[nums.length];

        prefix[0] = 1;
        for (int i = 1; i < n; i++) {
            prefix[i] = nums[i - 1] * prefix[i - 1];
        }

        suffix[n - 1] = 1;
        for(int i = n - 2; i >= 0; i--) {
            suffix[i] = nums[i + 1] * suffix[i + 1];
        }

        for (int i = 0; i < n; i++) {
            answer[i] = prefix[i] + suffix[i];
        }
        return answer;
    }

    ///prefix and suffix method with time complexity of O(n) and space complexity of O(1)
    public static int[] productExceptSelf4(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        int postfix = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] *= postfix;
            postfix *= nums[i];
        }
        return answer;
    }



    public static void main(String[] args) {
        int[] answers = productExceptSelf2(new int[]{1, 2, 3, 4});
        for(int i = 0; i < answers.length; i++) {
            System.out.println(answers[i]);
        }
    }
}
