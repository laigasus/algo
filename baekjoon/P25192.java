import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;

public class P25192 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Set<String> set = new LinkedHashSet<>();
        int cnt = 0;
        while (N-- > 0) {
            String s = br.readLine();
            if (s.equals("ENTER")) {
                cnt += set.size();
                set.clear();
            } else {
                set.add(s);
            }
        }
        cnt += set.size();
        System.out.println(cnt);
    }
}
