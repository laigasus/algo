import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int ASCENDING = 12345678, DESCENDING = 87654321;

        int rs = Integer.parseInt(br.readLine().replace(" ", ""));

        if (rs == ASCENDING) {
            System.out.println("ascending");
        } else if (rs == DESCENDING) {
            System.out.println("descending");
        } else {
            System.out.println("mixed");
        }
    }
}