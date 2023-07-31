import java.io.IOException;
import java.util.Arrays;

public class P14501 {
    static int[] dp;
    static int N;
    static int max = 0;
    static Task[] tasks;

    static class Task {
        static int date = 0;
        int cost, earn;

        public Task(int cost, int earn) {
            date++;
            this.cost = cost;
            this.earn = earn;
        }
    }

    public static void main(String[] args) throws IOException {
        N = readInt();
        dp = new int[N + 1];
        tasks = new Task[N + 1];
        tasks[0] = null;

        for (int i = 1; i <= N; i++) {
            int time = readInt(), earn = readInt();
            tasks[i] = new Task(time, earn);
        }

        calc(1);

        System.out.println(max);
    }

    static void calc(int start) {
        if (start > N) {
            return;
        }

        for (int date = start; date <= N; date++) {
            int endDate = date + tasks[date].cost - 1;
            if (endDate <= N) {
                final int before = dp[endDate];
                Arrays.fill(dp, endDate, dp.length, before + tasks[date].earn);
                calc(endDate + 1);
                max = Math.max(dp[N], max);
                Arrays.fill(dp, endDate, dp.length, before);
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