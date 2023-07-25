import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class P1475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] freq = new int[10];

        for (char c : br.readLine().toCharArray()) {
            freq[c - '0']++;
        }

        int sixNineFreq = freq[6] + freq[9];
        sixNineFreq = sixNineFreq / 2 + sixNineFreq % 2;
        freq[6] = freq[9] = sixNineFreq;

        System.out.println(IntStream.of(freq).max().getAsInt());
    }
}