import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class P2578 {
    private static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static final int SIZE = 5;
    static int[][] board = new int[SIZE][SIZE];
    static boolean[][] isCalled = new boolean[SIZE][SIZE];
    static HashMap<Integer, Point> map = new HashMap<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < SIZE; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < SIZE; j++) {
                int num = Integer.parseInt(st.nextToken());
                map.put(num, new Point(j, i));
            }
        }

        for (int i = 0; i < SIZE; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < SIZE; j++) {
                int num = Integer.parseInt(st.nextToken());
                board[i][j] = num;
            }
        }

        int result = 0;
        int bingo = 0;

        loop: for (int i = 0; i < SIZE; i++) {
            for (var num : board[i]) {
                result++;

                if (map.containsKey(num)) {
                    Point point = map.get(num);
                    isCalled[point.y][point.x] = true;
                }

                bingo = countVertical() + countHorizontal() + countDiagonal() + countDiagonalReverse();

                if (bingo >= 3) {
                    break loop;
                }
            }
        }

        System.out.println(result);
    }

    private static int countVertical() {
        int cnt = 0;
        for (int j = 0; j < SIZE; j++) {
            int tmp = 0;
            for (int i = 0; i < SIZE; i++) {
                if (isCalled[i][j]) {
                    tmp++;
                }
            }

            if (tmp == SIZE) {
                cnt++;
            }
        }
        return cnt;
    }

    private static int countHorizontal() {
        int cnt = 0;
        for (int i = 0; i < SIZE; i++) {
            int tmp = 0;
            for (int j = 0; j < SIZE; j++) {
                if (isCalled[i][j]) {
                    tmp++;
                }
            }

            if (tmp == SIZE) {
                cnt++;
            }
        }
        return cnt;
    }

    private static int countDiagonal() {
        int tmp = 0;
        for (int i = 0; i < SIZE; i++) {
            if (isCalled[i][i]) {
                tmp++;
            }
        }
        return tmp == SIZE ? 1 : 0;
    }

    private static int countDiagonalReverse() {
        int tmp = 0;
        for (int i = 0; i < SIZE; i++) {
            if (isCalled[i][SIZE - 1 - i]) {
                tmp++;
            }
        }
        return tmp == SIZE ? 1 : 0;
    }
}
