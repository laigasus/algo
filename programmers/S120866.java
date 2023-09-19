
// 안전지대
public class S120866 {
    private class Solution {
        static final int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
        static final int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };

        public static int solution(int[][] board) {
            int len = board.length;
            int answer = 0;

            for (int x = 0; x < len; x++) {
                for (int y = 0; y < len; y++) {
                    if (board[x][y] == 1) {
                        continue;
                    }

                    boolean isSafe = true;
                    for (int i = 0; i < 8; i++) {
                        int nx = x + dx[i];
                        int ny = y + dy[i];

                        if (nx < 0 || ny < 0 || nx >= len || ny >= len) {
                            continue;
                        }

                        if (board[nx][ny] == 1) {
                            isSafe = false;
                            break;
                        }
                    }
                    if (isSafe) {
                        answer++;
                    }
                }
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        System.out.println(Solution.solution(
                new int[][] {
                        { 0, 0, 0, 0, 0 },
                        { 0, 0, 0, 0, 0 },
                        { 0, 0, 0, 0, 0 },
                        { 0, 0, 1, 0, 0 },
                        { 0, 0, 0, 0, 0 }
                }));

        System.out.println(Solution.solution(
                new int[][] {
                        { 0, 0, 0, 0, 0 },
                        { 0, 0, 0, 0, 0 },
                        { 0, 0, 0, 0, 0 },
                        { 0, 0, 1, 1, 0 },
                        { 0, 0, 0, 0, 0 }
                }));

        System.out.println(Solution.solution(
                new int[][] {
                        { 1, 1, 1, 1, 1, 1 },
                        { 1, 1, 1, 1, 1, 1 },
                        { 1, 1, 1, 1, 1, 1 },
                        { 1, 1, 1, 1, 1, 1 },
                        { 1, 1, 1, 1, 1, 1 },
                        { 1, 1, 1, 1, 1, 1 }
                }));
    }
}
