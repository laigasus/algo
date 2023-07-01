import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1063 {
    enum Move {
        R(1, 0), L(-1, 0), B(0, -1), T(0, 1),
        RT(1, 1), LT(-1, 1), RB(1, -1), LB(-1, -1);

        int x, y;

        Move(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    final static int BD_SIZE = 8;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        Point king = init(st.nextToken());
        Point stone = init(st.nextToken());

        int N = Integer.parseInt(st.nextToken());

        while (N-- > 0) {
            Move move = Move.valueOf(br.readLine());
            int nx = king.x + move.x;
            int ny = king.y + move.y;

            if (nx == stone.x && ny == stone.y) {
                if (isInside(stone.x + move.x, stone.y + move.y)) {
                    stone.x += move.x;
                    stone.y += move.y;
                } else {
                    continue;
                }
            }

            if (isInside(nx, ny)) {
                king.x = nx;
                king.y = ny;
            }
        }

        sb.append((char) (king.x + 64)).append(king.y).append('\n');
        sb.append((char) (stone.x + 64)).append(stone.y).append('\n');

        System.out.print(sb);
    }

    static Point init(String s) throws IOException {
        return new Point(s.charAt(0) - 64, s.charAt(1) - '0');
    }

    static boolean isInside(int x, int y) {
        if (x < 1 || y < 1 || x > BD_SIZE || y > BD_SIZE) {
            return false;
        }
        return true;
    }
}