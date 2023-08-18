import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P12904 {
    static final int YES = 1, NO = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine(), T = br.readLine();

        System.out.println(isValidToChangeStoT(S, T));
    }

    static int isValidToChangeStoT(String S, String T) {
        for (int i = T.length(); i > S.length(); i--) {
            switch (T.charAt(T.length() - 1)) {
                case 'A':
                    T = appendA(T);
                    break;

                case 'B':
                    T = reverseAndAppendB(T);
            }
        }
        return T.equals(S) ? YES : NO;
    }

    private static String appendA(String s) {
        return s.substring(0, s.length() - 1);
    }

    private static String reverseAndAppendB(String s) {
        return new StringBuilder(s).delete(s.length() - 1, s.length()).reverse().toString();
    }
}