import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P11720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer.parseInt(br.readLine());
        int sum = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).sum();
        System.out.println(sum);
        br.close();
    }
}
