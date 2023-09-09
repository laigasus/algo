import java.io.IOException;
import java.util.Stack;

public class P28278 {
    public static void main(String[] args) throws IOException {
        int N = readInt();

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        while (N-- > 0) {
            switch (readInt()) {
                case 1:
                    stack.push(readInt());
                    break;

                case 2:
                    if (stack.isEmpty()) {
                        sb.append(-1).append('\n');
                    } else {
                        sb.append(stack.pop()).append('\n');
                    }
                    break;

                case 3:
                    sb.append(stack.size()).append('\n');
                    break;

                case 4:
                    sb.append(stack.isEmpty() ? 1 : 0).append('\n');
                    break;

                case 5:
                    if (stack.isEmpty()) {
                        sb.append(-1).append('\n');
                    } else {
                        sb.append(stack.peek()).append('\n');
                    }
                    break;
            }
        }

        System.out.print(sb);
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