import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P21317 {
    private static int[] dp;
    private static Node[] nodes;

    private static int k;
    private static int N;

    private static class Node {
        int s, m;

        public Node(int s, int m) {
            this.s = s;
            this.m = m;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()) - 1;
        nodes = new Node[N];
        dp = new int[N + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            nodes[i] = new Node(s, m);
        }

        k = Integer.parseInt(br.readLine());

        jump(0, false, 0);

        System.out.println(dp[N]);
    }

    private static void jump(int idx, boolean isUsedLJump, int energy) {
        if (idx > N) {
            return;
        } else if (idx == N) {
            dp[idx] = Math.min(dp[idx], energy);
            return;
        }

        jump(idx + 1, isUsedLJump, energy + nodes[idx].s);
        jump(idx + 2, isUsedLJump, energy + nodes[idx].m);

        if (!isUsedLJump) {
            jump(idx + 3, true, energy + k);
        }
    }
}