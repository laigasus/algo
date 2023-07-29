import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class P12891 {
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

        int[] alphabets = new int[ALPHABETS];
        for (int i = 0; i < P; i++) {
            alphabets[str.charAt(i) - 'A']++;
        }
        cntValid(alphabets);

        for (int i = 1; i <= S - P; i++) {
            alphabets[str.charAt(i - 1) - 'A']--;
            alphabets[str.charAt(i + P - 1) - 'A']++;
            cntValid(alphabets);
        }

        System.out.println(cnt);
    }

    static void cntValid(int[] alphabets) {
        for (char c : DNA) {
            if (alphabets[c - 'A'] < requireDNA.get(c)) {
                return;
            }
        }
        cnt++;
    }
}