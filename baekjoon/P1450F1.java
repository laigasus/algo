import java.io.IOException;

public class P1450F1 {
    static int N, C;
    static int[] stuffs;
    static long[] dp;

    public static void main(String[] args) throws IOException {
        N = readInt();
        C = readInt();

        stuffs = new int[N];
        int totalWeight = 0;
        for (int i = 0; i < N; i++) {
            stuffs[i] = readInt();
            totalWeight += stuffs[i];
        }

        dp = new long[totalWeight + 1]; // dp 배열의 크기를 물건들의 무게 합으로 제한
        dp[0] = 1; // 무게가 0인 경우는 항상 가능하므로 1로 초기화
        for (int stuff : stuffs) {// 각 물건에 대해
            for (int w = totalWeight; w >= stuff; w--) {// 물건들의 무게 합에서 그 물건의 무게까지 역순으로 반복
                dp[w] += dp[w - stuff]; // 해당 무게의 경우의 수를 가져옴
            }
        }

        long cnt = 0;// 전체 경우의 수
        for (int i = 0; i <= Math.min(totalWeight, C); i++) {// 용량 C와 물건들의 무게 합 중 작은 것까지만 반복
            cnt += dp[i]; // 가능한 경우의 수를 cnt에 더함
        }

        System.out.println(cnt);
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
