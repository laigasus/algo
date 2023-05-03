import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        int[] arr = new int[n + 1];

        for (int i = 1; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = arr[1];
        if (n > 1) { // 두 잔 이상일 경우
            dp[2] = arr[1] + arr[2];
        }

        for (int i = 3; i < dp.length; i++) {
            int notDrink = dp[i - 1]; // 마시지 않는다, 혹은 이전에 두잔을 마셔서 불가하다
            int drinkFirst = dp[i - 2] + arr[i]; // 마셨는데 첫째잔이었다
            int drinkSecond = dp[i - 3] + arr[i - 1] + arr[i]; // 마셨는데 둘째잔이었다

            dp[i] = Math.max(notDrink, Math.max(drinkFirst, drinkSecond));
        }

        System.out.println(dp[n]);
    }
}
