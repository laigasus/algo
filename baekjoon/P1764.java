import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class P1764 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int cnt = 0;

        Set<String> set = new LinkedHashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        Set<String> rs = new TreeSet<>();

        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            if (set.contains(str)) {
                cnt++;
                rs.add(str);
            }
        }
        rs.forEach(str -> sb.append(str).append("\n"));
        System.out.println(cnt);
        System.out.print(sb);
    }
}
