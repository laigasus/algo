import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class P1269 {

    public static void main(String[] args) throws IOException {
        Set<Integer> A = new HashSet<>(), B = new HashSet<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();

        init(A, br.readLine());
        init(B, br.readLine());
        br.close();

        Set<Integer> tmp = new HashSet<>(A);
        A.removeAll(B);
        B.removeAll(tmp);

        System.out.println(A.size() + B.size());
    }

    static void init(Set<Integer> set, String str) {
        set.addAll(new ArrayList<>(
                Arrays.stream(str.split(" ")).mapToInt(s -> Integer.valueOf(s)).boxed().collect(Collectors.toList())));
    }
}
