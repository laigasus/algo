import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P9012_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            sb.append(isVPS(br.readLine()) ? "YES" : "NO").append('\n');
        }

        System.out.print(sb);
    }

    private static boolean isVPS(String str) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c != '(' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }

}
