
import java.util.Scanner;

class S2005 {
    static int[][] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            sb.append("#" + test_case + "\n");
            int n = sc.nextInt();
            arr = new int[n][n];
            init(n);
            insert(n);
            print(n);
        }

        System.out.println(sb);
    }

    private static void init(int n) {
        for (int i = 0; i < n; i++) {
            arr[i][i] = 1;
            arr[i][0] = 1;
        }
    }

    private static void insert(int n) {
        for (int i = 2; i < n; i++) {
            for (int j = 1; j < i; j++) {
                int left = arr[i - 1][j - 1];
                int right = arr[i - 1][j];
                arr[i][j] = left + right;
            }
        }
    }

    private static void print(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                sb.append(arr[i][j]).append(' ');
            }
            sb.append('\n');
        }
    }

}