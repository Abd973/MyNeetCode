package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EncodeDecode {
    //My Initial Solution:
    public static String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();
        for (String str : strs) {
            res.append(str).append("#");
        }
        return res.toString();
    }
    public static List<String> decode(String str) {
        String[] strs = str.split("#");
        List<String> list = new ArrayList<>();
        for (String s : strs) {
            list.add(s);
        }
        return list;
    }
    //My Solution after reading the hints:
    public static String encode2(List<String> strs) {
        StringBuilder res = new StringBuilder();
        for (String str : strs) {
            res.append(str.length()).append("#").append(str);
        }
        return res.toString();
    }

    public static List<String> decode2(String str) {
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
                StringBuilder num = new StringBuilder();
                while(str.charAt(j) != '#') {
                    num.append(str.charAt(j));
                }
                 int convertedNum = Integer.parseInt(num.toString());
                StringBuilder actualS = new StringBuilder();
                while(convertedNum-- > 0) {
                    actualS.append(str.charAt(j+1));
                }
                list.add(actualS);
            }
        }
        return list.stream().map(StringBuilder::toString).collect(Collectors.toList());
    }

    //NeetCode's first solution:
    public static String encode3(List<String> strs) {
        if (strs.isEmpty()) return "";
        StringBuilder res = new StringBuilder();
        List<Integer> sizes = new ArrayList<>();
        for (String str : strs)
            sizes.add(str.length());

        for(Integer size : sizes)
            res.append(size).append(',');
        res.append('#');
        for(String s : strs)
            res.append(s);

        return res.toString();
    }

    public static List<String> decode3(String str) {
        if (str.length() == 0) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        List<Integer> sizes = new ArrayList<>();
        int i = 0;
        while (str.charAt(i) != '#') {
            StringBuilder cur = new StringBuilder();
            while (str.charAt(i) != ',') {
                cur.append(str.charAt(i));
                i++;
            }
            sizes.add(Integer.parseInt(cur.toString()));
            i++;
        }
        i++;

        for (int size : sizes) {
            res.add(str.substring(i, i + size));
            i += size;
        }

        return res;
    }

    //NeetCode's optimal solution:
    public static String encode4(List<String> strs) {
        StringBuilder res = new StringBuilder();
        for (String str : strs) {
            res.append(str.length()).append("#").append(str);
        }
        return res.toString();
    }

    public static List<String> decode4(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#')
                j++;
            int length = Integer.parseInt(str.substring(i, j));
            i = j + 1;
            j = i + length;
            res.add(str.substring(i, j));
            i = j;
        }
        return res;
    }



    public static void main(String[] args) {
        String encodedString = encode3(Arrays.asList("abc", "defg", "hijk"));
        List<String> list = decode3(encodedString);
        for (String s : list) {
            System.out.println(s);
        }

    }
}
