import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class P10811 {
    static int[] baskets;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        baskets = IntStream.rangeClosed(1, N).toArray();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            swap(from, to);
        }

        for (int i = 0; i < baskets.length; i++) {
            sb.append(baskets[i]).append(" ");
        }

        System.out.println(sb);
        br.close();
    }

    static void swap(int from, int to) {
        from--;
        to--;

        int tmp;
        int mid = (to - from) / 2;
        for (int i = 0; i <= mid; i++) {
            tmp = baskets[from + i];
            baskets[from + i] = baskets[to - i];
            baskets[to - i] = tmp;
        }
    }
}
