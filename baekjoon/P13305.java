import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P13305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[] distances = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long[] costs = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

        long totalCost = costs[0] * distances[0];
        long minCost = costs[0];
        for (int i = 1; i < N - 1; i++) {
            if (costs[i] < minCost) {
                minCost = costs[i];
            }

            totalCost += (minCost * distances[i]);
        }
        System.out.println(totalCost);
        br.close();
    }
}
