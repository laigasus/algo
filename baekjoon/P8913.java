import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P8913 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            sb.append(isValid(br.readLine()) ? 1 : 0).append('\n');
        }

        System.out.println(sb);
    }

    private static boolean isValid(String s) {
        Stack<StringBuilder> stack = new Stack<>();

        stack.push(new StringBuilder(s));

        while (!stack.isEmpty()) {
            StringBuilder now = stack.pop();

            if (now.length() == 0) {
                return true;
            }

            for (int i = 0; i < now.length() - 1; i++) {
                if (now.charAt(i) == now.charAt(i + 1)) {
                    int start = i, end = i;
                    while (end++ < now.length()) {
                        if (now.charAt(start) != now.charAt(end)) {
                            break;
                        }
                    }

                    StringBuilder next = new StringBuilder(now);
                    stack.push(next.replace(start, end, ""));
                    i = end - 1;
                }
            }
        }

        return false;
    }
}
