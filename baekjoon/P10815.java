import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.BitSet;
import java.util.StringTokenizer;

public class P10815 {

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        br.readLine();
        BitSet cards = new BitSet();

        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            cards.set(Integer.parseInt(st.nextToken()) + 10000000);
        }

        br.readLine();
        st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()) {
            sb.append(cards.get(Integer.parseInt(st.nextToken()) + 10000000) ? 1 : 0).append(" ");
        }
        br.close();

        System.out.println(sb);
    }
}
