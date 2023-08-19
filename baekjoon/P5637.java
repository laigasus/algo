import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P5637 {
    static final String SPACE = " ";
    static final String EOL = "E-N-D";
    static final String REGEX_ONLY_ALPHABET_AND_HYPE = "[a-zA-Z-]+";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String longestWordFirst = "";

        loop: while (true) {
            Pattern pattern = Pattern.compile(REGEX_ONLY_ALPHABET_AND_HYPE);
            Matcher matcher = pattern.matcher(br.readLine().trim());
            while (matcher.find()) {
                String word = matcher.group();
                if (word.endsWith(EOL)) {
                    break loop;
                }
                if (word.length() > longestWordFirst.length()) {
                    longestWordFirst = word;
                }
            }
        }

        System.out.println(longestWordFirst.toLowerCase());
    }
}