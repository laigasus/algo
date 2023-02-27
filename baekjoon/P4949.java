import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String str = br.readLine();

            if (str.charAt(0) == '.') {
                break;
            } else {
                str = str.replaceAll("[^\\[\\]\\(\\)]", "");
            }

            sb.append(check(str.toCharArray())).append('\n');
        }
        System.out.print(sb);
    }

    public static String check(char[] arr) {
        Stack<Character> stack = new Stack<>();

        for (char c : arr) {
            switch (c) {
                case '(':
                case '[':
                    stack.push(c);
                    break;

                case ')':
                case ']':
                    if (stack.empty() || (stack.peek() != c - 1 && stack.peek() != c - 2)) {
                        return "no";
                    } else {
                        stack.pop();
                    }
                    break;
            }
        }
        return stack.empty() ? "yes" : "no";
    }
}