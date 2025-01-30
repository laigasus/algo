import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P1935 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        char[] exprs = br.readLine().toCharArray();

        int[] values = new int[N];
        Stack<Double> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            values[i] = Integer.parseInt(br.readLine());
        }

        for (char c : exprs) {
            if (Character.isAlphabetic(c)) {
                stack.push(values[c - 'A'] * 1.0);
            } else {
                double v1 = stack.pop();
                double v2 = stack.pop();

                stack.push(calc(v2, v1, c));
            }
        }

        System.out.printf("%.2f\n", stack.pop());

    }

    private static double calc(double a, double b, char operand) throws IOException {
        switch (operand) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
            default:
                throw new IOException("Wrong operand");
        }
    }
}
