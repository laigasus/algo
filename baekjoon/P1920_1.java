import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class P1920_1 {
    public static void main(String[] args) throws IOException {
        final int N = readInt();

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            set.add(readInt());
        }

        StringBuilder sb = new StringBuilder();

        int M = readInt();

        while (M-- > 0) {
            int num = readInt();
            sb.append(set.contains(num) ? 1 : 0).append('\n');
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
