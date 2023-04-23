import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P23037 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;

        for (String s : br.readLine().split("")) {
            sum += Math.pow(Double.parseDouble(s), 5);
        }

        System.out.println(sum);
    }
}