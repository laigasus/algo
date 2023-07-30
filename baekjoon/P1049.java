import java.io.IOException;

public class P1049 {
    public static void main(String[] args) throws IOException {
        int N = readInt();
        int M = readInt();

        int[] pack = new int[M];
        int[] single = new int[M];

        int packMin = Integer.MAX_VALUE;
        int singleMin = Integer.MAX_VALUE;

        for (int i = 0; i < M; i++) {
            pack[i] = readInt();
            single[i] = readInt();
            packMin = Math.min(packMin, pack[i]);
            singleMin = Math.min(singleMin, single[i]);
        }

        int sum = 0;
        sum += Math.min(packMin * (N / 6), singleMin * 6 * (N / 6));
        sum += Math.min(singleMin * (N % 6), packMin);

        System.out.println(sum);
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