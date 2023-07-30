import java.io.IOException;

public class P1009 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int T = readInt();
        while (T-- > 0) {
            int a = readInt();
            int b = readInt();
            int c = 0;
            int rs = 1;

            switch (a % 10) {
                case 0:
                case 1:
                case 5:
                case 6:
                    rs = a % 10;
                    break;

                case 4:
                case 9:
                    c = b % 2;
                    c = (c == 0) ? 2 : c;
                    break;

                default:
                    c = b % 4;
                    c = (c == 0) ? 4 : c;
                    break;
            }
            while (c-- > 0) {
                rs = (rs * a) % 10;
            }

            sb.append(rs == 0 ? 10 : rs).append('\n');
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