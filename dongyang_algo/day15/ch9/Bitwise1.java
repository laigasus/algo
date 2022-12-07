package day15.ch9;

public class Bitwise1 {
    public static String solution(int n) {
        if ((n&1)==1) {
            return "Odd";
        } else {
            return "Even";
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(11));
    }
}
