import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

class P6137 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int N = Integer.parseInt(br.readLine());

        StringBuilder tmp = new StringBuilder();

        for (int i = 0; i < N; i++) {
            tmp.append(br.readLine());
        }

        StringBuilder sb = new StringBuilder();

        int cnt = 0;
        int left = 0, right = N - 1;
        while (left <= right) {
            int first = tmp.charAt(left);
            int last = tmp.charAt(right);

            if (first < last) {
                sb.append(tmp.charAt(left++));
            } else if (first > last) {
                sb.append(tmp.charAt(right--));
            } else {
                int l = left, r = right;

                while (l < r && tmp.charAt(l) == tmp.charAt(r)) {
                    l++;
                    r--;
                }

                if (tmp.charAt(l) <= tmp.charAt(r)) {
                    sb.append(tmp.charAt(left++));
                } else {
                    sb.append(tmp.charAt(right--));
                }
            }

            cnt++;
            if (cnt % 80 == 0) {
                sb.append('\n');
            }
        }

        System.out.print(sb);
    }
}