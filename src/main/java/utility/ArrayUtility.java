package utility;

import java.util.Random;


public class ArrayUtility {

    static Random random = new Random();
    public static void fillRandoms(int [] input){
        for ( int i =0; i < input.length; i++){
            input[i] = random.nextInt(500);
        }
    }

    public static  void printArray(int []array, String msg){
        System.out.println("\n ====== "+ msg+ " ==========");
        for ( int i = 0; i< array.length ; i++){
            System.out.print(array[i]+", ");
        }
    }
}
