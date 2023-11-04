import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class P3190 {
    static final int[] dx = { 1, 0, -1, 0 };
    static final int[] dy = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        int N = readInt();
        int[][] board = new int[N][N];
        LinkedList<int[]> snake = new LinkedList<>();

        int K = readInt();

        while (K-- > 0) {
            board[readInt() - 1][readInt() - 1] = 2;
        }

        int L = readInt();

        Map<Integer, Character> changePoint = new HashMap<>();

        while (L-- > 0) {
            changePoint.put(readInt(), readChar());
        }

        int time = 0, dir = 0;
        snake.offer(new int[] { 0, 0 });
        board[0][0] = 1;

        while (true) {
            if (changePoint.containsKey(time)) {
                dir = turn(dir, changePoint.get(time));
            }

            int[] now = snake.peekFirst();
            int nx = now[1] + dx[dir];
            int ny = now[0] + dy[dir];

            if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                break;
            }

            if (board[ny][nx] == 1) {
                break;
            }

            if (board[ny][nx] != 2) {
                int[] tmp = snake.pollLast();
                board[tmp[0]][tmp[1]] = 0;
            }

            snake.offerFirst(new int[] { ny, nx });
            board[ny][nx] = 1;
            time++;
        }

        System.out.println(time + 1);

    }

    private static int turn(int dir, char c) {
        return ((c == 'L') ? (dir + 3) : (dir + 1)) % 4;
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

    private static char readChar() throws IOException {
        int c = System.in.read();
        while (c <= ' ') {
            c = System.in.read();
        }
        return (char) c;
    }

}
