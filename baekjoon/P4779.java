import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P4779 {
    static char[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String N = "";
        while ((N = br.readLine()) != null) {
            sb.append(Init(N)).append('\n');
        }

        System.out.print(sb);
    }

    static char[] Init(String N) {
        int n = (int) Math.pow(3, Integer.parseInt(N));
        arr = new char[n];
        Arrays.fill(arr, '-');
        Cantor(0, n);
        return arr;
    }

    static void Cantor(int start, int end) {
        if (end < 3) {
            return;
        }
        for (int i = start + end / 3; i < start + end / 3 * 2; i++) {
            arr[i] = ' ';
        }
        Cantor(start, end / 3);
        Cantor(start + end / 3 * 2, end / 3);
    }
}