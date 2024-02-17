import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int N = Integer.parseInt(br.readLine());
        final int START_NUM = 1;

        int left = START_NUM, right = START_NUM, sum = START_NUM;
        int result = 0;
        while (left <= N) {
            switch (Integer.compare(sum, N)) {
                case -1:
                    sum += ++right;
                    break;
                case 0:
                    result++;
                case 1:
                    sum -= left++;
            }
        }

        System.out.println(result);
    }
}