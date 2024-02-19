import java.io.IOException;
import java.util.Stack;

public class P1874 {
    public static void main(String[] args) throws IOException {
        final int N = readInt();

        Stack<Integer> st = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int num = 1;
        boolean isValid = true;
        loop: for (int i = 0; i < N; i++) {
            int required = readInt();

            if (!isValid) {
                continue loop;
            }

            do {
                if (st.isEmpty()) {
                    st.push(num);
                    sb.append('+').append('\n');
                    continue;
                }

                switch (Integer.compare(st.peek(), required)) {
                    case -1:
                        st.push(num);
                        sb.append('+').append('\n');
                        break;
                    case 0:
                        st.pop();
                        sb.append('-').append('\n');
                        continue loop;
                    case 1:
                        st.pop();
                        sb.append('-').append('\n');
                        break;
                }
            } while (num++ <= N);

            isValid = false;
        }

        System.out.print(isValid ? sb.toString() : "NO");
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
