import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String N = br.readLine();
        br.close();

        int[] arr = new int[10];

        for (int i = 0; i < N.length(); i++) {
            arr[Character.getNumericValue(N.charAt(i))]++;
        }

        for (int i = 9; i >= 0; i--) {
            while (arr[i] > 0) {
                sb.append(i);
                arr[i]--;
            }
        }
        System.out.println(sb);
    }
}