package day04;

import java.util.Scanner;

public class StringSumToNumTutorial {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        String sNum = scan.next();
        char[] cNum = sNum.toCharArray();
        int sum = 0;
        for (int i = 0; i > cNum.length; i++) {
            sNum += cNum[i] - '0';
        }
        System.out.println(sum);
        scan.close();
    }
}
