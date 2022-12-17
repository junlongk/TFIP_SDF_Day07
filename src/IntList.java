import java.security.SecureRandom;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

/**
 * IntList
 */
public class IntList {

    public static void main(String[] args) {
        // Randomly generate a list of numbers
        Integer max = 100;
        Integer range = 100;

        Random rnd = new SecureRandom();

        List<Integer> numList = new LinkedList<>();

        for (Integer i = 0; i < max; i++)
            numList.add(rnd.nextInt(range));

        System.out.println(">>> numList: " + numList);

        filter(numList);
        map(numList);
    }

    public static void filter(List<Integer> numList) {

        System.out.println("======== FILTER =========");

        // filter
        List<Integer> resultList = new LinkedList<>();
        for (Integer n: numList) {
            if (0 == (n % 3))
                resultList.add(n);
        }
        System.out.println(">>> iteration resultList: " + resultList);

        resultList = numList.stream()
            // Predicate: boolean test(Integer i)
            .filter((n) -> 0 == (n % 3))
            .distinct()
            .sorted()
            .limit(5)
            .toList();

        System.out.println("");
        System.out.println(">>> stream resultList: " + resultList);
    }

    public static void map(List<Integer> numList) {
        
        System.out.println("========= MAP =============");

        // filter
        List<String> resultList = new LinkedList<>();
        for (Integer n: numList) {
            resultList.add("%d%d".formatted(n, n));
        }
        System.out.println(">>> iteration resultList: " + resultList);

        List<Integer> intList = numList.stream()
            // map: String apply(Integer i)
            .map(n -> "%d%d".formatted(n, n))
            // map: Integer apply(String i)
            .map(Integer::parseInt) // method reference
            .toList();

        System.out.println(">>> stream intList: " + intList);


        // my own half done version
        // List<String> resultStrList = new LinkedList<>();

        // resultStrList = numList.stream()
        // .map(x -> x.toString())
        // .toList();

        // System.out.println(">>> string result: " + resultStrList);

    }
}