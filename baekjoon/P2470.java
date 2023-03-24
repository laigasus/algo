import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2470 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int left = 0, right = arr.length - 1;
        int gap = Integer.MAX_VALUE;
        int rs1 = 0, rs2 = 0;

        int sum, tmp;
        while (left < right) {
            sum = arr[left] + arr[right];
            tmp = Math.abs(sum);
            if (tmp < gap) {
                gap = tmp;
                rs1 = arr[left];
                rs2 = arr[right];
            }
            if (sum > 0) {
                right--;
            } else {
                left++;
            }
        }

        System.out.println(rs1 + " " + rs2);
    }
}