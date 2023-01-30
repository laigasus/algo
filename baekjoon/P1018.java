import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1018 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String[] canvas;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());// 세로
        int M = Integer.parseInt(st.nextToken());// 가로
        int min = Integer.MAX_VALUE;
        init(N);
        br.close();

        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                char[][] boardB = new char[8][8], boardW = new char[8][8];
                for (int k = 0; k < 8; k++) {
                    boardB[k] = canvas[i + k].substring(j, j + 8).toCharArray();
                    boardW[k] = canvas[i + k].substring(j, j + 8).toCharArray();
                }
                int B = repaint(boardB, 'B');
                int W = repaint(boardW, 'W');
                int compareBW = Math.min(B, W);

                min = Math.min(min, compareBW);
            }
        }
        System.out.println(min);

    }

    static void init(int N) throws IOException {
        canvas = new String[N];
        for (int i = 0; i < canvas.length; i++) {
            canvas[i] = br.readLine();
        }
    }

    static int repaint(char[][] board, char start) throws IOException {
        int cnt = 0;
        if (start != board[0][0]) {
            board[0][0] = swap(board[0][0]);
            cnt++;
        }
        for (int i = 0; i < board.length; i++) {
            char[] s = board[i];
            if (i > 0 && board[i - 1][0] == s[0]) {
                s[0] = swap(s[0]);
                cnt++;
            }
            for (int j = 0; j < board[i].length - 1; j++) {
                if (s[j] == s[j + 1]) {
                    s[j + 1] = swap(s[j + 1]);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    static char swap(char c) {
        switch (c) {
            case 'W':
                c = 'B';
                break;
            case 'B':
                c = 'W';
                break;
        }
        return c;
    }

}
