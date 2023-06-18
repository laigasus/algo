import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] val = { "000", "001", "010", "011", "100", "101", "110", "111" };

        String octal = br.readLine();

        for (int i = 0; i < octal.length(); i++) {
            sb.append(val[octal.charAt(i) - '0']);
        }

        switch (octal.charAt(0)) {
            case '0':
            case '1':
                sb.delete(0, 2);
                break;
            case '2':
            case '3':
                sb.deleteCharAt(0);
                break;
        }

        System.out.println(sb);
    }
}