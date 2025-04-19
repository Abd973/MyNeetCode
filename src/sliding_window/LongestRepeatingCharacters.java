package sliding_window;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LongestRepeatingCharacters {
    public static int characterReplacement(String s, int k) {
        int longest = 1;
        int sLength = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                sLength++;
            }
            else if (s.charAt(i) != s.charAt(i - 1) && k > 0) {

            }
            longest = Math.max(longest, sLength);
        }
        return longest;
    }

    public static int characterReplacement2(String s, int k) {
        Map<Character, Character> map = new HashMap<>();
        map.put(s.charAt(0), s.charAt(0));
        int longest = 1;
        int sLength = 1;
        for (int i = 1; i < s.length(); i++) {
            if (map.containsValue(s.charAt(i))) {
                sLength++;
            }
            else if(!map.containsValue(s.charAt(i)) && k > 0) {
                map.put(s.charAt(i), s.charAt(i - 1));
                k--;
            }
            longest = Math.max(longest, sLength);
        }
        return longest;
    }

    //correct version(brute force):
    public static int characterReplacement3(String s, int k) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            HashMap<Character, Integer> count = new HashMap<>();
            int maxF = 0;
            for (int j = i; j < s.length(); j++) {
                count.put(s.charAt(j), count.getOrDefault(s.charAt(j), 0) + 1);
                maxF = Math.max(maxF, count.get(s.charAt(j)));
                if ((j - i + 1) - maxF <= k) {
                    res = Math.max(res, j - i + 1);
                }
            }
        }
        return res;
    }

    //sliding window technique, time complexity O(m*n), space O(m)
    public static int characterReplacement4(String s, int k) {
        int res = 0;
        HashSet<Character> charSet = new HashSet<>();
        for (char c : s.toCharArray()) {
            charSet.add(c);
        }

        for (char c : charSet){
            int count = 0;
            int l = 0;
            for (int r = 0; r < s.length(); r++) {
                if (s.charAt(r) == c)
                    count++;

                while ((r - l + 1) - count > k) {//if the number of required replacements cross k, shrink the window
                    if (s.charAt(l) == c)
                        count--;
                    l++;
                }
                res = Math.max(res, r - l + 1);
            }
        }
        return res;
    }

    //sliding window O(n) time, O(m) space
    public static int characterReplacement5(String s, int k) {
        int res = 0;
        Map<Character, Integer> count = new HashMap<>();
        int l = 0;
        int maxF = 0;
        for (int r = 0; r < s.length(); r++) {
            count.put(s.charAt(r), count.getOrDefault(s.charAt(r),0) + 1);
            maxF = Math.max(maxF, count.get(s.charAt(r)));

            while ((r - l + 1) - maxF > k) {
                count.put(s.charAt(l), count.get(s.charAt(l)) - 1);
                l++; //shrink the window
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(characterReplacement4("ABAB", 2));
    }
}
