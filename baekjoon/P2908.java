import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2908 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        br.close();
        int a = reverse(st), b = reverse(st);
        System.out.println(a > b ? a : b);
    }

    static int reverse(StringTokenizer st) {
        return Integer.parseInt(new StringBuilder(st.nextToken()).reverse().toString());
    }
}
