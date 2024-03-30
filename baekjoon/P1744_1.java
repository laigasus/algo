import java.io.IOException;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class P1744_1 {
    static Queue<Integer> positive, negative, zero;

    static {
        positive = new PriorityQueue<>(Comparator.reverseOrder());
        negative = new PriorityQueue<>(Comparator.naturalOrder());
        zero = new LinkedList<>();
    }

    public static void main(String[] args) throws IOException {
        int N = readInt();

        while (N-- > 0) {
            int num = readInt();

            switch (Integer.signum(num)) {
                case 1:
                    positive.offer(num);
                    break;
                case -1:
                    negative.offer(num);
                    break;
                default:
                    zero.offer(num);
                    break;
            }
        }

        int result = 0;
        result += calcPositive();
        result += calcNegativeAndZero();

        System.out.println(result);
    }

    private static int calcNegativeAndZero() {
        int sum = 0;
        while (negative.size() > 1) {
            int a = negative.poll();
            int b = negative.poll();

            sum += Math.max(a + b, a * b);
        }

        if (!negative.isEmpty()) {
            if (!zero.isEmpty()) {
                sum += negative.poll() * zero.poll();
            } else {
                sum += negative.poll();
            }
        }
        return sum;
    }

    private static int calcPositive() {
        int sum = 0;
        while (positive.size() > 1) {
            int a = positive.poll();
            int b = positive.poll();

            sum += Math.max(a + b, a * b);
        }

        if (!positive.isEmpty()) {
            sum += positive.poll();
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
