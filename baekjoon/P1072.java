import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1072 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.close();
        System.out.println(fac(N));
    }

    static int fac(int n) {
        return n > 1 ? fac(n - 1) * n : 1;
    }
}
