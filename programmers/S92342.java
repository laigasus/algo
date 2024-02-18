import java.util.Arrays;
import java.util.StringJoiner;
import java.util.stream.IntStream;

public class S92342 {
    static class Solution {
        static int max = Integer.MIN_VALUE;
        static int MAX_SCORE = 10;
        static int[] apeach;
        static int[] result;
        static int arrows;

        public static int[] solution(int n, int info[]) {
            int[] ryan = new int[MAX_SCORE + 1];
            result = new int[] { -1 };

            apeach = info.clone();
            arrows = n;

            calc(ryan, 0);

            return result;
        }

        public static void calc(int[] ryan, int depth) {
            if (depth == arrows) {
                int ryanScore = 0;
                int apeachScore = 0;
                for (int i = 0; i < 10; i++) {
                    int point = 10 - i;

                    int ryanArrows = ryan[i];
                    int apeachArrows = apeach[i];

                    if (ryanArrows > apeachArrows && ryanArrows > 0) {
                        ryanScore += point;
                    } else if (apeachArrows >= ryanArrows && apeachArrows > 0) {
                        apeachScore += point;
                    } else {
                        continue;
                    }
                }

                int diff = ryanScore - apeachScore;

                if (diff > 0 && diff >= max) {
                    max = diff;
                    result = ryan.clone();
                }

                return;
            }

            for (int i = 0; i < apeach.length && ryan[i] <= apeach[i]; i++) {
                ryan[i]++;
                calc(ryan, depth + 1);
                ryan[i]--;
            }

        }
    }

    public static void main(String[] args) {
        StringJoiner sj = new StringJoiner("\n");
        sj.add(Arrays.toString(Solution.solution(5, IntStream.of(2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0).toArray())));
        sj.add(Arrays.toString(Solution.solution(1, IntStream.of(1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0).toArray())));
        sj.add(Arrays.toString(Solution.solution(9, IntStream.of(0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1).toArray())));
        sj.add(Arrays.toString(Solution.solution(10, IntStream.of(0, 0, 0, 0, 0, 0, 0, 0, 3, 4, 3).toArray())));

        System.out.print(sj);
    }
}
