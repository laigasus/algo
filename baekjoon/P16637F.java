import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class P16637F {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        Calculator calculator = new Calculator(Calculator.toPostfix(sc.next()));
        int result = calculator.calc();
        // 중첩 괄호 x, 괄호 내 연산자 하나 여야 함
        System.out.println(result);
    }

    private static class Calculator {
        String script;

        private static final Map<Character, Integer> operandOrder = Map.ofEntries(
            Map.entry('+', 2),
            Map.entry('-', 2),
            Map.entry('*', 1),
            Map.entry('(', 3),
            Map.entry(')', 3)
        );

        public Calculator(String script) {
            this.script = script;
        }

        public static String toPostfix(String str) {
            StringBuilder sb = new StringBuilder();
            Stack<Character> st = new Stack<>();
            for (char c : str.toCharArray()) {
                switch (c) {
                    case '+', '-', '*' -> {
                        while (!st.isEmpty() && operandOrder.get(st.peek()) <= operandOrder.get(c)) {
                            sb.append(st.pop());
                        }
                        st.push(c);
                    }
                    case '(' -> st.push(c);
                    case ')' -> {
                        while (!st.isEmpty() && st.peek() != '(') {
                            sb.append(st.pop());
                        }
                        st.pop();
                    }
                    default -> sb.append(c);
                }
            }
            while (!st.isEmpty()) {
                sb.append(st.pop());
            }

            return sb.toString();
        }


        public int calc() {
            Stack<Integer> st = new Stack<>();

            for (char c : script.toCharArray()) {
                if (!Character.isDigit(c)) {
                    int a = st.pop();
                    int b = st.pop();

                    st.push(switch (c) {
                        case '+' -> add(b, a);
                        case '-' -> subtract(b, a);
                        case '*' -> multiply(b, a);
                        default -> throw new UnsupportedOperationException("없는 값>" + c);
                    });
                } else {
                    st.push(c - '0');
                }
            }

            return st.pop();
        }

        // 덧셈
        private static int add(int a, int b) {
            return a + b;
        }

        // 뺄셈
        private static int subtract(int a, int b) {
            return a - b;
        }

        // 곱셈
        private static int multiply(int a, int b) {
            return a * b;
        }

    }


}