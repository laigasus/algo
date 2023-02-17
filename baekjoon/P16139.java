import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P16139 {
    final static int Alphabets = 26;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String S = br.readLine();

        int[][] dp = new int[Alphabets][S.length()];
        int q = Integer.parseInt(br.readLine());

        // init
        for (int i = 0; i < Alphabets; i++) {
            for (int strIdx = 0; strIdx < S.length(); strIdx++) {
                char c = S.charAt(strIdx);
                dp[c - 97][strIdx] = 1;
            }
        }

        // ignition
        for (int i = 0; i < Alphabets; i++) {
            for (int j = 1; j < S.length(); j++) {
                dp[i][j] += dp[i][j - 1];
            }
        }

        // frequency calc
        for (int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char c = st.nextToken().charAt(0);
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            int freq;
            if (l == 0) {
                freq = dp[c - 97][r];
            } else {
                freq = dp[c - 97][r] - dp[c - 97][l - 1];
            }
            sb.append(freq).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}
