
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

class S2817 {
    static StringBuilder sb = new StringBuilder();
    static int N, K;
    static int cnt;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            K = sc.nextInt();
            cnt = 0;
            arr = new int[N];

            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }

            dfs(0, 0);

            sb.append(String.format("#%d %d\n", test_case, cnt));
        }

        System.out.println(sb);
    }

    private static void dfs(int sum, int idx) {
        if (sum > K) {
            return;
        }
        
        if (sum == K) {
            cnt++;
            return;
        }

        for (int i = idx; i < N; i++) {
            dfs(sum + arr[i], i + 1);
        }
    }

}