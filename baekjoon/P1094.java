import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1094 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(Integer.bitCount(Integer.parseInt(br.readLine())));
    }
}