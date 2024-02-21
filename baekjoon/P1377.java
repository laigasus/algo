import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class P1377 {

    private static class Info {
        int idx, value;

        public Info(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }

    public static void main(String[] args) throws IOException {
        final int N = readInt();
        Info[] infos = new Info[N];

        for (int i = 0; i < N; i++) {
            infos[i] = new Info(i, readInt());
        }

        Arrays.sort(infos, Comparator.comparing(Info::getValue));

        int result = 0;
        for (int i = 0; i < N; i++) {
            result = Math.max(result, infos[i].idx - i);
        }

        System.out.println(result + 1);
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
