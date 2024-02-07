import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11035 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str;

        while ((str = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(str);
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            sb.append(calc(N, K)).append('\n');
        }

        System.out.print(sb);
    }

    private static int calc(int N, int K) {
        boolean[] arr = new boolean[N + 1];
        int cnt = 0, result = -1;

        loop: for (int i = 2; i < arr.length; i++) {
            for (int j = 1; i * j < arr.length; j++) {
                if (cnt >= K) {
                    break loop;
                }

                int num = i * j;

                if (arr[num]) {
                    continue;
                } else {
                    cnt++;
                    arr[num] = true;
                    result = num;
                }
            }
        }

        return result;
    }
}
