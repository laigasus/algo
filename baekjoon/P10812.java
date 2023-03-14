import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class P10812 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = IntStream.rangeClosed(1, N).toArray();

        for (int repeat = 0; repeat < M; repeat++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            arr = swap(arr, i, j, k);
        }

        for (int num : arr) {
            sb.append(num).append(' ');
        }
        System.out.println(sb);
    }

    static int[] swap(int[] arr, int begin, int end, int mid) {
        begin--;
        end--;
        mid--;
        int[][] parts = new int[4][];

        parts[0] = Arrays.copyOfRange(arr, 0, begin);
        parts[1] = Arrays.copyOfRange(arr, mid, end + 1);
        parts[2] = Arrays.copyOfRange(arr, begin, mid);
        parts[3] = Arrays.copyOfRange(arr, end + 1, arr.length);
        int[] dest = new int[0];
        for (int[] part : parts) {
            dest = IntStream.concat(IntStream.of(dest), IntStream.of(part)).toArray();
        }
        return dest;
    }
}
