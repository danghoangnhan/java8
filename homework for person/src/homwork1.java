import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.*;
public class homwork1 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        IntStream list = IntStream.rangeClosed(2, n);
        for(int i=0;i<=n;i++)
            list.add(i);
list.forEach(System.out::println);

        List<Integer> primeNumber = list.stream()
                .filter(d ->isPrime(d)==true).collect(Collectors.toList());
        primeNumber.forEach(System.out::println);
    }

    public static boolean isPrime(int number) {
        return !IntStream.rangeClosed(2, number/2).anyMatch(i -> number%i == 0);
    }


    }


