package sliding_window;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PermutationInString {
    public static boolean checkInclusion(String s1, String s2) {
        for (int i = 0; i < s2.length(); i++) {
            StringBuilder s2String = new StringBuilder();
            for (int j = 0; j < s2.length(); j++) {
                s2String.append(s2.charAt(i) + s2.charAt(j));
                if (s2String.toString().equals(s1))
                    return true;

            }
        }
        return false;
    }

    public static boolean checkInclusion2(String s1, String s2) {
        Arrays.sort(s1.toCharArray());
        Arrays.sort(s2.toCharArray());
        for (int i = 0; i < s2.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {

            }
        }
        return false;
    }

    // correct brute force solution, very bad solution,
    public static boolean checkInclusion3(String s1, String s2) {
        char[] s1Chars = s1.toCharArray();
        Arrays.sort(s1Chars);
        String s1Sorted = new String(s1Chars);

        for (int i = 0; i < s2.length(); i++) {
            for (int j = i; j < s2.length(); j++) {
                char[] substrArr = s2.substring(i, j + 1).toCharArray();
                Arrays.sort(substrArr);
                String s2SortedSubstring = new String(substrArr);
                if (s2SortedSubstring.equals(s1Sorted))
                    return true;
            }
        }
        return false;
    }

    //Hash table solution, O(m*n) time, O(1) space:
    //not passed
    public static boolean checkInclusion4(String s1, String s2) {
        Map<Character, Integer> count1 = new HashMap<>();
        for (char c : s1.toCharArray())
            count1.put(c, count1.getOrDefault(c, 0) + 1);

        int neededSize = count1.size();
        for (int i = 0; i < s2.length(); i++) {
            Map<Character, Integer> count2 = new HashMap<>();
            int cur = 0;
            for (int j = i; j < s2.length(); j++) {
                char c = s2.charAt(j);
                count2.put(c, count2.getOrDefault(c, 0) + 1);

                if (count1.getOrDefault(c, 0) < count2.get(c))
                    break;//look for another substring

                if (count1.getOrDefault(c, 0) == count2.get(c))
                    cur++;

                if (cur == neededSize)
                    return true;
            }
        }
        return false;
    }

    //using sliding window
    public static boolean checkInclusion5(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        int[] s1Count = new int[26];
        int[] s2Count = new int[26];
        for (char c : s1.toCharArray()) {
            s1Count[c - 'a']++;
            s2Count[c - 'a']++;
        }

        int matches = 0;
        for (int i = 0; i < 26; i++) {
            if (s1Count[i] == s2Count[i])
                matches++;
        }

        int l = 0;
        for (int r = s1.length(); r < s2.length(); r++) {
            if (matches == 26)
                return true;

            int index = s2.charAt(r) - 'a';
            s2Count[index]++;
            if (s1Count[index] == s2Count[index])
                matches++;
            else if (s1Count[index] + 1 == s2Count[index])//they were equal, but now they are not, so we decrement the value of matches
                matches--;

            index = s2.charAt(l) - 'a';
            s2Count[index]--;
            if (s1Count[index] == s2Count[index])
                matches++;
            else if (s1Count[index] - 1 == s2Count[index])//they were equal, but now they are not, so we decrement the value of matches
                matches--;
            l++;
        }
        return matches == 26;
    }

    public static void main(String[] args) {
        System.out.println(checkInclusion5("ba", "eidbaooo"));
    }
}
