import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P10807 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < size && st.hasMoreTokens(); i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        int e = Integer.parseInt(br.readLine());
        br.close();
        System.out.println(list.stream().filter(i -> i == e).count());
    }
}
