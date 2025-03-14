package two_pointers;

public class TrappingRainWater {
    //this is O(n^2) time, and O(1) space
    public static int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
         int res = 0;
        for (int i = 0; i < height.length; i++) {
            int leftMax = height[i], rightMax = height[i];

            for (int j = 0; j < i; j++) {//the right left max must be before the ith
                leftMax = Math.max(leftMax, height[j]);
            }

            for (int j = i + 1; j < height.length; j++) {//this is the left max, it must be after i to n
                rightMax = Math.max(rightMax, height[j]);
            }

            res +=  Math.min(leftMax, rightMax) - height[i];
        }
        return res;
    }

    //using prefix and suffix array O(n) time, and O(n) space
    public static int trap2(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }


        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--){
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return res;
    }

    //using two pointers O(n) time, and O(1) space
    public static int trap3(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int l = 0, r = height.length - 1;
        int leftMax = height[l], rightMax = height[r];
        int res = 0;
        while (l < r) {
            if (leftMax < rightMax) {
                l++;
                leftMax = Math.max(leftMax, height[l]);
                res += leftMax - height[l];
            }
            else {
                r--;
                rightMax = Math.max(rightMax, height[r]);
                res += rightMax - height[r];
            }
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(trap3(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
