import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class P1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> map = new LinkedHashMap<>();
        String[] names = new String[100000];
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            names[i] = br.readLine();
            map.put(names[i], i + 1);
        }

        for (int i = 0; i < M; i++) {
            String s = br.readLine();
            if (Character.isDigit(s.charAt(0))) {
                sb.append(names[Integer.parseInt(s) - 1]).append("\n");
            } else {
                sb.append(map.get(s)).append("\n");
            }
        }
        br.close();
        System.out.print(sb);
    }
}
