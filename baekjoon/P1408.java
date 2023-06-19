import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1408 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int s = parse(br.readLine()), e = parse(br.readLine());
        int diff = e > s ? e - s : (24 * 3600) - (s - e);

        System.out.format("%02d:%02d:%02d", (diff / 3600), ((diff / 60) % 60), (diff % 60));
    }

    static int parse(String str) {
        StringTokenizer st = new StringTokenizer(str, ":");
        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        return (h * 3600) + (m * 60) + s;
    }
}
