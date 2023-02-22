import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P10828 {
    static Stack<Integer> stack = new Stack<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        while (N > 0) {
            task(br.readLine());
            N--;
        }
        br.close();
        System.out.print(sb);
    }

    static void task(String str) {
        String[] params = str.split(" ");
        String cmd = params[0];

        switch (cmd) {
            case "push": {
                int item = Integer.parseInt(params[1]);
                stack.push(item);
                break;
            }
            case "pop": {
                sb.append(stack.empty() ? -1 : stack.pop()).append("\n");
                break;
            }
            case "size": {
                sb.append(stack.size()).append("\n");
                break;
            }
            case "empty": {
                sb.append(stack.empty() ? 1 : 0).append("\n");
                break;
            }
            case "top": {
                sb.append(stack.empty() ? -1 : stack.peek()).append("\n");
                break;
            }
        }
    }
}
