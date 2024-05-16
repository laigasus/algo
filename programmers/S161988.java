class S161988 {
    public long solution(int[] sequence) {
        long[] dp = new long[sequence.length + 1];

        for (int i = 1; i <= sequence.length; i++) {
            dp[i] = dp[i - 1] + sequence[i - 1] * (i % 2 == 0 ? 1 : -1);
        }

        long answer = 0;
        int left = 0, right = 0;

        while (right <= sequence.length) {
            answer = Math.max(answer, Math.abs(dp[right] - dp[left]));

            if (dp[right] - dp[left] < 0) left = right;
            right++;
        }

        return answer;
    }
}