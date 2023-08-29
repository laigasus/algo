import java.io.IOException;
import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P11723 {
    static StringBuilder sb = new StringBuilder();
    static HashSet<Integer> S = new HashSet<>();

    public static void main(String[] args) throws IOException {

        int M = readInt();

        while (M-- > 0) {
            task();
        }

        System.out.print(sb);
    }

    private static void task() throws IOException {
        switch (read()) {
            case "add":
                S.add(readInt());
                break;
            case "remove":
                S.remove(readInt());
                break;
            case "check":
                sb.append(S.contains(readInt()) ? 1 : 0).append('\n');
                break;
            case "toggle":
                int num = readInt();
                if (S.contains(num)) {
                    S.remove(num);
                } else {
                    S.add(num);
                }
                break;
            case "all":
                S = new HashSet<>(
                        IntStream.rangeClosed(1, 20)
                                .boxed()
                                .collect(Collectors.toSet()));
                break;
            case "empty":
                S = new HashSet<>();
                break;
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