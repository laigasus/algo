import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P17609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            sb.append(check(br.readLine().toCharArray())).append('\n');
        }
        System.out.print(sb);
    }

    static int check(char[] tmp) {
        int left = 0, right = tmp.length - 1;

        while (left <= right) {
            if (tmp[left] == tmp[right]) {
                left++;
                right--;
            } else {
                boolean rmLeft = isPalindrome(tmp, left + 1, right);
                boolean rmRight = isPalindrome(tmp, left, right - 1);
                if (rmLeft == false && rmRight == false) {
                    return 2;
                } else {
                    return 1;
                }
            }
        }
        return 0;
    }

    static boolean isPalindrome(char[] arr, int left, int right) {
        while (left <= right) {
            if (arr[left++] != arr[right--]) {
                return false;
            }
        }
        return true;
    }
}
