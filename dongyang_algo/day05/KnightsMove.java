package day05;

import java.util.Scanner;

public class KnightsMove {
    final static int KNIGHT_DISTANCE = 5;
    final static int CHESS_SIZE = 8;

    public static void main(String[] args) {
        int x, y;
        int cnt = 0;
        double width, height;
        Scanner sc = new Scanner(System.in);
        System.out.print("나이트 좌표 입력>");
        String input = sc.next();
        x = (int) input.charAt(0) - 96;
        y = input.charAt(1) - '0';

        for (double i = 1; i <= CHESS_SIZE; i++) {
            height = y - i;
            for (double j = 1; j <= CHESS_SIZE; j++) {
                width = x - j;
                // 피타고라스 활용
                if (Math.pow(width, 2) + Math.pow(height, 2) == KNIGHT_DISTANCE) {
                    System.out.printf("유효 경로>%c%.0f\n", ((int) j + 96), i);
                    cnt++;
                }
            }
        }
        System.out.println("유효 이동 경우의 수>" + cnt);
        sc.close();
    }
}