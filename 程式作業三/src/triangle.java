
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

            List<ArrayDeque<Integer>> inventory = Arrays.asList();
            inventory.add(s);

            c(inventory,0,n);


        }
    }
    public static void c(List<ArrayDeque<Integer>>myList,int start,int end){

                    System.out.println(myList);
        if(start<=end) {
            myList.stream().map(s -> addElement(s))
                    .collect(Collectors.toCollection(ArrayDeque::new));
            c(myList,start+1,end);
        }

    }



    public static ArrayDeque<Integer> addElement(ArrayDeque<Integer>a){

        ArrayDeque L1=a.clone();
        ArrayDeque L2=a.clone();
        ArrayDeque output = new ArrayDeque(L1.size());
        L1.addFirst(0);
        L2.addLast(0);

        output.forEach(s-> {
            int i=(int)L1.remove()+(int)L2.remove();
            output.add(i);
        });
        return output;


    }
}
