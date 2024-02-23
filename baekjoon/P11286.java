import java.io.IOException;
import java.util.PriorityQueue;

public class P11286 {
    public static void main(String[] args) throws IOException {
        int N = readInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> {
            if (Math.abs(n1) == Math.abs(n2)) {
                return Integer.compare(n1, n2);
            } else {
                return Integer.compare(Math.abs(n1), Math.abs(n2));
            }
        });

        StringBuilder sb = new StringBuilder();
        while (N-- > 0) {
            int num = readInt();

            if (num == 0) {
                sb.append(pq.isEmpty() ? 0 : pq.poll()).append('\n');
            } else {
                pq.offer(num);
            }
        }

        System.out.print(sb);
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
