import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class P2108 {
    static List<Integer> list = new ArrayList<>();
    static IntSummaryStatistics stats;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        init();
        sb.append(avg()).append("\n");
        sb.append(median()).append("\n");
        sb.append(mode()).append("\n");
        sb.append(range()).append("\n");

        System.out.print(sb);
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        br.close();
        Collections.sort(list);
        stats = list.stream().mapToInt(i -> i).summaryStatistics();
    }

    static long avg() {
        return Math.round(stats.getAverage());
    }

    static int median() {
        return list.get(list.size() / 2);
    }

    static int mode() {
        List<Integer> duplicates = new ArrayList<>(
                list.stream().filter(i -> Collections.frequency(list, i) > 1).distinct()
                        .collect(Collectors.toList()));
        if (duplicates.size() > 0) {
            return duplicates.size() == 1 ? duplicates.get(0) : duplicates.get(1);
        } else {
            return list.size() > 1 ? list.get(1) : list.get(0);
        }

    }

    static int range() {
        return stats.getMax() - stats.getMin();
    }
}
