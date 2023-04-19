import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P23627 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String compareStr = "driip";

        String str = br.readLine();
        if (str.length() < compareStr.length()) {
            System.out.println("not cute");
            return;
        }

        str = str.substring(str.length() - compareStr.length(), str.length());
        if (str.equals(compareStr)) {
            System.out.println("cute");
        } else {
            System.out.println("not cute");
        }
    }
}
