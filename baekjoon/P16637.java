import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class P16637 {
    static int N;
    static int[] num;
    static char[] operand;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        String str = sc.next();
        num = new int[N / 2 + 1];
        operand = new char[N / 2];

        for (int idx = 0; idx < N; idx++) {
            if (isNumber(idx)) {
                num[idx / 2] = str.charAt(idx) - '0';
            } else {
                operand[idx / 2] = str.charAt(idx);
            }
        }

        System.out.println(dfs(0, num[0]));
    }

    // 피연산자는 모두 짝수 인덱스에 있음을 이용
    private static boolean isNumber(int idx) {
        return idx % 2 == 0;
    }

    private static int dfs(int operandIdx, int result) {
        if (operandIdx >= N / 2) {
            return result;
        }

        int bracketX = calc(result, num[operandIdx + 1], operand[operandIdx]);
        int bracketXNext = dfs(operandIdx + 1, bracketX);

        if (operandIdx + 1 < N / 2) {
            int bracketO = calc(num[operandIdx + 1], num[operandIdx + 2], operand[operandIdx + 1]);
            bracketO = calc(result, bracketO, operand[operandIdx]);

            int bracketONext = dfs(operandIdx + 2, bracketO);
            return Math.max(bracketXNext, bracketONext);
        }

        return bracketXNext;
    }

    private static int calc(int n1, int n2, char operand) {
        switch (operand) {
            case '+':
                return n1 + n2;
            case '-':
                return n1 - n2;
            default:
                return n1 * n2;
        }
    }
}