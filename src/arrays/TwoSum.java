package arrays;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
 public int[] twoSum(int[] nums, int target) {
     Map<Integer, Integer> map = new HashMap<>();

       for (int i = 0; i < nums.length; i++) {
           map.put(nums[i], i);//we keep the nums[i] and its index, to check index to avoid
       }

       for (int i = 0; i < nums.length; i++) {
           int complement = target - nums[i]; //target = nums[i] + nums[j], so nums[j] or the complement is equal to the difference between the target and nums[i]
           if(map.containsKey(complement) && map.get(complement) != i)
               return new int[]{i, map.get(complement)};
       }
       return new int[0];
 }
}
