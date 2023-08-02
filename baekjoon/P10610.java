import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P10610 {
    public static void main(String[] args) throws IOException {
        final int NONE = -1;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        int[] nums = new int[10];
        int sum = 0;
        for (int i = 0; i < N.length(); i++) {
            int v = N.charAt(i) - '0';
            sum += v;
            nums[v]++;
        }

        if (nums[0] == 0 || sum % 3 != 0) {
            System.out.println(NONE);
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            sb.append(Integer.toString(i).repeat(nums[i]));
        }

        System.out.println(sb);
    }
}