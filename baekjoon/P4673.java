import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P4673 {
    final static int limit = 10000;
    static List<Integer> list = new ArrayList<>(IntStream.rangeClosed(1, limit).boxed().collect(Collectors.toList()));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        for (int i = 1; i <= limit; i++) {
            removeConstructor(i);
        }
        list.forEach(i -> sb.append(i + "\n"));
        System.out.print(sb);
    }

    static void removeConstructor(int n) {
        int sum = 0;
        if (n < 10) {
            sum = n + n;
        } else {
            sum = n + Arrays.stream((n + "").split("")).mapToInt(s -> Integer.parseInt(s)).sum();
        }
        int idx = list.indexOf(sum);
        if (idx > -1)
            list.remove(idx);
    }
}
