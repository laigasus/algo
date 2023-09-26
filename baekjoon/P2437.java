import java.io.IOException;
import java.util.Arrays;

public class P2437 {
	public static void main(String[] args) throws IOException {
		int N = readInt();
		int[] weights = new int[N];

		for (int i = 0; i < N; i++) {
			weights[i] = readInt();
		}

		Arrays.sort(weights);

		int sum = 1;
		for (int weight : weights) {
			if (sum < weight) {
				break;
			}
			sum += weight;
		}

		System.out.println(sum);
	}

	private static int readInt() throws IOException {
		int rs = 0;
		boolean isNegative = false;
		int c = System.in.read();
		while (c <= ' ') {
			c = System.in.read();
		}
		if (c == '-') {
			isNegative = true;
			c = System.in.read();
		}
		while (c >= '0' && c <= '9') {
			rs = rs * 10 + c - '0';
			c = System.in.read();
		}
		return isNegative ? -rs : rs;
	}
}
