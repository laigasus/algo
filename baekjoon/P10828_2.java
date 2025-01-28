import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class P10828_2 {

    private static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String cmd = st.nextToken();

            switch (cmd) {
                case "push":
                    int X = Integer.parseInt(st.nextToken());
                    push(X);
                    break;
                case "pop":
                    sb.append(pop()).append('\n');
                    break;
                case "size":
                    sb.append(size()).append('\n');
                    break;
                case "empty":
                    sb.append(empty()).append('\n');
                    break;
                case "top":
                    sb.append(top()).append('\n');
                    break;
                default:
                    throw new IOException("wrong input");
            }
        }

        System.out.print(sb);

    }

    private static void push(int X) {
        stack.push(X);
    }

    private static int pop() {
        if (stack.isEmpty()) {
            return -1;
        }

        return stack.pop();
    }

    private static int size() {
        return stack.size();
    }

    private static int empty() {
        return stack.isEmpty() ? 1 : 0;
    }

    private static int top() {
        if (stack.isEmpty()) {
            return -1;
        }

        return stack.peek();
    }
}
