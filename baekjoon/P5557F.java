import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.stream.Stream;

public class P5557F {

    private static int N;
    private static int cnt;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        arr = Stream.of(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        calc(0, BigInteger.ZERO);

        System.out.println(cnt);

    }

    private static void calc(int idx, BigInteger sum) {
        if (sum.compareTo(BigInteger.ZERO) < 0 || sum.compareTo(BigInteger.valueOf(20)) > 0) {
            return;
        } else if (idx == N - 1) {
            if (sum.equals(BigInteger.valueOf(arr[N - 1]))) {
                cnt++;
            }
            return;
        }

        calc(idx + 1, sum.add(BigInteger.valueOf(arr[idx])));
        calc(idx + 1, sum.subtract(BigInteger.valueOf(arr[idx])));
    }
}
