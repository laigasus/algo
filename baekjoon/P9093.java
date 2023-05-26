import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P9093 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringBuilder str = new StringBuilder();
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                str.append(new StringBuilder(st.nextToken()).reverse()).append(" ");
            }
            sb.append(str).append('\n');
        }

        System.out.print(sb);
    }
}