import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class P9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            HashMap<String, List<String>> map = new HashMap<>();

            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                String accessory = st.nextToken();
                String part = st.nextToken();
                if (map.containsKey(part)) {
                    map.get(part).add(accessory);
                } else {
                    map.put(part, new ArrayList<>(Arrays.asList(accessory)));
                }
            }
            int sum = 1;

            for (List<String> list : map.values()) {
                sum *= (list.size() + 1);
            }

            sum -= 1;
            sb.append(sum).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}
