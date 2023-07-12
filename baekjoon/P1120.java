import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1120 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String A = st.nextToken();
        String B = st.nextToken();

        int rs = 0;
        if (A.length() < B.length()) {
            rs = calc(A, B);
        } else {
            rs = calc(B, A);
        }

        System.out.println(rs);
    }

    static int calc(String a, String b) {
        int min = Integer.MAX_VALUE;

        for (int i = 0; i <= b.length() - a.length(); i++) {
            int cnt = 0;
            for (int j = 0; j < a.length(); j++) {
                if (a.charAt(j) != b.charAt(j + i)) {
                    cnt++;
                }
            }
            min = Math.min(min, cnt);
        }

        return min;
    }
}