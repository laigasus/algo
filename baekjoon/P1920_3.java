import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1920_3 {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        while (M-- > 0) {
            int num = Integer.parseInt(st.nextToken());
            int result = binarySearch(num);
            sb.append(result == -1 ? 0 : 1).append('\n');
        }

        System.out.print(sb);
    }

    private static int binarySearch(int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            int num = arr[mid];

            if (num > target) {
                right = mid - 1;
            } else if (num == target) {
                return mid;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }
}