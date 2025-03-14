package arrays;

import java.util.*;


public class GroupAnagrams {

    // My initial solution(not correct)
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> anagramsGroup = new ArrayList<>();
        for(int i = 0; i < strs.length; i++) {
            List<String> anagrams = new ArrayList<>();
            for (int j = i + 1; j < strs.length; j++) {
                if (strs[i].length() != strs[j].length())
                    break;
                int[] charsFrequencies = new int[26];
                for(int k = 0; k < strs[i].length(); k++) {
                    charsFrequencies[strs[i].charAt(k) - 'a']++;
                    charsFrequencies[strs[j].charAt(k) - 'a']--;
                }
                boolean isAnagram = true;
                for(int k = 0; k < charsFrequencies.length; k++) {
                    if (charsFrequencies[k] != 0) {
                        isAnagram = false;
                        break;
                    }

                }
                if(isAnagram) {
                    if (anagrams.contains(strs[i]))
                        anagrams.add(strs[j]);
                    else {
                        anagrams.add(strs[i]);
                        anagrams.add(strs[j]);
                    }
                }

            }
            anagramsGroup.add(anagrams);
        }
        return anagramsGroup;
    }
    // Correct solutions
    public static List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sortedS = new String(charArray);
            map.putIfAbsent(sortedS, new ArrayList<>());
            map.get(sortedS).add(s);
        }
        return new ArrayList<>(map.values());
    }

    public static List<List<String>> groupAnagrams3(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            int[] charsFrequencies = new int[26];
            for(char c : s.toCharArray()) {
                charsFrequencies[c - 'a']++;
            }
            String key = Arrays.toString(charsFrequencies);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }
}
