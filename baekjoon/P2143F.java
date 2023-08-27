import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class P2143F {
    static int[] A, B;
    static int T, cnt;

    public static void main(String[] args) throws IOException {
        T = readInt();

        A = new int[readInt()];
        for (int i = 0; i < A.length; i++) {
            A[i] = readInt();
        }

        B = new int[readInt()];
        for (int i = 0; i < B.length; i++) {
            B[i] = readInt();
        }

        List<Integer> subA = new ArrayList<>();
        List<Integer> subB = new ArrayList<>();

        for (int i = 0; i < A.length; i++) {
            int sum = 0;
            for (int j = i; j < A.length; j++) {
                sum += A[j];
                if (sum < T) {
                    subA.add(sum);
                }
            }
        }

        for (int i = 0; i < B.length; i++) {
            int sum = 0;
            for (int j = i; j < B.length; j++) {
                sum += B[j];
                if (sum < T) {
                    subB.add(sum);
                }
            }
        }

        for (int v : subA) {
            if (subB.indexOf(T - v) > -1) {
                cnt++;
            }
        }

        System.out.println(cnt);
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