package arrays;

import java.util.*;

public class TopKFrequentElements {
    public static int[] topKFrequent(int[] nums, int k) {
        int[] freqArr = new int[nums.length];
        Map<Integer, Integer> res = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            freqArr[nums[i]]++;
        }


        for (int i = freqArr.length - 1; i >= 0; i--) {
            while (freqArr[i] > 0 && k > 0) {
                freqArr[i]--;
                res.put(nums[i], freqArr[i]);
                k--;
            }
        }
        return null;
    }

    //First correct solution(sorting):
    public static int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);//put the key in the map, and get the value of the key, if there is no value(new key) make the default zero and increment it by 1, if exist before increment it by 1
        }

        List<int[]> arr = new ArrayList<>();//
        for(Map.Entry<Integer, Integer> entry : count.entrySet()) {
            arr.add(new int[] {entry.getValue(), entry.getKey()});
        }

//        If b[0] > a[0], the result is positive → Swap (b comes before a).
//        If b[0] < a[0], the result is negative → No Swap (a stays before b).
//        If b[0] == a[0], the result is 0 → Keep original order.
        arr.sort((a, b) -> b[0] - a[0]);//sort the arr (which is an ArrayList of integer arrays) based on a custom comparison (higher frequencies come first)

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr.get(i)[1];
        }
        return res;
    }

    //Second correct solution(heap(priority queue)
    public static int[] topKFrequent3(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums)
            count.put(num, count.getOrDefault(num, 0) + 1);
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            heap.offer(new int[] {entry.getValue(), entry.getKey()});
            if (heap.size() > k)
                heap.poll();
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = heap.poll()[1];
        }
        return res;
    }

    //Third correct solution(Bucket sort)
    public static int[] topKFrequent4(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        List<Integer>[] freq = new List[nums.length + 1];
        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }

        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : count.entrySet())
            freq[entry.getValue()].add(entry.getKey());

        int[] res = new int[k];
        int index = 0;
        for (int i = freq.length - 1; i > 0 && index < k; i--) {
            for (int n : freq[i]) {
                res[index++] = n;
                if (index == k)
                    return res;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] input = new int[] {1,1,1,2,2,3};
        int[] res = topKFrequent4(input, 2);
        for (int i : res)
            System.out.println(i);



    }
}
