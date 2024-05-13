import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

class S1959 {
    static int[] A, B;
    static int N, M;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            M = sc.nextInt();

            A = init(sc, N);
            B = init(sc, M);

            int max = 0;
            for (int start = 0; start <= Math.abs(M - N); start++) {
                int result = A.length > B.length ? calcSum(A, B, start) : calcSum(B, A, start);
                max = Math.max(max, result);
            }

            sb.append(String.format("#%d %d\n", test_case, max));
        }

        System.out.println(sb);
    }

    private static int[] init(Scanner sc, int size) {
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        return arr;
    }

    private static int calcSum(int[] big, int[] small, int start) {
        int sum = 0;

        for (int i = start; i < start + small.length; i++) {
            sum += (big[i] * small[i - start]);
        }

        return sum;
    }
}