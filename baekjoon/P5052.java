import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P5052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] strs = new String[n];

            for (int i = 0; i < n; i++) {
                strs[i] = br.readLine();
            }
            sb.append(calc(strs) ? "YES" : "NO").append('\n');
        }

        System.out.print(sb);
    }

    private static boolean calc(String[] strs) {
        Arrays.sort(strs);

        for (int i = 0; i < strs.length - 1; i++) {
            if (strs[i + 1].startsWith(strs[i])) {
                return false;
            }
        }

        return true;
    }

}
