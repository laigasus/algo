import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2438 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(bf.readLine());
        String[] arr = new String[N];

        for (int i = 0; i < N; i++) {
            arr[i] = "*".repeat(i + 1);
        }

        System.out.print(String.join("\n", arr));
        bf.close();
    }
}
