package binary_search;

import java.util.Arrays;

public class KokoEatingBananas {
    //this is my initial solution the brute force solution:
    public static int minEatingSpeed(int[] piles, int h) {
        int maxNum = Arrays.stream(piles).max().getAsInt();
        for (int i = 1; i < maxNum; i++) {
            for (int j = 0; j < piles.length - 1; j++) {
                while(h-- > 0) {
                    piles[j] -= i;
                    if (piles[i] <= 0)
                        break;
                }
            }
        }
        return maxNum;
    }

    public static int minEatingSpeed2(int[] piles, int h) {
        int k = 1;
        while(true) {//I think we can loop from 1 to the max number in the piles array
            long totalTime = 0;
            for (int pile : piles) {
                totalTime += (long) Math.ceil((double) pile / k);
            }

            if(totalTime <= h)
                return k;
            k++;//eat more, to eat all piles in shorter time
        }
    }

    //here we apply binary search to find the minimum rate (k)
    //we iterate over the entire array, eventually the complexity is O(log(m).n)
    //where m is the maximum number of bananas in a pile, and n is the size of the array
    public static int minEatingSpeed3(int[] piles, int h) {
        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt();
        int res = r; //this is initially,we want the minimum within the interval (h)

        while (l <= r) {
            int k = l + (r - l) / 2;// we apply binary search to find the k

            long totalTime = 0;
            for (int pile : piles) {
                totalTime += (long) Math.ceil((double) pile / k);
            }
            if (totalTime <= h) {//if the total time is within the h, we are looking for a minimum one
                res = k;
                r = k - 1; //such that r = mid - 1, as k is out mid here
            }
            else {
                l = k + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(minEatingSpeed2(new int[] {3,6,7,11}, 8));
    }
}
