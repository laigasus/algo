public class S172927 {
    static class Solution {

        static int minVal = Integer.MAX_VALUE;

        public static int solution(int[] picks, String[] minerals) {

            for (int i = 0; i < 3; i++) {
                if (picks[i] != 0) {
                    // 가용한 곡괭이가 있다면 거기서부터 dfs 수행
                    int[] picksClone = picks.clone();
                    picksClone[i] = picksClone[i] - 1;

                    dfs(picksClone, minerals, i, 0, 0);
                }
            }

            return minVal;
        }

        public static void dfs(int[] picks, String[] minerals, int pick, int loc, int sum) {

            // 정산 먼저 : 5개를 캔다.
            // loc(위치) 증가를 위해 i를 밖에 선언.
            int i = 0;
            for (; i < 5; i++) {

                // 범위 초과 에러 방지
                if (loc + i >= minerals.length) {
                    break;
                }

                if (pick == 0) {
                    // 다이아 곡괭이는 뭘 캐든 +1
                    sum += 1;
                } else if (pick == 1) {
                    // 철 곡괭이는 다이아만 +5, 나머지는 +1
                    if ("diamond".equals(minerals[loc + i])) {
                        sum += 5;
                    } else {
                        sum += 1;
                    }
                } else {
                    // 돌 곡괭이는 다이아+25, 철+5, 돌+1
                    if ("diamond".equals(minerals[loc + i])) {
                        sum += 25;
                    } else if ("iron".equals(minerals[loc + i])) {
                        sum += 5;
                    } else {
                        sum += 1;
                    }
                }
            }
            // 위치 증가
            loc = loc + i;

            // 끝까지 갔으면 RETURN
            if (loc >= minerals.length) {
                if (minVal > sum) {
                    minVal = sum;
                }
                return;
            }
            // 더 이상 가용한 곡괭이가 없으면 return
            if (picks[0] == 0 && picks[1] == 0 && picks[2] == 0) {
                if (minVal > sum) {
                    minVal = sum;
                }
                return;
            }
            // 이전에 구한 값보다 크면 return
            if (sum >= minVal) {
                return;
            }

            for (i = 0; i < 3; i++) {
                if (picks[i] != 0) {
                    // 가용한 곡괭이가 남아있다면 재귀
                    int[] picksClone = picks.clone();
                    picksClone[i] = picksClone[i] - 1;

                    dfs(picksClone, minerals, i, loc, sum);

                }
            }
        }

    }

    public static void main(String[] args) {
        int[] picks = { 1, 1, 1 };
        String[] minerals = { "diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron",
                "iron", "diamond", "diamond", "diamond", "diamond", "diamond" };
        System.out.println(Solution.solution(picks, minerals));
    }
}
