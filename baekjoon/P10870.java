import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P10870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(pivo(n));
    }

    static int pivo(int n) {
        switch (n) {
            case 0:
            case 1:
                return n;
            default:
                return pivo(n - 1) + pivo(n - 2);
        }
    }
}
