import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class P11651 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        Map<Integer, List<Integer>> map = new HashMap<>();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int value = Integer.parseInt(st.nextToken());
            int key = Integer.parseInt(st.nextToken());
            List<Integer> list;
            if (map.get(key) == null) {
                list = new ArrayList<>();
            } else {
                list = map.get(key);
            }
            map.put(key, list);
            map.get(key).add(value);
        }
        br.close();
        List<Integer> keyList = new ArrayList<>(map.keySet());
        Collections.sort(keyList);

        for (int key : keyList) {
            List<Integer> list = map.get(key);
            Collections.sort(list);
            for (int i = 0; i < list.size(); i++) {
                sb.append(list.get(i)).append(" ").append(key).append("\n");
            }
        }
        System.out.print(sb);
    }
}
