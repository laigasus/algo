import java.io.IOException;

public class P20529 {
    static final int MBTI_LEN = 4;

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();

        int T = readInt();

        while (T-- > 0) {
            int N = readInt();
            String[] mbti = new String[N];

            for (int i = 0; i < N; i++) {
                mbti[i] = read();
            }

            sb.append(N >= 33 ? 0 : calc(N, mbti)).append('\n');
        }

        System.out.print(sb);
    }

    static int calc(int N, String[] mbti) {
        int min = Integer.MAX_VALUE;
        for (int first = 0; first < N - 2; first++) {
            for (int second = first + 1; second < N - 1; second++) {
                for (int third = second + 1; third < N; third++) {
                    min = Math.min(min, cntDiff(mbti[first], mbti[second], mbti[third]));
                }
            }
        }

        return min;
    }

    private static int cntDiff(String p1, String p2, String p3) {
        int cnt = 0;
        for (int i = 0; i < MBTI_LEN; i++) {
            if (p1.charAt(i) != p2.charAt(i)) {
                cnt++;
            }
            if (p2.charAt(i) != p3.charAt(i)) {
                cnt++;
            }
            if (p3.charAt(i) != p1.charAt(i)) {
                cnt++;
            }
        }
        return cnt;
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

    private static String read() throws IOException {
        StringBuilder sb = new StringBuilder();
        int c = System.in.read();
        while (c <= ' ') {
            c = System.in.read();
        }
        while (c > ' ') {
            sb.append((char) c);
            c = System.in.read();
        }
        return sb.toString();
    }
}
