public class S181187 {
    static class Solution {
        public static long solution(int r1, int r2) {
            long answer = 0;

            for (long r = 1; r <= r2; r++) {
                int s = (int) Math.ceil(Math.sqrt(r1 * r1 - r * r));
                int e = (int) Math.floor(Math.sqrt(r2 * r2 - r * r));

                answer += e - s + 1;
            }

            return answer * 4;
        }
    }

    public static void main(String[] args) {
        System.out.println(Solution.solution(2, 3));
    }
}