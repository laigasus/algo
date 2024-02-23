import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class P2023 {
    static StringBuilder sb = new StringBuilder();
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        DFS(2, 1);
        DFS(3, 1);
        DFS(5, 1);
        DFS(7, 1);

        System.out.print(sb);
    }

    private static void DFS(int num, int depth) {
        if (depth == N) {
            if (isPrime(num)) {
                sb.append(num).append('\n');
            }
            return;
        }

        for (int i = 1; i < 10; i++) {
            if (isPrime(num * 10 + i)) {
                DFS(num * 10 + i, depth + 1);
            }
        }
    }

    private static boolean isPrime(int num) {
        return BigInteger.valueOf(num).isProbablePrime(10);
    }

}
