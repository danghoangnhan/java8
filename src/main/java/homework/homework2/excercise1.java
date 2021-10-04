
//Programing Exercise 2-1
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class excercise1 {

    public static void main(String[] args) {
        Scanner input = new Scanner((System.in));
        while(input.hasNextInt()){
            int n = input.nextInt();
            List<Integer> result = IntStream
                    .rangeClosed(1, n)
                    .filter(num -> isPrime(num))
                    .boxed()
                    .collect(Collectors.toList());

            result.forEach(s -> System.out.print(s + " "));

            System.out.println();

            List<Integer> prime=result.stream()
                    .filter(num -> isDived(num, n))
                    .collect(Collectors.toList());
            prime.forEach(s -> System.out.print(s + " "));

            System.out.println();

            Map<Integer,Integer> map = prime.stream()
                    .collect(Collectors.toMap(num1 -> num1, num2 -> power(num2, n,0)));

            map.forEach((key,value)->System.out.println("("+key+","+value+") "));
        }
    }


    public static boolean isPrime(int candidate){
        if(candidate==1)
            return true;

        return IntStream.
                rangeClosed(2,(int)Math.sqrt(candidate))
                .noneMatch(i->candidate%i==0);

    }
    public static boolean isDived(int candidate,int number){
        if(candidate==1)
            return false;

        return number%candidate==0;

    }

    public static int power(int x,int y, int k){
        if(y%x==0)
            return power(x,y/x,k+1);

        return k;
    }
}


