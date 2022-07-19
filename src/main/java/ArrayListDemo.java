import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListDemo {
    public static void main(String[] args) {
        /*
        Cchar->Character
        boolean -> Boolean
        short -> Short
        int ->Integer
        long->Long
        double ->Double
        float ->Float
         */

//        long y=20;
//       // Long k=10;
//        Long k=Long.valueOf(20);


        // int[] numbers=new int[]{10,20,30,40,50};
        //int[] number={10,20,30,40,50}; //array iniatializer syntax
//        int[] numbers=new int[5];
//        numbers[0]=10;
//        numbers[1]=10;
//        numbers[2]=10;
//        numbers[3]=10;
//        numbers[4]=10;
        int[] numbers1 = new int[5];
        numbers1[0] = 10;
        numbers1[1] = 20;
        numbers1[2] = 30;
        numbers1[3] = 40;
        numbers1[4] = 50;
        ArrayList<Integer> numbers2 = new ArrayList<>();
        numbers2.add(10);
        numbers2.add(20);
        numbers2.add(30);
        numbers2.add(40);
        numbers2.add(50);

        for (int i = 0; i < numbers1.length; i++) {
            System.out.println(numbers1[i]);

        }
        System.out.println("--------------");
        for (int i : numbers1) {
            System.out.println(i);

        }
        System.out.println("--------------");
        for (int i = 0; i < numbers2.size(); i++) {
            System.out.println(numbers2.get(i));

        }
        System.out.println("--------------");
        for (Integer i : numbers2) {
            System.out.println(i);

        }
        System.out.println(Arrays.toString(numbers1));
        numbers1[1] = 15;
        System.out.println(numbers2);
        numbers2.set(1, 15);//
        numbers2.add(65);//append(tail)
        System.out.println(numbers2);//[10, 15, 30, 40, 50, 65]
        numbers2.add(2, 25);//[10, 15, , 30, 40, 50, 65]
        System.out.println(numbers2);//[10, 15, 25, 30, 40, 50, 65]
        numbers2.remove(6);
        System.out.println(numbers2);

        //line by line print
        for (int i = 0; i < numbers2.size(); i++) {
            System.out.println(numbers2.get(i));
        }
        System.out.println("------------");
        for (Integer integer : numbers2) {
            System.out.println(integer);

        }
        System.out.println("------------");
        System.out.println("Scope Resoultion");
        numbers2.forEach(System.out::println);//scope resultion ,in java method reffernces

        //check  contains
        System.out.println(numbers2.contains(15));

        numbers2.clear();
        System.out.println(numbers2);


    }
}
