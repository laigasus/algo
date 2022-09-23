package day03;

import java.util.Scanner;

public class MulOrAdd {

    // 모든 연산은 왼쪽에서부터 순서대로 이루어짐
    // 02984=>((((0 + 2) x 9) x 8) x 4)
    // 만들어질 수 있는 가장 큰 수는 항상 20억 이하의 정수가 되도록 입력됨
    public static void main(String[] args) {
        String str;
        Scanner sc = new Scanner(System.in);
        System.out.print("숫자열 입력>");
        str = sc.next();
        long rs = str.charAt(0) - '0';

        for (var c : str.split("")) {
            int num = Integer.parseInt(c);
            if (num <= 1 || rs <= 1) {
                rs += num;
            } else {
                rs *= num;
            }
        }
        System.out.printf("결과>%d\n", rs);
        sc.close();
    }
}