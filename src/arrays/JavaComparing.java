package arrays;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Stream;

//to compare between two objects we can implement Comparator explicitly or by anonymous class
// in this file we print out the content of the list descendingly(if n1 > n2) we don't swap (return -1)
// else we swap(return 1)

class Comparison2 implements Comparator<Integer> {
    @Override
    public int compare(Integer n1, Integer n2) {
        if (n1 > n2)
            return -1;
        return 1;
    }
}

public class JavaComparing {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(22);
        list.add(332);
        list.add(4);
        list.add(332);
        list.add(5);
        Collections.sort(list, new Comparison2());
        System.out.println(list);


        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer n1, Integer n2) {
                if (n1 > n2)
                    return -1;
                return 1;
            }
        };

        Comparator<Integer> com1 = ((n1, n2) -> {
            if (n1 > n2) return -1;
            return 1;
        });

        Comparator<Integer> com2 = (n1, n2) -> n1 > n2 ? -1 : 1;

        Collections.sort(list, com1);
        System.out.println(list);

        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);


        Consumer<Integer> cons = new Consumer<Integer>() {
            @Override
            public void accept(Integer n) {
                System.out.println(n);
            }
        };

        nums.forEach(cons);
        nums.forEach(System.out::println);
        nums.forEach(n -> System.out.println(n));//this lambda expression is an implementation of the Consumer class

        System.out.println("------------------------------------");



        List<Integer> arrs = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Stream<Integer> stream1 = arrs.stream()
                .filter(n -> n % 2 == 0)
                .map (n -> n * 2);

        Stream<Integer> stream2 = stream1.sorted(new Comparison2());







    }
}
