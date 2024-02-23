import java.io.IOException;
import java.util.ArrayDeque;

public class P11003 {

    private static class Node {
        int index;
        int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        final int N = readInt(), L = readInt();

        StringBuilder sb = new StringBuilder();
        ArrayDeque<Node> deque = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            Node node = new Node(i, readInt());

            while (!deque.isEmpty() && deque.getLast().value > node.value) {
                deque.pollLast();
            }

            deque.addLast(node);

            if (deque.getFirst().index <= i - L) {
                deque.pollFirst();
            }

            sb.append(deque.getFirst().value).append(' ');
        }

        System.out.println(sb);
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
