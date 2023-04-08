import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2720 {
    static int[] coin = { 25, 10, 5, 1 };
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            calc(Integer.parseInt(br.readLine()));
        }

        System.out.print(sb);
    }

    static void calc(int cost) {
        for (int i : coin) {
            sb.append(cost / i).append(' ');
            cost %= i;
        }
        sb.append('\n');
    }
}