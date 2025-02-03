import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class P11053_3 {
    private static int[] dp; // 메모이제이션을 위한 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = Stream.of(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        dp = new int[N];
        int length = 0;

        // 각 위치에서 시작하는 LIS 길이를 계산
        for (int i = 0; i < N; i++) {
            length = Math.max(length, lis(arr, i));
        }

        System.out.println(length);
    }

    // 재귀적으로 LIS 길이를 계산하는 함수
    private static int lis(int[] arr, int idx) {
        if (dp[idx] != 0) {
            return dp[idx]; // 이미 계산된 값이 있다면 반환
        }

        dp[idx] = 1; // 최소 길이는 1 (자기 자신)

        // 현재 인덱스 이후의 원소들을 탐색
        for (int i = idx + 1; i < arr.length; i++) {
            if (arr[i] > arr[idx]) {
                dp[idx] = Math.max(dp[idx], lis(arr, i) + 1);
            }
        }

        return dp[idx];
    }
}