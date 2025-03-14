package two_pointers;

import java.util.Arrays;

public class ContainerWithMostWater {
    //My brute force solution:
    public static int maxArea(int[] height) {
        int maxAmount = 1;
        int amount = 1;
        for (int i = 0; i < height.length; i++) {
            for(int j = i + 1; j < height.length; j++){
                amount = Math.min(height[i], height[j]) * (j - i);
                maxAmount = Math.max(maxAmount, amount);
            }
        }
    return maxAmount;
    }
    //NeetCode's brute force solution:
    public static int maxArea2(int[] height) {
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            for(int j = i + 1; j < height.length; j++){
                res = Math.max(res, Math.min(height[i], height[j]) * (j - i));
            }
        }
        return res;
    }

    //two pointers:
    public static int maxArea3(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int res = 0;

        while(l < r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            res = Math.max(res, area);
            if (height[l] <= height[r])
                l++;
            else
                r--;

        }
        return res;

    }
    public static void main(String[] args) {
        //System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        int[] test = new int[]{1,8,6,2,5,4,8,3,7};
        //Arrays.sort(test);
        Arrays.stream(test).sorted().forEach(n -> System.out.println(n));
        System.out.println("After stream");
        for (int n : test)
            System.out.println(n);
    }
}
