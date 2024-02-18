import java.io.IOException;

public class P9273 {
    static final int MAX = (int) Math.pow(2, 15);
    static boolean[] isPrimary = new boolean[MAX + 1];

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        init();

        int num;
        while ((num = readInt()) != 0) {
            sb.append(calc(num)).append('\n');
        }

        System.out.print(sb);
    }

    private static int calc(int num) {
        int cnt = 0;

        for (int n = 0; n < num / 2 + 1; n++) {
            if (isPrimary[n] && isPrimary[num - n]) {
                cnt++;
            }
        }

        return cnt;
    }

    private static void init() {
        isPrimary[0] = isPrimary[1] = false;
        isPrimary[2] = true;
        for (int i = 3; i <= MAX; i += 2) {
            isPrimary[i] = true;
        }
        for (int i = 3; i * i <= MAX; i += 2) {
            if (isPrimary[i]) {
                for (int j = i * i; j <= MAX; j += i * 2) {
                    isPrimary[j] = false;
                }
            }
        }
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
