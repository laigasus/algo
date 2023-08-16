import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class P1449 {
    public static void main(String[] args) throws IOException {
        int N = readInt(), L = readInt();

        List<Integer> list = new ArrayList<>();
        while (N-- > 0) {
            list.add(readInt());
        }
        Collections.sort(list);

        int[] leaked = new int[list.get(list.size() - 1) + 1];

        list.forEach(idx -> leaked[idx] = 1);

        int needs = 0;
        int left = 1, right = leaked.length - 1;
        while (left <= right) {
            if (leaked[left] == 1) {
                needs++;
                Arrays.fill(leaked, left, Math.min(left + L, leaked.length), 0);
                left += L;
            } else {
                left++;
            }

            if (leaked[right] == 1) {
                needs++;
                Arrays.fill(leaked, Math.max(0, right - L + 1), right + 1, 0);
                right -= L;
            } else {
                right--;
            }
        }

        System.out.println(needs);
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