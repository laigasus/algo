import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class P14889 {
    static int[][] graph;
    static int N;
    static int[] members;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        members = new int[N / 2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        calc(0, 1);

        System.out.println(min);
    }

    static void calc(int num, int depth) {
        if (depth > N / 2) {
            int[] opponents = IntStream.range(0, N).filter(opponent -> !isPresent(opponent)).toArray();

            int membersTotal = sumSynergy(members);
            int opponentsTotal = sumSynergy(opponents);
            int diff = Math.abs(opponentsTotal - membersTotal);
            min = Math.min(min, diff);
            return;
        }

        for (int idx = num; idx < N; idx++) {
            members[depth - 1] = idx;
            calc(idx + 1, depth + 1);
        }
    }

    static int sumSynergy(int[] arr) {
        int sum = 0;
        for (int a = 0; a < arr.length - 1; a++) {
            for (int b = a + 1; b < arr.length; b++) {
                sum += graph[arr[a]][arr[b]] + graph[arr[b]][arr[a]];
            }
        }
        return sum;
    }

    static boolean isPresent(int o) {
        for (int member : members) {
            if (o == member) {
                return true;
            }
        }
        return false;
    }
}