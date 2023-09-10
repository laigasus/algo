import java.io.IOException;
import java.util.Stack;

public class P12789 {
    public static void main(String[] args) throws IOException {
        int N = readInt();
        int len = N, now = 1;

        Stack<Integer> stack = new Stack<>();

        while (N-- > 0) {
            int v = readInt();
            if (v == now) {
                now++;
                while (!stack.isEmpty() && stack.peek() == now) {
                    stack.pop();
                    now++;
                }
            } else {
                stack.push(v);
            }
        }

        System.out.println(now - 1 == len ? "Nice" : "Sad");

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
