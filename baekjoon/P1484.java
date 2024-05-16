import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class P1484 {
	static final int MAX = 100_000;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		final int G = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		// 성원이 기억한 무게
		int left = 1;

		// 현재 무게
		int right = 1;

		List<Integer> weights = new ArrayList<>();

		while (left <= right && right <= MAX) {
			// 쪘다고 말했기 때문에 음수는 나올 수 없음
			long diff = (right - left) * (right + left);

			if (diff < G) {
				right++;
			} else {
				left++;
			}

			if (diff == G) {
				weights.add(right);
			}

		}

		weights.forEach(w -> sb.append(w).append('\n'));

		System.out.print(weights.isEmpty() ? "-1" : sb);
	}
}