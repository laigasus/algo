import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class P2741 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        IntStream.rangeClosed(1, Integer.parseInt(br.readLine())).forEach(i -> sb.append(i).append('\n'));
        System.out.print(sb);
    }
}
