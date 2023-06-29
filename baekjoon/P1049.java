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