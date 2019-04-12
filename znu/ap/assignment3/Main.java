package assignment3;

import java.util.Scanner;
import java.util.Random;
public class Main {

    public static void main(String[] args) {


        Random r = new Random();
        int x ;
        Scanner s = new Scanner(System.in);
        System.out.print("  Enter the length of the array (n) ");
        x=s.nextInt();

        int[][] M = new int[x][x];



        for ( int i=0 ; i<x ; i++){
            for(int j=0;j<x;j++){
                M[i][j] = r.nextInt(100) + 1;
                System.out.print(M[i][j]);
                System.out.print("  ");
            }
            System.out.print("\n");
        }

        System.out.print(" The solution is depicted diagonal from top to bottom  >>>   ");
        for(int k =0;k<=x-1;k++){
            int i=0;
            int j =k;
            while (j>=0) {
                System.out.print(M[i][j]+" ");
                i = i + 1;
                j = j - 1;
            }}
        for (int k =1; k<=x-1;k++){
            int i = k;
            int j =x-1;
            while (i<=x-1) {
                System.out.print(M[i][j]+" ");
                i=i+1;
                j=j-1;
            }
        }


    }
}