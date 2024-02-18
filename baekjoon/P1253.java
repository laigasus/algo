import java.io.IOException;
import java.util.Arrays;

public class P1253 {
    public static void main(String[] args) throws IOException {
        final int N = readInt();
        int[] nums = new int[N];

        int result = 0;

        for (int i = 0; i < N; i++) {
            nums[i] = readInt();
        }

        Arrays.sort(nums);

        for (int i = 0; i < N; i++) {
            if (isGood(nums, i)) {
                result++;
            }
        }

        System.out.println(result);
    }

    private static boolean isGood(int[] nums, final int idx) {
        final int target = nums[idx];

        int left = 0, right = nums.length - 1;

        while (left < right) {
            if (idx == left) {
                left++;
                continue;
            } else if (idx == right) {
                right--;
                continue;
            }

            int sum = nums[left] + nums[right];
            switch (Integer.compare(sum, target)) {
                case -1:
                    left++;
                    break;
                case 0:
                    return true;
                case 1:
                    right--;
            }
        }

        return false;
    }

    private static int readInt() throws IOException {
        int rs = 0;
        boolean isNegative = false;
        int c = System.in.read();
        while (c <= ' ') {
            c = System.in.read();
        }
        if (c == '-') {
            isNegative = true;
            c = System.in.read();
        }
        while (c >= '0' && c <= '9') {
            rs = rs * 10 + c - '0';
            c = System.in.read();
        }
        return isNegative ? -rs : rs;
    }
}