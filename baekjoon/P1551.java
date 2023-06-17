import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1551 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine(), ",");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        while (A-- > 0) {
            int[] tmp = new int[arr.length - 1];
            for (int i = 0; i < tmp.length; i++) {
                tmp[i] = arr[i + 1] - arr[i];
            }
            arr = tmp;
        }

        for (int num : arr) {
            sb.append(num).append(',');
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }
}