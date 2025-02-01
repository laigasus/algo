import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class P21939 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Map<Integer, Integer> problemMap = new HashMap<>();
        TreeMap<Integer, TreeSet<Integer>> difficultyMap = new TreeMap<>();

        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int P = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());

            problemMap.put(P, L);
            difficultyMap.computeIfAbsent(L, k -> new TreeSet<>()).add(P);
        }

        int M = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (M-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String command = st.nextToken();

            if (command.equals("add")) {
                int P = Integer.parseInt(st.nextToken());
                int L = Integer.parseInt(st.nextToken());
                problemMap.put(P, L);
                difficultyMap.computeIfAbsent(L, k -> new TreeSet<>()).add(P);
            } else if (command.equals("solved")) {
                int P = Integer.parseInt(st.nextToken());
                int L = problemMap.get(P);
                problemMap.remove(P);
                TreeSet<Integer> problems = difficultyMap.get(L);
                problems.remove(P);
                if (problems.isEmpty()) {
                    difficultyMap.remove(L);
                }
            } else if (command.equals("recommend")) {
                int x = Integer.parseInt(st.nextToken());
                if (x == 1) {
                    int highestDifficulty = difficultyMap.lastKey();
                    int problem = difficultyMap.get(highestDifficulty).last();
                    sb.append(problem + "\n");
                } else if (x == -1) {
                    int lowestDifficulty = difficultyMap.firstKey();
                    int problem = difficultyMap.get(lowestDifficulty).first();
                    sb.append(problem + "\n");
                }
            }

        }

        System.out.print(sb);
    }
}
