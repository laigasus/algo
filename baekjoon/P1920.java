import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class P1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeSet<Integer> treeSet = new TreeSet<>();
        StringBuilder sb = new StringBuilder();
        br.readLine();
        treeSet.addAll(
                Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).boxed()
                        .collect(Collectors.toList()));

        br.readLine();
        for (String s : br.readLine().split(" ")) {
            sb.append(treeSet.contains(Integer.parseInt(s)) ? 1 : 0).append(("\n"));
        }

        System.out.print(sb);
        br.close();
    }
}
