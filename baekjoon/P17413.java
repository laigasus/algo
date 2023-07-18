import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P17413 {
    static Stack<Character> st = new Stack<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        boolean isTagInside = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '<' || c == '>') {
                isTagInside = !isTagInside;
                printStack();
                sb.append(c);
                continue;
            }

            if (isTagInside) {
                sb.append(c);
            } else {
                if (c == ' ') {
                    printStack();
                    sb.append(" ");
                } else {
                    st.push(c);
                }
            }
        }
        printStack();

        System.out.println(sb);
        sb.setLength(0);
    }

    static void printStack() {
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
    }
}