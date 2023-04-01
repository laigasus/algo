import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P10942 {
    static int[] arr;
    static boolean[][] isPalindrome;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        isPalindrome = new boolean[N][N];
        StringTokenizer st;

        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                isPalindrome[i][j] = isPalindromeCheck(i, j);
            }
        }

        int M = Integer.parseInt(br.readLine());
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;

            sb.append(isPalindrome[start][end] ? 1 : 0).append('\n');
        }

        System.out.print(sb);
    }

    static boolean isPalindromeCheck(int left, int right) {
        while (left <= right) {
            if (arr[left++] != arr[right--]) {
                return false;
            }
        }
        return true;
    }
}
