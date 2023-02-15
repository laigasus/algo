import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][];

        for (int i = 0; i < n; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        br.close();

        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < arr[i - 1].length; j++) {
                arr[i - 1][j] += calc(arr[i], j);
            }
        }

        System.out.println(arr[0][0]);
    }

    static int calc(int[] arr, int idx) {
        return Math.max(arr[idx], arr[idx + 1]);
    }
}
