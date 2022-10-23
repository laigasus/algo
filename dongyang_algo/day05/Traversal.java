package day05;

import java.util.Scanner;

public class Traversal {
    static int[] dx = { 0, -1, 0, 1 };
    static int[] dy = { 1, 0, -1, 0 };
    static Integer x = 1, y = 1;
    static int range;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("거리 입력>");

        range = sc.nextInt();
        System.out.println("좌표입력");
        var move = sc.next().split(" ");

        for (var c : move) {
            changeLocation(c);
        }

        System.out.printf("현 좌표>(%d, %d)", x, y);

        sc.close();
    }

    static void changeLocation(String c) {
        boolean flag = (x == 0 || y == 0 || x == range || y == range) ? true : false;

        switch (c) {
            default:
                if (flag)
                    break;
            case "L":
                x--;
                break;
            case "R":
                x++;
                break;
            case "U":
                y--;
                break;
            case "D":
                y++;
                break;
        }
    }
}
