import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class P6603 {
    final static int BALLS = 6;
    static int K;
    static int[] S, arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s;
        while (!(s = br.readLine()).equals("0")) {
            init(new StringTokenizer(s));
            calc(0, 0);
            sb.append('\n');
        }

        System.out.print(sb);
    }

    static void init(StringTokenizer st) {
        K = Integer.parseInt(st.nextToken());
        S = new int[K];
        arr = new int[BALLS];

        for (int i = 0; i < K; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void calc(int depth, int idx) {
        if (depth > BALLS - 1) {
            StringJoiner sj = new StringJoiner(" ");
            for (int num : arr) {
                sj.add(Integer.toString(num));
            }
            sb.append(sj).append('\n');
            return;
        }

        for (int i = idx; i < S.length; i++) {
            arr[depth] = S[i];
            calc(depth + 1, i + 1);
        }
    }
}