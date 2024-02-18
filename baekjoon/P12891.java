import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class P12891 {
    public static void main(String[] args) throws IOException {
        final char[] dna = { 'A', 'C', 'G', 'T' };

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        final int S = Integer.parseInt(st.nextToken());
        final int P = Integer.parseInt(st.nextToken());

        String str = br.readLine();

        st = new StringTokenizer(br.readLine());

        Map<Character, Integer> require = new LinkedHashMap<>();
        Map<Character, Integer> current = new LinkedHashMap<>();

        for (char key : dna) {
            require.put(key, Integer.parseInt(st.nextToken()));
            current.put(key, 0);
        }

        for (int i = 0; i < P; i++) {
            char c = str.charAt(i);
            current.replace(c, current.get(c) + 1);
        }

        int result = checkValid(dna, current, require);

        for (int i = P; i < S; i++) {
            current.replace(str.charAt(i - P), current.get(str.charAt(i - P)) - 1);
            current.replace(str.charAt(i), current.get(str.charAt(i)) + 1);

            result += checkValid(dna, current, require);
        }

        System.out.println(result);

    }

    private static int checkValid(final char[] dna, Map<Character, Integer> current, Map<Character, Integer> require) {
        for (var key : dna) {
            if (current.get(key) < require.get(key)) {
                return 0;
            }
        }
        return 1;
    }
}