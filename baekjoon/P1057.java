import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1057 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int jimin = Integer.parseInt(st.nextToken());
        int hansu = Integer.parseInt(st.nextToken());
        int cnt = 0;

        while (N > 0) {
            jimin = jimin / 2 + jimin % 2;
            hansu = hansu / 2 + hansu % 2;
            cnt++;
            if (jimin == hansu) {
                break;
            }
            N /= 2;
        }

        System.out.println(cnt);
    }
}