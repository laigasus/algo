import java.io.IOException;

public class P15651 {
    static StringBuilder sb = new StringBuilder();
    static int[] arr;
    static int N, M;

    public static void main(String[] args) throws IOException {
        N = readInt();
        M = readInt();
        arr = new int[M];

        dfs(0);

        System.out.print(sb);
    }

    public static void dfs(int depth) {
        if (depth == M) {
            for (int num : arr) {
                sb.append(num).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = 0; i < N; i++) {
            arr[depth] = i + 1;
            dfs(depth + 1);
        }
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;

        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }

        if (c == 13) {
            System.in.read();
        }

        return n;
    }
}