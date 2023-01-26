import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int[] nums = new int[10000000];
        int max = Integer.MIN_VALUE;

        for (int i = 1; i <= T; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n > max) {
                max = n;
            }
            nums[n]++;
        }
        br.close();

        for (int idx = 1; (idx <= max); idx++) {
            for (int j = 1; j <= nums[idx]; j++) {
                sb.append(idx).append("\n");
            }
        }
        System.out.print(sb);
    }
}
