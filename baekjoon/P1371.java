import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1371 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] alphabet = new int[26];
        String str = "";
        while ((str = br.readLine()) != null) {
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c == ' ') {
                    continue;
                }
                alphabet[c - 97]++;
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < alphabet.length; i++) {
            if (max < alphabet[i]) {
                max = alphabet[i];
            }
        }

        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] == max) {
                sb.append((char) (i + 97));
            }

        }

        System.out.println(sb);
    }
}