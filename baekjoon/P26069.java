import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class P26069 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Map<String, Boolean> map = new LinkedHashMap<>();

        map.put("ChongChong", true);

        StringTokenizer st;
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken(), b = st.nextToken();

            if (map.getOrDefault(b, false) || map.getOrDefault(a, false)) {
                map.put(a, true);
                map.put(b, true);
            }
        }
        System.out.println(map.values().stream().filter(isRainbowDance -> isRainbowDance).count());
    }
}
