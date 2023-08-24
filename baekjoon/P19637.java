import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class P19637 {

    static class Title {
        String name;
        int power;

        public Title(String name, int power) {
            this.name = name;
            this.power = power;
        }

        public String getName() {
            return name;
        }

        public int getPower() {
            return power;
        }
    }

    static Title[] titles;
    static int N, M;

    public static void main(String[] args) throws IOException {
        N = readInt();
        M = readInt();

        titles = new Title[N];

        for (int i = 0; i < N; i++) {
            String name = read();
            int power = readInt();
            titles[i] = new Title(name, power);
        }

        Arrays.sort(titles, Comparator.comparing(Title::getPower));

        int[] powers = new int[M];
        for (int i = 0; i < M; i++) {
            powers[i] = readInt();
        }

        StringBuilder sb = new StringBuilder();

        for (int power : powers) {
            int idx = binarySearch(power);
            sb.append(titles[idx].name).append('\n');
        }

        System.out.print(sb);
    }

    public static int binarySearch(int power) {
        int low = 0;
        int high = N - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (titles[mid].power < power) {
                low = mid + 1;
            } else if (titles[mid].power >= power) {
                high = mid - 1;
            }
        }
        return low;
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