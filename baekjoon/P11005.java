import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11005 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int nNumber = Integer.parseInt(st.nextToken());

        while (N > 0) {
            int tmp = N % nNumber;
            char c = Character.valueOf((char) (tmp + 55));
            if (tmp > 9) {
                sb.append(c);
            } else {
                sb.append(tmp);
            }
            N /= nNumber;
        }

        System.out.println(sb.reverse());
    }
}
