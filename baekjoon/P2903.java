import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2903 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[16];

        arr[0] = 2;
        for (int i = 1; i < 16; i++) {
            arr[i] = arr[i - 1] * 2 - 1;
        }
        System.out.println(arr[N] * arr[N]);
    }
}
