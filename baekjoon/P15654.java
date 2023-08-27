import java.io.IOException;
import java.util.Arrays;

public class P15654 {
    static int N, M;
    static int[] nums, arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        N = readInt();
        M = readInt();

        nums = new int[N];
        arr = new int[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            nums[i] = readInt();
        }
        Arrays.sort(nums);

        dfs(0);

        System.out.print(sb);
    }

    private static void dfs(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            arr[depth] = nums[i];
            dfs(depth + 1);
            visited[i] = false;
        }
    }

    private static int readInt() throws IOException {
        int rs = 0;
        boolean isNegative = false;
        int c = System.in.read();
        while (c <= ' ') {
            c = System.in.read();
        }
        if (c == '-') {
            isNegative = true;
            c = System.in.read();
        }
        while (c >= '0' && c <= '9') {
            rs = rs * 10 + c - '0';
            c = System.in.read();
        }
        return isNegative ? -rs : rs;
    }
}