import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class H9657 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            map.put(i, 0);
            for (int j = 1; j <= m; j++) {
                int num = Integer.parseInt(st.nextToken());

                if (num == 1) {
                    map.put(i, map.get(i) + 1);
                }
            }
        }

        int T = 2;

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            for (int i = start; i <= end; i++) {
                map.put(i, Math.max(map.get(i) - 1, 0));
            }
        }

        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            cnt += map.get(i);
        }

        System.out.println(cnt);
    }
}
