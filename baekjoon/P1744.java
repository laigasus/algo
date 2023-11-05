import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class P1744 {

    private static LinkedList<Integer> positive, negativeAndZero;

    static {
        positive = new LinkedList<>();
        negativeAndZero = new LinkedList<>();
    }

    public static void main(String[] args) throws IOException {
        int N = readInt();

        for (int i = 0; i < N; i++) {
            int num = readInt();
            switch (Integer.signum(num)) {
                case 1:
                    positive.add(num);
                    break;
                case 0:
                case -1:
                    negativeAndZero.add(num);
                    break;
            }
        }

        Collections.sort(positive, Comparator.reverseOrder());
        Collections.sort(negativeAndZero, Comparator.naturalOrder());

        System.out.println(calc());

    }

    private static int calc() {
        int sum = 0;

        while (!positive.isEmpty()) {
            int a = positive.pollFirst();

            if (positive.size() >= 1) {
                int b = positive.pollFirst();
                if (a == 1 || b == 1) {
                    sum += a + b;
                } else {
                    sum += a * b;
                }
            } else {
                sum += a;
            }
        }

        while (!negativeAndZero.isEmpty()) {
            int a = negativeAndZero.pollFirst();

            if (negativeAndZero.size() >= 1) {
                int b = negativeAndZero.pollFirst();
                sum += a * b;
            } else {
                sum += a;
            }
        }

        return sum;
    }

    private static int readInt() throws IOException {
        int rs = 0;
        boolean isNegative = false;
        int c = System.in.read();
        while (c <= ' ') {
            c = System.in.read();
        }
        if (c == '-') {
            isNegative = true;
            c = System.in.read();
        }
        while (c >= '0' && c <= '9') {
            rs = rs * 10 + c - '0';
            c = System.in.read();
        }
        return isNegative ? -rs : rs;
    }
}
