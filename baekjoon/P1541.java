import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(chg(br.readLine()));
    }

    static int chg(String str) {
        char[] op = str.replaceAll("[0-9]", "").toCharArray();
        int[] nums = Arrays.stream(str.replaceAll("[^0-9]", " ").split(" ")).mapToInt(Integer::parseInt).toArray();
        int idx = -1;

        for (int i = 0; i < op.length; i++) {
            if (op[i] == '-') {
                idx = i;
                break;
            }
        }

        if (idx != -1) {
            Arrays.fill(op, idx, op.length, '-');
        }

        int rs = nums[0] >= 0 ? nums[0] : -nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (op[i - 1] == '+') {
                rs += nums[i];
            } else {
                rs -= nums[i];
            }
        }
        return rs;
    }
}
