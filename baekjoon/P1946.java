import java.io.IOException;

public class P1946 {
    static int N;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        int T = readInt();

        while (T-- > 0) {
            N = readInt();
            int[] interviewScores = new int[N + 1];

            for (int i = 1; i <= N; i++) {
                int resume = readInt();
                int interview = readInt();
                interviewScores[resume] = interview;
            }

            int cnt = 1;
            int bestResume$Interview = interviewScores[1];
            for (int i = 2; i <= N; i++) {
                if (interviewScores[i] < bestResume$Interview) {
                    bestResume$Interview = interviewScores[i];
                    cnt++;
                }
            }

            sb.append(cnt).append('\n');
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