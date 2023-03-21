import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] trees = new int[N];
        st = new StringTokenizer(br.readLine());

        int min = 0, max = 0;
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            if (max < trees[i]) {
                max = trees[i];
            }
        }

        while (min < max) {
            long sum = 0;
            int mid = (max + min) / 2;
            for (int tree : trees) {
                if (tree - mid > 0) {
                    sum += (tree - mid);
                }
            }

            if (sum < M) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        System.out.println(min - 1);
    }
}
