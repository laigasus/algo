import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int left = 1, right = 1, sum = 1;
        int cnt = 0;
        while (left <= right && right <= N) {
            switch (Integer.signum(sum - N)) {
                case -1:
                    right++;
                    sum += right;
                    break;
                case 0:
                    cnt++;
                case 1:
                    sum -= left;
                    left++;
            }
        }

        System.out.println(cnt);
    }
}