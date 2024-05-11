
import java.io.BufferedReader;
import java.io.InputStreamReader;

class S2047 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        StringBuilder sb = new StringBuilder();

        for (char c : str.toCharArray()) {
            if ('a' <= c && c <= 'z') {
                sb.append((char) (c - 32));
            } else {
                sb.append(c);
            }
        }

        System.out.println(sb);
    }
}