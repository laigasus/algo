import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2675 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int words = Integer.parseInt(br.readLine());

        for (int i = 0; i < words; i++) {
            st = new StringTokenizer(br.readLine());
            int repeat = Integer.parseInt(st.nextToken());
            String S = st.nextToken();
            for (String str : S.split("")) {
                sb.append(str.repeat(repeat));
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
