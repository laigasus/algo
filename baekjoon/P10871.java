import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10871 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken()), n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        br.close();
        for (int i = 0; i < size; i++) {
            int x = Integer.parseInt(st.nextToken());
            if (x < n)
                sb.append(x + " ");
        }
        System.out.println(sb);

    }
}
