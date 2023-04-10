import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1629 {
    static int C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        System.out.println(pow(A, B));
    }

    private static long pow(long A, long B) {
        if (B == 1) {
            return A % C;
        }

        long rs = pow(A, B / 2);

        if (B % 2 == 0) {
            return rs * rs % C;
        } else {
            return (rs * rs % C) * A % C;
        }
    }
}