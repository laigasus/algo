import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2485 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] trees = new int[N];
        int[] diff = new int[N - 1];
        int minDiff = Integer.MAX_VALUE;

        trees[0] = Integer.parseInt(br.readLine());

        for (int i = 1; i < N; i++) {
            trees[i] = Integer.parseInt(br.readLine());
            diff[i - 1] = trees[i] - trees[i - 1];
        }

        minDiff = diff[0];
        for (int i = 1; i < diff.length; i++) {
            minDiff = GCD(minDiff, diff[i]);
        }

        int first = trees[0], last = trees[N - 1];
        int total = ((last - first) / minDiff + 1) - N;

        System.out.println(total);
    }

    static int GCD(int a, int b) {
        while (b > 0) {
            int tmp = a;
            a = b;
            b = tmp % b;
        }
        return a;
    }
}
