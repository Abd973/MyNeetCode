package two_pointers;

public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        String normalizedString = s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        for(int i = 0; i < normalizedString.length() / 2; i++) {
            if(normalizedString.charAt(i) != normalizedString.charAt(normalizedString.length() - i -1))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("race a car"));

    }
}
