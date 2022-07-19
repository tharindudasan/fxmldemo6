import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class ArrayListDemotwo {

    public static void main(String[] args) {
        ArrayList<Integer> number1 = new ArrayList<>();
        number1.add(50);
        number1.add(20);
        number1.add(60);
        number1.add(70);

        ArrayList<Integer> number2 = new ArrayList<>();
        number2.add(25);
        number2.add(90);
        number2.add(10);
        number2.add(30);

        System.out.println(number1);
        number1.addAll(number2);
        //Arrays short
        Collections.sort(number1);
        System.out.println(number1);
        //Arrays Binary Search
        int i=Collections.binarySearch(number1,20);
        System.out.println(i);


        // array convert to arrayList
        // int[] numbers={25,40,5};
        ArrayList<Integer> numbers = (ArrayList<Integer>) Arrays.asList(25, 40, 50);

    }
}
