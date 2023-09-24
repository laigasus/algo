import java.util.Stack;

//13분
public class S64061 {

    static class Solution {
        public static int solution(int[][] board, int[] moves) {
            int answer = 0;
            Stack<Integer> stack = new Stack<>();

            for (int move : moves) {
                crane: for (int y = 0; y < board.length; y++) {
                    int value = board[y][move - 1];

                    if (value != 0) {
                        board[y][move - 1] = 0;

                        if (!stack.isEmpty() && stack.peek() == value) {
                            stack.pop();
                            answer += 2;
                        } else {
                            stack.push(value);
                        }

                        break crane;
                    }
                }
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        System.out.println(Solution.solution(new int[][] {
                { 0, 0, 0, 0, 0 },
                { 0, 0, 1, 0, 3 },
                { 0, 2, 5, 0, 1 },
                { 4, 2, 4, 4, 2 },
                { 3, 5, 1, 3, 1 }
        }, new int[] { 1, 5, 3, 5, 1, 2, 1, 4 }));
    }
}
