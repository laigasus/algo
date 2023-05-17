import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class P20920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<String, Integer>();

        while (N-- > 0) {
            String str = br.readLine();
            if (str.length() >= M) {
                Integer freq = map.getOrDefault(str, 0);
                map.put(str, freq + 1);
            }
        }

        List<String> list = map.keySet().stream().collect(Collectors.toList());

        list.sort((w1, w2) -> {
            int w1freq = map.get(w1);
            int w2freq = map.get(w2);

            if (w1freq == w2freq) {
                if (w1.length() == w2.length()) {
                    return w1.compareTo(w2);
                }
                return w2.length() - w1.length();
            }
            return w2freq - w1freq;
        });

        list.forEach(str -> sb.append(str).append('\n'));
        System.out.print(sb);
    }
}