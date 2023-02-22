import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P11382 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long sum = 0;

        for (String s : br.readLine().split(" ")) {
            sum += Long.parseLong(s);
        }

        System.out.println(sum);
    }
}
