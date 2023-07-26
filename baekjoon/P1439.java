import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        long[] freq = new long[2];

        freq[0] = Arrays.stream(s.split("0")).filter(str -> !str.isBlank()).count();
        freq[1] = Arrays.stream(s.split("1")).filter(str -> !str.isBlank()).count();

        System.out.println(Math.min(freq[0], freq[1]));
    }
}
