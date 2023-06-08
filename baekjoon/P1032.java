import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1032 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        boolean[] skip;
        String[] strs = new String[N];

        strs[0] = br.readLine();
        skip = new boolean[strs[0].length()];

        for (int i = 1; i < N; i++) {
            strs[i] = br.readLine();
            for (int j = 0; j < skip.length; j++) {
                if (skip[j]) {
                    continue;
                }
                if (strs[i - 1].charAt(j) != strs[i].charAt(j)) {
                    skip[j] = true;
                }
            }
        }

        for (int i = 0; i < skip.length; i++) {
            if (skip[i]) {
                sb.append("?");
            } else {
                sb.append(strs[0].charAt(i));
            }
        }

        System.out.println(sb);
    }
}