import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2438 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int repeat = Integer.parseInt(bf.readLine());
        for (int i = 1; i <= repeat; i++) {
            sb.append(new String("*").repeat(i) + "\n");
        }
        System.out.print(sb);
        bf.close();
    }
}
