package day04;

import java.util.Scanner;

public class StringSumToNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("문자열 입력>");
        String str = sc.next();

        int numSum = str.chars().sum();

        System.out.println("합산>" + numSum);
        sc.close();
    }
}
