import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class P25682 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        char[][] wBoard = new char[N][M], bBoard = new char[N][M];
        int[][] wCost = new int[N + 1][M + 1], bCost = new int[N + 1][M + 1];
        
        String str;
        for (int i = 0; i < N; i++) {
            str = br.readLine();
            for (int j = 0; j < M; j++) {
                int cost = 0;
                if ((i + j) % 2 == 0) {
                    wBoard[i][j] = 'W';
                    bBoard[i][j] = 'B';
                } else {
                    wBoard[i][j] = 'B';
                    bBoard[i][j] = 'W';
                }
                cost = needPaint(wBoard[i][j], str.charAt(j));
                wCost[i + 1][j + 1] = wCost[i + 1][j] + wCost[i][j + 1] - wCost[i][j] + cost;
                cost = needPaint(bBoard[i][j], str.charAt(j));
                bCost[i + 1][j + 1] = bCost[i + 1][j] + bCost[i][j + 1] - bCost[i][j] + cost;
            }
        }
        
        int min = Math.min(wCost[K][K], bCost[K][K]);
        for (int i = 0; i <= N - K; i++) {
            for (int j = 0; j <= M - K; j++) {
                min = Collections
                        .min(List.of(min, wCost[i + K][j + K] - wCost[i][j + K] - wCost[i + K][j] + wCost[i][j],
                                bCost[i + K][j + K] - bCost[i][j + K] - bCost[i + K][j] + bCost[i][j]));
            }
        }
        System.out.println(min);
        br.close();
    }

    static int needPaint(char c1, char c2) {
        if (c1 == c2) {
            return 0;
        } else {
            return 1;
        }
    }
}
