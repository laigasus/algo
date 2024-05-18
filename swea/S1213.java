import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

class S1213 {
    static StringBuilder sb = new StringBuilder();

    static Map<Character, Character> brackets = new HashMap<>();

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = 10;

        for (int test_case = 1; test_case <= T; test_case++) {
            Integer.parseInt(br.readLine());

            String sub = br.readLine();
            String str = br.readLine().replaceAll(sub, "#");

            int result = 0;

            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '#') {
                    result++;
                }
            }

            sb.append(String.format("#%d %d\n", test_case, result));
        }

        System.out.println(sb);
    }
}