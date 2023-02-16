import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.close();
        System.out.println(calc(N, 0));
    }

    static int calc(int N, int cnt) {
        if (N <= 1) {
            return cnt;
        }
        return Math.min(calc(N / 2, cnt + 1 + (N % 2)), calc(N / 3, cnt + 1 + (N % 3)));
    }
}
