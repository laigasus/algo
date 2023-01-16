import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class P1065 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine()), cnt = 0;
        br.close();
        for (int i = 1; i <= size; i++) {
            if (isCommonDiffSame(Arrays.stream((i + "").split("")).mapToInt(str -> Integer.parseInt(str)).boxed()
                    .collect(Collectors.toList()))) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    static boolean isCommonDiffSame(List<Integer> list) {
        if (list.size() < 3) {
            return true;
        }
        int diff = list.get(1) - list.get(0);
        for (int i = 1; i < list.size() - 1; i++) {
            if (diff != list.get(i + 1) - list.get(i)) {
                return false;
            }
        }
        return true;
    }
}
