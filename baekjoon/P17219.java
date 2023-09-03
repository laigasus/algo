import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class P17219 {

    public static void main(String[] args) throws IOException {
        int N = readInt(), M = readInt();

        Map<String, String> sites = new HashMap<>();

        while (N-- > 0) {
            sites.put(read(), read());
        }

        StringBuilder sb = new StringBuilder();

        while (M-- > 0) {
            sb.append(sites.get(read())).append('\n');
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