import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

class P2096 {
    static final int WIDTH = 3;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] big = new int[N + 2][WIDTH + 2];
        int[][] small = new int[N + 2][WIDTH + 2];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= WIDTH; j++) {
                int num = Integer.parseInt(st.nextToken());
                big[i][j] = num;
                small[i][j] = num;
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= WIDTH; j++) {
                big[i][j] += Collections.max(Arrays.asList(big[i - 1][j - 1 < 1 ? j : j - 1], big[i - 1][j],
                        big[i - 1][j + 1 > WIDTH ? WIDTH : j + 1]));
                small[i][j] += Collections.min(Arrays.asList(small[i - 1][j - 1 < 1 ? j : j - 1], small[i - 1][j],
                        small[i - 1][j + 1 > WIDTH ? WIDTH : j + 1]));
            }
        }

        int max = 0;
        int min = 9 * N;
        for (int j = 1; j <= WIDTH; j++) {
            max = Math.max(max, big[N][j]);
            min = Math.min(min, small[N][j]);
        }

        System.out.println(max + " " + min);
    }
}