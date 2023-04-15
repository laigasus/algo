import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P27433 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(fac(Integer.parseInt(br.readLine())));
    }

    static long fac(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * fac(n - 1);
    }
}