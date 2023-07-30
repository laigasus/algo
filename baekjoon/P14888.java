import java.io.IOException;

public class P14888 {
    static int[] nums;
    static int N;
    static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    static int[] op = new int[4];

    public static void main(String[] args) throws IOException {
        N = readInt();
        nums = new int[N];

        for (int i = 0; i < N; i++) {
            nums[i] = readInt();
        }

        for (int i = 0; i < 4; i++) {
            op[i] = readInt();
        }

        dfs(nums[0], 1);

        System.out.println(max);
        System.out.println(min);
    }

    public static void dfs(int num, int idx) {
        if (idx == N) {
            max = Math.max(max, num);
            min = Math.min(min, num);
            return;
        }

        for (int i = 0; i < op.length; i++) {
            if (op[i] > 0) {
                op[i]--;

                switch (i) {
                    case 0:// +
                        dfs(num + nums[idx], idx + 1);
                        break;
                    case 1:// -
                        dfs(num - nums[idx], idx + 1);
                        break;
                    case 2:// *
                        dfs(num * nums[idx], idx + 1);
                        break;
                    case 3:// /
                        dfs(num / nums[idx], idx + 1);
                        break;
                }
                op[i]++;
            }
        }
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
