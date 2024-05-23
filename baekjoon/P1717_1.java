import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class P1717_1 {
    static int[] parents;
    static int N, M;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        parents = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            parents[i] = i;
        }

        StringBuilder sb = new StringBuilder();
        while (M-- > 0) {
            int cmd = sc.nextInt();

            int a = sc.nextInt();
            int b = sc.nextInt();

            switch (cmd) {
                case 0:
                    union(a, b);
                    break;
                case 1:
                    sb.append(isIncluded(a, b) ? "YES" : "NO").append('\n');
                    break;
                default:
                    throw new IllegalArgumentException("들어올 수 없는 값");
            }
        }

        System.out.print(sb);
    }

    private static boolean isIncluded(int a, int b) {
        return find(a) == find(b);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            parents[b] = a;
        }
    }

    private static int find(int x) {
        if (x == parents[x]) {
            return x;
        }

        return parents[x] = find(parents[x]);
    }

}