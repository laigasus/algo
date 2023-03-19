import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P17103 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int[] arr = new int[T];

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < T; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        boolean[] isPrimeArr = new boolean[max + 1];

        for (int i = 1; i < isPrimeArr.length; i++) {
            isPrimeArr[i] = isPrimeNumber(i);
        }

        for (int i = 0; i < T; i++) {
            int cnt = 0;
            int N = arr[i];
            for (int j = N - 1; j >= N / 2; j--) {
                if (isPrimeArr[j]) {
                    cnt = isPrimeArr[N - j] ? cnt + 1 : cnt;
                }
            }
            sb.append(cnt).append('\n');
        }

        System.out.print(sb);
    }

    static boolean isPrimeNumber(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i <= (int) Math.sqrt(n); ++i) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
