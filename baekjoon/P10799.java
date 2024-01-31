import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class P10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Character> deque = new ArrayDeque<>();
        int result = 0;

        String str = br.readLine();

        for (int idx = 0; idx < str.length(); idx++) {
            char c = str.charAt(idx);

            switch (c) {
                case '(':
                    deque.push(c);
                    break;
                case ')':
                    deque.pop();
                    if (str.charAt(idx - 1) == ')') {
                        result++;
                    } else {
                        result += deque.size();
                    }
                    break;
                default:
                    throw new IllegalArgumentException("존재하지 않는 값");
            }
        }

        System.out.println(result);
    }
}
