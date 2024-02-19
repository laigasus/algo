import java.io.IOException;
import java.util.Stack;

public class P17298 {
    public static void main(String[] args) throws IOException {
        final int N = readInt();
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = readInt();
        }

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && A[stack.peek()] < A[i]) {
                A[stack.pop()] = A[i];
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {
            A[stack.pop()] = -1;
        }

        for (int a : A) {
            sb.append(a).append(' ');
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