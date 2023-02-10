import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class P3036 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr[0] = Integer.parseInt(st.nextToken());

        for (int i = 1; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            int gcd = BigInteger.valueOf(arr[0]).gcd(BigInteger.valueOf(arr[i])).intValue();
            sb.append(arr[0] / gcd).append("/").append(arr[i] / gcd).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}
