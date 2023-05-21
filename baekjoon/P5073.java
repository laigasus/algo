import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P5073 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int a, b, c;
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            if (a == 0 && b == 0 && c == 0) {
                break;
            }
            if (a == b && b == c && c == a) {
                sb.append("Equilateral");
            } else if (a + b <= c || a + c <= b || b + c <= a) {
                sb.append("Invalid");
            } else if (a == b || b == c || c == a) {
                sb.append("Isosceles");
            } else {
                sb.append("Scalene");
            }

        }
    }
}