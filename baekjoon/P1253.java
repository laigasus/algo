import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1253 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            int M = arr[i];

            int left = 0, right = arr.length - 1;

            loop: while (left < right) {
                if (left == i) {
                    left++;
                    continue;
                } else if (right == i) {
                    right--;
                    continue;
                }

                switch (Long.signum((long) arr[left] + arr[right] - M)) {
                    case 1:
                        right--;
                        break;

                    case 0:
                        cnt++;
                        break loop;

                    case -1:
                        left++;
                        break;
                }
            }
        }

        System.out.println(cnt);
    }
}