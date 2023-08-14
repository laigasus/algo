import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2577 {
    public static void main(String[] args) throws IOException {
        final int DIGIT = 10;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        String num = Long.toString(A * B * C);

        int[] nums = new int[DIGIT];
        int len = num.length();
        for (int i = 0; i < len; i++) {
            nums[num.charAt(i) - '0']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < DIGIT; i++) {
            sb.append(nums[i]).append('\n');
        }

        System.out.print(sb);
    }
}