import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1099 {
    static final int MAX_SIZE = 50;
    static int[][] alphabet;
    static String[] words;
    static String str;
    static int[] dp;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();

        N = Integer.parseInt(br.readLine());
        alphabet = new int[N][26];
        words = new String[N];
        dp = new int[str.length() + 1];
        Arrays.fill(dp, MAX_SIZE + 1);

        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                alphabet[i][words[i].charAt(j) - 'a']++;
            }
        }

        dp[0] = 0;
        calc();
        System.out.println(dp[str.length()] <= MAX_SIZE ? dp[str.length()] : -1);
    }

    static void calc() {
        for (int start = 0; start < str.length(); start++) {
            for (int idx = 0; idx < N; idx++) {
                int len = words[idx].length();
                int end = start + len;

                if (end > str.length()) {
                    continue;
                }
                if (chkFullyContains(idx, start, end)) {
                    dp[end] = Math.min(dp[end], dp[start] + cntDiffs(idx, start, end));
                }
            }
        }
    }

    static int cntDiffs(int idx, int start, int end) {
        int cnt = 0;
        String word = words[idx];
        int wordIdx = 0;

        for (int i = start; i < end; i++) {
            if (str.charAt(i) != word.charAt(wordIdx)) {
                cnt++;
            }
            wordIdx++;
        }

        return cnt;
    }

    static boolean chkFullyContains(int idx, int start, int end) {
        int[] arr = alphabet[idx].clone();

        for (int i = start; i < end; i++) {
            if (arr[str.charAt(i) - 'a'] > 0) {
                arr[str.charAt(i) - 'a']--;
            } else {
                return false;
            }
        }

        return true;
    }
}