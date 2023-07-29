import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class P12891F {
    static final int ALPHABETS = 26;
    static final char[] DNA = { 'A', 'C', 'G', 'T' };

    static HashMap<Character, Integer> requireDNA;
    static String str;
    static int cnt;

    static {
        requireDNA = new HashMap<>(DNA.length);
        cnt = 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        str = br.readLine();
        st = new StringTokenizer(br.readLine());

        for (char c : DNA) {
            requireDNA.put(c, Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i <= S - P; i++) {
            cntValid(i, i + P);
        }

        System.out.println(cnt);
    }

    static void cntValid(int start, int end) {
        int[] alphabets = new int[26];
        for (int i = start; i < end; i++) {
            alphabets[str.charAt(i) - 'A']++;
        }

        for (char c : DNA) {
            if (alphabets[c - 'A'] < requireDNA.get(c)) {
                return;
            }
        }
        cnt++;
    }
}