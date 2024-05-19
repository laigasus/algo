
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

class S4047 {
    static Map<Character, int[]> deck;
    static final int LEN = 3, CARDS = 13;
    static final char[] PATTERNS = { 'S', 'D', 'H', 'C' };
    static StringBuilder sb = new StringBuilder();

    public static void main(String args[]) throws Exception {

        System.setIn(new FileInputStream("res/input.txt"));

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            deck = new LinkedHashMap<>();
            for (final char pattern : PATTERNS) {
                deck.put(pattern, new int[CARDS + 1]);
            }

            // 카드 주어진 수 3자리 끊어서 계산
            String str = sc.next();
            boolean valid = true;
            for (int i = 0; i <= str.length() - LEN; i += LEN) {
                String card = str.substring(i, i + LEN);

                char pattern = card.charAt(0);
                int num = Integer.parseInt(card.substring(1, 3));

                if (deck.get(pattern)[num] >= 1) {
                    valid = false;
                    break;
                }
                deck.get(pattern)[num]++;
            }

            // 모자란 개수 출력
            StringBuilder result = new StringBuilder();
            for (final char pattern : PATTERNS) {
                int needs = CARDS - Arrays.stream(deck.get(pattern)).sum();
                result.append(needs).append(' ');
            }

            sb.append(String.format("#%d %s\n", test_case, valid ? result : "ERROR"));
        }

        System.out.print(sb);
    }
}