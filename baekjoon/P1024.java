import java.io.IOException;

public class P1024 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int N = readInt(), L = readInt();

        for (int i = L; i <= 100; i++) {
            if ((2 * N >= i * (i - 1)) && (2 * N - i * (i - 1)) % (2 * i) == 0) {
                int a = (2 * N - i * (i - 1)) / (2 * i);
                for (int j = 0; j < i; j++) {
                    sb.append(a + j).append(' ');
                }
                System.out.println(sb);
                return;
            }
        }
        System.out.println(-1);
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