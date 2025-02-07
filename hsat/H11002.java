import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class H11002 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] persons = new int[N];

        for (int i = 0; i < N; i++) {
            persons[i] = Integer.parseInt(br.readLine(), 2);
        }

        int cnt = 0;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (Integer.bitCount(persons[i] ^ persons[j]) <= 2) {
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }

}
