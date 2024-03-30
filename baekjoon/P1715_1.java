import java.io.IOException;
import java.util.Comparator;
import java.util.PriorityQueue;

public class P1715_1 {
    public static void main(String[] args) throws IOException {
        int N = readInt();

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.naturalOrder());

        for (int i = 0; i < N; i++) {
            pq.offer(readInt());
        }

        int result = 0;
        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();

            pq.offer(a + b);
            result += (a + b);
        }

        System.out.println(result);
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
