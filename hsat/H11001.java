import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class H11001 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<String> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            list.add(str);
        }

        Collections.sort(list, (a, b) -> {
            String[] strs1 = a.split("\\.");
            String[] strs2 = b.split("\\.");

            if (!strs1[0].equals(strs2[0])) {
                return Integer.parseInt(strs1[0]) - Integer.parseInt(strs2[0]);
            } else if (strs1.length == 1 || strs2.length == 1) {
                return strs1.length - strs2.length;
            } else {
                return Integer.parseInt(strs1[1]) - Integer.parseInt(strs2[1]);
            }
        });

        StringBuilder sb = new StringBuilder();
        list.forEach(e -> sb.append(e).append('\n'));

        System.out.print(sb);
    }
}
