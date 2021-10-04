package homework;

import modernjavainaction.chap01.FilteringApples;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class firstHomework {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        IntStream list = IntStream.rangeClosed(2, n);

        list.forEach(System.out::println);

//        List<Integer> primeNumber =filter(list., (Integer number) -> isPrime(number) == true);
        primeNumber.forEach(System.out::println);
    }

    public static boolean isPrime(int number) {
        return !IntStream.rangeClosed(2, number/2).anyMatch(i -> number%i == 0);
    }
    public static List<FilteringApples.Apple> filter(IntStream inventory, Predicate<Integer> number) {
        List<FilteringApples.Apple> result = new ArrayList<>();
        for (indexNumber : inventory) {
            if (indexNumber.test(number)) {
                result.add(number);
            }
        }
        return result;
    }
}
