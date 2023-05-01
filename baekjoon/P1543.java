import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1543 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String regex = br.readLine();
        int cnt = 0;
        while (s.contains(regex)) {
            s = s.replaceFirst(regex, "`");
            s = s.substring(s.indexOf('`'), s.length());
            cnt++;
        }
        System.out.println(cnt);
    }
}
