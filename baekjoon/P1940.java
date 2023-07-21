import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int cnt = 0;
        int left = 0, right = arr.length - 1;

        while (left < right) {
            switch (Integer.signum(arr[left] + arr[right] - M)) {
                case 1:
                    right--;
                    break;
                case 0:
                    cnt++;
                case -1:
                    left++;
            }
        }

        System.out.println(cnt);
    }
}