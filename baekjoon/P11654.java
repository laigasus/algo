import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P11654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        br.close();
        System.out.println(0 ^ str.charAt(0));
    }
}
