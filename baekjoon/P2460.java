import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2460 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[10];
        int max = 0;

        int out = Integer.parseInt(st.nextToken());
        int in = Integer.parseInt(st.nextToken());
        arr[0] = in;

        for (int i = 1; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            out = Integer.parseInt(st.nextToken());
            in = Integer.parseInt(st.nextToken());
            arr[i] = arr[i - 1];
            arr[i] -= out;
            arr[i] += in;
            max = Integer.max(max, arr[i]);
        }

        System.out.println(max);
    }
}