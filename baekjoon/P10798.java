import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P10798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        final int len = 5;
        char[][] words = new char[len][];
        int longestWordLen = 0;

        for (int i = 0; i < len; i++) {
            String str = br.readLine();
            longestWordLen = Math.max(longestWordLen, str.length());
            words[i] = str.toCharArray();
        }

        for (int i = 0; i < longestWordLen; i++) {
            for (int j = 0; j < len; j++) {
                try {
                    sb.append(words[j][i]);
                } catch (ArrayIndexOutOfBoundsException e) {

                }
            }
        }

        System.out.println(sb);
    }
}
