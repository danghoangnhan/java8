package homework.homework2;//Programing Exercise 2-2
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class excercise2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int inputa = in.nextInt();
            int inputb = in.nextInt();
            List<value> myList = Arrays.asList(
                    new value(inputa, inputb));
            myList.forEach(s -> System.out.println(gcd(s.a, s.b) + " " + lcm(s.a, s.b)));


        }
    }

        public static int gcd ( int a, int b){
            if (b == 0)
                return a;

            return gcd(b, a % b);
        }

        public static int lcm ( int a, int b)
        {
            return (a * b) / gcd(a, b);
        }

}
class value{
    int a;
    int b;
    value(int a, int b){
        this.a=a;
        this.b=b;
    }
}
