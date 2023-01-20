import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class P2775 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[][] building = initBuilding();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            int K = Integer.parseInt(br.readLine());
            int N = Integer.parseInt(br.readLine());

            sb.append(building[K][N - 1]).append("\n");
        }
        br.close();
        System.out.print(sb);
    }

    static int[][] initBuilding() {
        int capacity = 15;
        int[][] building = new int[capacity][capacity];
        building[0] = IntStream.rangeClosed(1, capacity - 1).boxed().mapToInt(e -> e).toArray();
        for (int i = 1; i < capacity; i++) {
            for (int j = 1; j < capacity; j++) {
                building[i][j - 1] = IntStream.of(Arrays.copyOf(building[i - 1], j)).sum();
            }
        }
        return building;
    }
}
