import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P10816 {
    final static int boundary = 10000000;
    static int[] cards = new int[boundary * 2 + 1];
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        task(true);
        task(false);
        br.close();
        System.out.println(sb);
    }

    static void task(boolean flag) throws IOException {
        br.readLine();
        for (String s : br.readLine().split(" ")) {
            int num = Integer.parseInt(s);
            if (flag) {
                cards[boundary + num]++;
            } else {
                sb.append(cards[boundary + num]).append(" ");
            }
        }
    }
}
