import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

public class P1141 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] str = new String[N];

        for (int i = 0; i < N; i++) {
            str[i] = br.readLine();
        }

        Arrays.sort(str, Comparator.reverseOrder());

        HashSet<String> set = new HashSet<>();
        for (String s1 : str) {
            if (set.size() == 0) {
                set.add(s1);
                continue;
            }

            boolean available = true;
            for (String s2 : set) {
                if (s2.indexOf(s1) == 0) {
                    available = false;
                    break;
                }
            }
            if (available) {
                set.add(s1);
            }
        }

        System.out.println(set.size());
    }
}