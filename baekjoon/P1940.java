import java.io.IOException;
import java.util.Arrays;

public class P1940 {
    public static void main(String[] args) throws IOException {
        final int N = readInt();

        int[] materials = new int[N];

        final int M = readInt();

        for (int i = 0; i < N; i++) {
            materials[i] = readInt();
        }

        Arrays.sort(materials);

        int first = 0, second = N - 1;
        int result = 0;

        while (first < second) {
            int sum = materials[first] + materials[second];
            switch (Integer.compare(sum, M)) {
                case -1:
                    first++;
                    break;
                case 0:
                    result++;
                case 1:
                    second--;
            }
        }

        System.out.println(result);
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