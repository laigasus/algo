import java.io.IOException;
import java.util.Stack;

public class P17299 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        int n = readInt();
        int freq[] = new int[1_000_001];
        int arr[] = new int[n];
        int rs[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = readInt();
            freq[arr[i]]++;
        }

        for (int i = 0; i < n; i++) {
            while (!stack.empty() && freq[arr[i]] > freq[arr[stack.peek()]]) {
                rs[stack.pop()] = arr[i];
            }
            stack.push(i);
        }

        while (!stack.empty()) {
            rs[stack.pop()] = -1;
        }

        for (int i = 0; i < n; i++) {
            sb.append(rs[i]).append(' ');
        }
        System.out.println(sb);
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