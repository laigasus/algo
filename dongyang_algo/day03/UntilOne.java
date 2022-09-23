package day03;

import java.util.Scanner;

public class UntilOne {

    public static void main(String[] args) {
        int n, k;
        int count = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("n값 입력>");
        n = sc.nextInt();

        System.out.print("나눌 k값 입력>");
        k = sc.nextInt();

        do {
            if (n % k == 0) {
                n /= k;
            } else {
                n--;
            }
            count++;
        } while (n != 1);
        System.out.println(count);
        sc.close();
    }
}
