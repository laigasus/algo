import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1300 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());

		int left = 1;
		int right = K;
		int ans = 0;
		while (left <= right) {
			int mid = (left + right) / 2;
			long cnt = 0;
			for (int i = 1; i <= N; i++) {
				cnt += Math.min(mid / i, N);
			}
			if (cnt < K) {
				left = mid + 1;
			} else {
				ans = mid;
				right = mid - 1;
			}
		}
		System.out.println(ans);
	}
}