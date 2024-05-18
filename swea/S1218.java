import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {
    static StringBuilder sb = new StringBuilder();

    static Map<Character, Character> brackets = new HashMap<>();

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = 10;

        brackets.put('(', ')');
        brackets.put('[', ']');
        brackets.put('{', '}');
        brackets.put('<', '>');

        for (int test_case = 1; test_case <= T; test_case++) {
            int length = Integer.parseInt(br.readLine());

            String str = br.readLine();

            Stack<Character> stack = new Stack<>();

            boolean result = true;
            for (int i = 0; i < length; i++) {
                char c = str.charAt(i);
                if (stack.isEmpty()) {
                    stack.push(c);
                    continue;
                }

                if (brackets.containsKey(c)) {
                    stack.push(c);
                    continue;
                }

                if (brackets.containsValue(c)) {
                    if (brackets.get(stack.peek()) == c) {
                        stack.pop();
                    } else {
                        result = false;
                        break;
                    }
                }
            }

            sb.append(String.format("#%d %d\n", test_case, result ? 1 : 0));
        }

        System.out.println(sb);
    }
}