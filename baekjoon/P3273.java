import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        boolean[] arr = new boolean[2000001];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[Integer.parseInt(st.nextToken())] = true;
        }
        int cnt = 0;
        int x = Integer.parseInt(br.readLine());

        for (int i = 0; i <= x / 2; i++) {
            if (arr[i] & arr[x - i] & (i != x - i)) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
