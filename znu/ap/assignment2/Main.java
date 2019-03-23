package znu.ap.assignment2;

import java.util.Scanner;
public class Main {
    private static System system;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int o , d=1 , p=1 , k ,n =0;
        System.out.print("Enter 3 or 5 or 7 ");
        int x = Integer.parseInt(input.next());
        if (x == 3) {
            n = 2;
        }
        if (x == 5) {
            n = 3;
        }
        if (x == 7) {
            n = 4;
        }
        k = x - n;
        int t = 2 * k + 1;
        for (int b = 0; b <= k; b++) {
            for (int i = 0; i <= k - b; i++)
                system.out.print(" ");
            for (int j = 1; j <= 2 * b + 1; j++)
                system.out.print("*");
            system.out.print("\n");
        }
        for (int b = 0; b <= k - 1; b++) {
            for (int i = 0; i <= b + 1; i++)
                system.out.print(" ");
            o = t - p - d;
            for (int j = 1; j <= o; j++)
                system.out.print("*");
            p++;
            d++;
            system.out.print("\n");
        }
    }
}
