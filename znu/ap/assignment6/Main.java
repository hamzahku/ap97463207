package assignment6;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);
        Random random = new Random();
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();

        System.out.println("Enter the random bound ");
        int x = input.nextInt();
        int a = random.nextInt(x);
        int b = random.nextInt(a);
        System.out.println("Number of rows = "+b);
        for (int i = 0; i < b; i++) {
            List<Integer> row = new ArrayList<Integer>();
            int c = random.nextInt(a);
            for (int j = 0; j < c ; j++) {
                row.add(random.nextInt(a));
            }
            matrix.add((ArrayList<Integer>) row);
            System.out.println(" size of row "+(i+1)+" = "+c+"   " +row);
        }

        System.out.println("all array two-dimensional  "+matrix);



    }
}
