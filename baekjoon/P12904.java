import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P12904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine(), T = br.readLine();

        System.out.println(check(S, T));
    }

    static int check(String S, String T) {
        for (int i = T.length(); i > S.length(); i--) {
            switch (T.charAt(T.length() - 1)) {
                case 'A': {
                    T = task1(T);
                    break;
                }
                case 'B': {
                    T = task2(T);
                    break;
                }
            }
        }
        return T.equals(S) ? 1 : 0;
    }

    static String task1(String s) {
        return s.substring(0, s.length() - 1);
    }

    static String task2(String s) {
        return new StringBuilder(s).delete(s.length() - 1, s.length()).reverse().toString();
    }
}