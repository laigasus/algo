import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P1918 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String infixExpression = br.readLine().trim(); // 입력 받기
        String postfixExpression = infixToPostfix(infixExpression); // 변환
        System.out.println(postfixExpression); // 결과 출력
    }

    public static int precedence(char op) {
        switch (op) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '(':
            case ')':
                return 0;
            default:
                return -1; // 피연산자 또는 알 수 없는 문자
        }
    }

    // 중위 표기식을 후위 표기식으로 변환하는 메서드
    public static String infixToPostfix(String expression) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            // 피연산자 (알파벳 대문자)
            if (Character.isAlphabetic(ch)) {
                result.append(ch);
            }
            // 여는 괄호
            else if (ch == '(') {
                stack.push(ch);
            }
            // 닫는 괄호
            else if (ch == ')') {
                // 여는 괄호가 나올 때까지 스택에서 pop하여 결과에 추가
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                stack.pop(); // 여는 괄호 제거
            }
            // 연산자
            else {
                // 스택의 top에 있는 연산자의 우선순위가 현재 연산자보다 높거나 같으면 pop
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(ch)) {
                    result.append(stack.pop());
                }
                stack.push(ch); // 현재 연산자를 스택에 push
            }
        }

        // 스택에 남은 연산자 모두 pop하여 결과에 추가
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }
}
