package assignment4;

import java.util.Scanner;
import java.util.Random;
public class Main {

    public static void main(String[] args) {


        Random r = new Random();
        int x,y,a ,b;
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the length of the lines\n");
        x=s.nextInt();
        System.out.print("Enter the length of the columns\n");
        y=s.nextInt();
        int[][] M = new int[x][y];
       // int[][] G = new int[x][y];
        int temp,temp2;


        for ( int i=0 ; i<x ; i++){
            for(int j=0;j<y;j++){
                M[i][j] = r.nextInt(100) + 1;
                System.out.print(M[i][j]);
                System.out.print("  ");
            }
            System.out.print("\n");
        }
        System.out.print("************************\n");
        System.out.print("\n Enter one to switch between the columns  \n");
        a=s.nextInt();

             for (int i = 0; i <= x - 1; i++) {
                 for (int j = 0; j <= y - 1; j++) {
                     if (j % 2 == 0) {
                         temp = M[i][j];
                         M[i][j] = M[i][j + 1];
                         M[i][j + 1] = temp;
                     }
                     System.out.print(M[i][j]);

                     System.out.print("  ");
                 }
                 System.out.print("\n");
             }
             System.out.print("************************\n");

        System.out.print("\n Enter  zero to switch between the lines \n");
        b=s.nextInt();
             for (int i = 0; i <= x - 1; i++) {
                 int w = i + 1;
                 if (i == x - 1)
                     w = 0;
                 for (int j = 0; j <= y - 1; j++) {

                     System.out.print(M[w][j]);
                     System.out.print("  ");
                 }
                 System.out.print("\n");
             }
             System.out.print("************************\n");

    }
}