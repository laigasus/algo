import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class P5622 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> dial = Arrays.asList("", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ");
        String str = br.readLine();
        br.close();
        int sum = 0;
        for (String s : str.split("")) {
            for (String a : dial) {
                if (a.contains(s)) {
                    int idx = dial.indexOf(a);
                    sum += idx + 2;
                    break;
                }

            }
        }
        System.out.println(sum);
    }
}
