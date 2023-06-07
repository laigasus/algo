import java.io.IOException;

public class P1009 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int T = readInt();
        for (int j = 0; j < T; j++) {
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