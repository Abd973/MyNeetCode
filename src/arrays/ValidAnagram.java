package arrays;

public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        int[] charsFrequencies = new int[26];
        if (s.length() != t.length())
            return false;
        for(int i = 0; i < s.length(); i++) {
            charsFrequencies[s.charAt(i) - 'a']++;
            charsFrequencies[t.charAt(i) - 'a']--;
        }

        for(int i = 0; i < charsFrequencies.length; i++) {
            if (charsFrequencies[i] != 0)
                return false;
        }

        return true;

    }
    public static void main(String[] args) {
        System.out.println(isAnagram("ggii", "eekk"));
    }
}
