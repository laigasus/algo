import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P19532 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        calcXY(Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray());
    }

    static void calcXY(int... num) {
        int a = num[0], b = num[1], c = num[2], d = num[3], e = num[4], f = num[5];

        for (int x = -999; x < 1000; x++) {
            for (int y = -999; y < 1000; y++) {
                if ((a * x) + (b * y) == c && (d * x) + (e * y) == f) {
                    System.out.println(x + " " + y);
                    return;
                }
            }
        }
    }
}
