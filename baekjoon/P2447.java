import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P2447 {
    static char[][] canvas;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.close();

        canvas = new char[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(canvas[i], ' ');
        }

        print(N, 0, 0);

        for (int i = 0; i < N; i++) {
            sb.append(canvas[i]).append('\n');
        }
        System.out.print(sb);
    }

    static void print(int N, int x, int y) {

        if (N == 1) {
            canvas[y][x] = '*';
            return;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!(i == 1 && j == 1)) {
                    print(N / 3, x + i * (N / 3), y + j * (N / 3));
                }
            }
        }
    }
}
