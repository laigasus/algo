
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringJoiner;

class S2056 {
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] chars = br.readLine().toCharArray();

        StringJoiner sj = new StringJoiner(" ");

        for (char c : chars) {
            sj.add(String.valueOf(c - 64));
        }

        System.out.println(sj);
    }
}