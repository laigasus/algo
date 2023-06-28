import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P13275 {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            sb.append("#").append(S.charAt(i));
        }
        sb.append("#");
        S = sb.toString();

        arr = new int[S.length()];
        manachar(S);

        int max = Arrays.stream(arr).max().getAsInt();
        System.out.println(max);
    }

    static void manachar(String s) {
        int r = 0, p = 0;
        int len = s.length();

        for (int i = 0; i < len; i++) {
            if (i <= r) {
                arr[i] = Math.min(arr[2 * p - i], r - i);
            } else {
                arr[i] = 0;
            }

            while (i - arr[i] - 1 >= 0 && i + arr[i] + 1 < len
                    && s.charAt(i - arr[i] - 1) == s.charAt(i + arr[i] + 1)) {
                arr[i]++;
            }

            if (r < i + arr[i]) {
                r = i + arr[i];
                p = i;
            }
        }
    }
}