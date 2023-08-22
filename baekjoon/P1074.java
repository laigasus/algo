import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1074 {
    static int r, c;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int size = (int) Math.pow(2, N);
        moveLikeZ(size, 0, 0);
        System.out.println(result);
    }

    static void moveLikeZ(int size, int x, int y) {
        if (x == r && y == c) {
            System.out.println(result);
            System.exit(0);
        }

        if (r >= x && r < x + size && c >= y && c < y + size) {
            moveLikeZ(size / 2, x, y);
            moveLikeZ(size / 2, x, y + size / 2);
            moveLikeZ(size / 2, x + size / 2, y);
            moveLikeZ(size / 2, x + size / 2, y + size / 2);
        } else {
            result += size * size;
        }
    }
}