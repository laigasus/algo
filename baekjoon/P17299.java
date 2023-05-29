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

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;

        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }

        if (c == 13) {
            System.in.read();
        }

        return n;
    }
}