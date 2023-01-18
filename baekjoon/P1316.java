import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = 0;
        Set<String> set;
        String str;
        StringBuilder sb;
        int len = Integer.parseInt(br.readLine());

        for (int i = 0; i < len; i++) {
            str = br.readLine();
            sb = new StringBuilder();
            for (int j = 0; j < str.length(); j++) {
                while (j < str.length() - 1 && str.charAt(j) == str.charAt(j + 1)) {
                    j++;
                }
                sb.append(str.charAt(j));
            }
            set = new HashSet<>(Arrays.asList(sb.toString().split("")));
            if (sb.length() == set.size())
                cnt++;
        }

        System.out.println(cnt);
    }
}
