package arrays;

import java.util.*;



class Comparison implements Comparator<Integer> {
    @Override
    public int compare(Integer n1, Integer n2) {
        if (n1 > n2)
            return -1;
        else
            return 1;
    }
}

public class CollectionTest {
    public static void main(String[] args) {
        Collection<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        //Collection arr = new ArrayList<>(); this is collection of objects
        List<Integer> arr = new ArrayList<>(); // this is collection of Integers
        arr.addAll(set);
        //System.out.println(arr.contains(3));
//        System.out.println(arr.containsAll(set));
//
//        for (int i : arr) {
//            System.out.println(i);
//        }


//        {
            Map<Integer, Integer> map = new HashMap<>();

//            Iterator<Integer> it = set.iterator();
//            while (it.hasNext()) {
//                System.out.println(it.next());
//            }
//        }


        Comparison com = new Comparison();
        Collections.sort(arr, com);
        System.out.println(arr);
    }
}
