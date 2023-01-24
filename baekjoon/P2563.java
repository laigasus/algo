import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class P2563 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        final int canvasSize = 100;
        final int paperSize = 10;
        int[][] canvas = new int[canvasSize][canvasSize];
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            for (int j = 0; j < paperSize; j++) {
                for (int k = 0; k < paperSize; k++) {
                    canvas[y + j][x + k] = 1;
                }
            }
        }
        br.close();
        System.out.println(Arrays.stream(canvas).mapToInt(arr1D -> IntStream.of(arr1D).sum()).sum());
    }
}
