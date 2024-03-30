import java.io.IOException;

public class P1016 {
    public static void main(String[] args) throws IOException {
        long min = readLong();
        long max = readLong();

        boolean[] check = new boolean[(int) (max - min + 1)];

        for (long i = 2; i * i <= max; i++) {
            long pow = i * i;
            long startIndex = min / pow;

            if (min % pow != 0) {
                startIndex++;
            }

            for (long j = startIndex; pow * j <= max; j++) {
                check[(int) ((j * pow) - min)] = true;
            }
        }

        int result = 0;
        for (int i = 0; i < max - min; i++) {
            if (!check[i]) {
                result++;
            }
        }

        System.out.println(result);
    }

    private static int readLong() throws IOException {
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
