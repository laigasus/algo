import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.close();
        int min = Integer.MAX_VALUE;
        for (int i = N - String.valueOf(N).length() * 9; i < N; i++) {
            int sum = i;
            for (char c : String.valueOf(i).toCharArray()) {
                sum += c - '0';
            }
            if (sum == N) {
                min = i;
                break;
            }
        }
        System.out.println(min == Integer.MAX_VALUE ? 0 : min);
    }
}
