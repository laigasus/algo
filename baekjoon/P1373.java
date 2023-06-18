import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1373 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String bin = br.readLine();

        if (bin.length() % 3 != 0) {
            bin = "0".repeat(3 - bin.length() % 3) + bin;
        }

        int sum = 0;
        for (int i = 0; i < bin.length(); i++) {
            if (bin.charAt(i) == '1') {
                sum = sum + (4 >> (i % 3));
            }
            if ((i + 1) % 3 == 0) {
                sb.append(sum);
                sum = 0;
            }
        }

        System.out.println(sb);
    }
}