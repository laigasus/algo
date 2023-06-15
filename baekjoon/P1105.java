import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1105 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String L = st.nextToken();
        String R = st.nextToken();

        int min = 0;
        if (L.length() == R.length()) {
            for (int idx = 0; idx < L.length(); idx++) {
                if (L.charAt(idx) != R.charAt(idx)) {
                    break;
                } else {
                    if (L.charAt(idx) == '8') {
                        min++;
                    }
                }
            }
        }

        System.out.println(min);
    }
}