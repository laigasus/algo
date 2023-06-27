import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P1302 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new HashMap<>();

        while (T-- > 0) {
            String title = br.readLine();
            map.put(title, map.getOrDefault(title, 0) + 1);
        }

        List<String> keySet = new ArrayList<>(map.keySet());

        keySet.sort(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int n1 = map.get(s1);
                int n2 = map.get(s2);
                if (n1 == n2) {
                    return s1.compareTo(s2);
                }
                return n2 - n1;
            }
        });

        System.out.println(keySet.get(0));
    }
}