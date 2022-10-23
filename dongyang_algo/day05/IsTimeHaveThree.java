package day05;

import java.util.Scanner;

public class IsTimeHaveThree {
    final static int MINUTE = 60, SECOND = 60;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int hour = sc.nextInt();
        int cnt = 0;

        for (int h = 0; h <= hour; h++) {
            for (int m = 0; m < MINUTE; m++) {
                for (int s = 0; s < SECOND; s++) {
                    if (("" + h + m + s).contains("3")) {
                        cnt++;
                    }
                }
            }
        }

        System.out.println("총 개수>" + cnt);
        sc.close();
    }
}
