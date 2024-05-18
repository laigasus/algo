import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = 10;

        for (int test_case = 1; test_case <= T; test_case++) {
            sc.nextInt();

            int N = sc.nextInt();

            int M = sc.nextInt();

            int result = recursive(N, N, M);

            System.out.println(String.format("#%d %d", test_case, result));
        }
    }

    private static int recursive(int start, int num, int depth) {
        if (depth == 1) {
            return num;
        }
        return recursive(start, num * start, depth - 1);
    }
}