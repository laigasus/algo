import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class P2941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> croatiaLang = Arrays.asList("c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=");
        String str = br.readLine();
        for (String s : croatiaLang) {
            str=str.replace(s, "_");
        }
        System.out.println(str.length());
    }
}
