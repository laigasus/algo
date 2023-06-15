class S178870 {
    static class Solution {
        public static int[] solution(int[] sequence, int k) {
            int[] dp = new int[sequence.length + 1];
            int[] answer = new int[2];

            for (int i = 1; i < dp.length; i++) {
                dp[i] = dp[i - 1] + sequence[i - 1];
                if (sequence[i - 1] == k) {
                    answer[0] = answer[1] = i - 1;
                    return answer;
                }
            }

            int l = 0, r = 0, len = dp.length;
            while (r < dp.length) {
                int sum = dp[r] - dp[l];
                if (sum < k) {
                    r++;
                } else if (sum > k) {
                    l++;
                } else {
                    if (r - l < len) {
                        len = r - l;
                        answer[0] = l;
                        answer[1] = r - 1;
                    }
                    r++;
                }
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        int[] sequence = { 1, 1, 1, 2, 3, 4, 5 };
        int[] answer = Solution.solution(sequence, 5);
        System.out.printf("[%d,%d]\n", answer[0], answer[1]);
    }
}