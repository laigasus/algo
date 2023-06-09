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

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;

        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }

        if (c == 13) {
            System.in.read();
        }

        return n;
    }
}