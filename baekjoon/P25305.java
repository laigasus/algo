import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class P25305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        List<Integer> list = new ArrayList<>(N);

        st = new StringTokenizer(br.readLine(), " ");
        br.close();

        while (st.hasMoreTokens()) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        list.sort(Comparator.reverseOrder());
        System.out.println(list.get(k - 1));
    }
}
