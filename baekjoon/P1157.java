import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class P1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Character> list = br.readLine().toUpperCase().chars().mapToObj(i -> (char) i).collect(Collectors.toList());
        br.close();
        Set<Character> alphabet = new HashSet<>(list);
        String rs = new String();
        int max = 0;
        for (char s : alphabet) {
            int frequency = Collections.frequency(list, s);
            if (frequency == max) {
                rs = new String("?");
            } else {
                if (frequency > max) {
                    max = frequency;
                    rs = String.valueOf(s);
                }
            }
        }
        System.out.println(rs);
    }
}
