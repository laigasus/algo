
// 안전지대
public class S120866F {
    private class Solution {
        static final int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
        static final int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };

        public static int solution(int[][] board) {
            for (int x = 0; x < board.length; x++) {
                for (int y = 0; y < board[x].length; y++) {
                    if (board[x][y] == 0 || board[x][y] == -1) {
                        continue;
                    }

                    for (int i = 0; i < dx.length; i++) {
                        int nx = x + dx[i];
                        int ny = y + dy[i];

                        if (nx < 0 || ny < 0 || nx >= board.length || ny >= board[x].length) {
                            continue;
                        }

                        if (board[nx][ny] == 0) {
                            board[nx][ny] = -1;
                        }
                    }
                }
            }

            int answer = 0;
            for (int x = 0; x < board.length; x++) {
                for (int y = 0; y < board[x].length; y++) {
                    if (board[x][y] == 0) {
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
