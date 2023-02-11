import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2004 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        long n = Integer.parseInt(st.nextToken());
        long r = Integer.parseInt(st.nextToken());

        long get5 = getPower(n, 5) - getPower(n - r, 5) - getPower(r, 5);
        long get2 = getPower(n, 2) - getPower(n - r, 2) - getPower(r, 2);

        System.out.println(Math.min(get5, get2));
    }

    static int getPower(long num, int a) {
        int cnt = 0;
        while (num >= a) {
            cnt += (num / a);
            num /= a;
        }
        return cnt;
    }
}