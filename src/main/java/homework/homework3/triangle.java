
import javax.swing.plaf.DesktopIconUI;
import java.util.*;
import java.util.Deque;
import java.util.stream.Collectors;

public class triangle {
    public static void main(String[] args){
        Scanner input = new Scanner((System.in));
        while(input.hasNextInt()){
            int n=input.nextInt();
            System.out.println("N = "+n);
            ArrayDeque<Integer>s= new ArrayDeque<>();
            s.add(1);

            c(s,0,n);
        }
    }
    public static void c(ArrayDeque<Integer>myList,int start,int end){
        List<Character> blankLine = Collections.nCopies(end-start, ' ');
        blankLine.forEach(s->System.out.print(s));
        myList.forEach(s->System.out.print(s+" "));
        System.out.println();
        if(start<end) {
            myList=addElement(myList);
            c(myList,start+1,end);
        }

    }



    public static ArrayDeque<Integer> addElement(ArrayDeque<Integer>a){

        ArrayDeque <Integer>L1=a.clone();
        ArrayDeque <Integer>L2=a.clone();

        L1.addFirst(0);
        L1.addLast(0);
        int count=0;
        ArrayDeque <Integer>output=L1.stream()
                .map(s->s+L1.remove()
                )
                .collect(Collectors
                        .toCollection(ArrayDeque::new));
        return output;


    }
}
