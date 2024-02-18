import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class P1384 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n;

        for (int repeat = 1; (n = Integer.parseInt(br.readLine())) != 0; repeat++) {
            sb.append("Group ").append(repeat).append('\n');

            Map<Integer, String> contestants = new HashMap<>();
            Map<Integer, List<Integer>> negatives = new HashMap<>();

            for (int i = 1; i <= n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String contestant = st.nextToken();

                contestants.put(i, contestant);
                Sequence sequence = new Sequence(n, i - 1);

                for (int j = 1; j <= n - 1; j++) {
                    char msg = st.nextToken().charAt(0);
                    int idx = sequence.next();

                    if (msg == 'N') {
                        negatives.computeIfAbsent(i, k -> new ArrayList<>()).add(idx);
                    }
                }
            }

            if (negatives.isEmpty()) {
                sb.append("Nobody was nasty\n\n");
                continue;
            }

            for (var negative : negatives.entrySet()) {
                String A = contestants.get(negative.getKey());

                for (var hates : negative.getValue()) {
                    String B = contestants.get(hates);
                    sb.append(B).append(" was nasty about ").append(A).append('\n');
                }
            }

            sb.append('\n');
        }

        System.out.print(sb);
    }

    private static class Sequence implements Iterator<Integer> {
        private int size;
        private int current;

        public Sequence(int size, int current) {
            this.size = size;
            this.current = current < 1 ? size : current;
        }

        @Override
        public boolean hasNext() {
            return true;
        }

        @Override
        public Integer next() {
            if (current < 1) {
                current = size;
            }
            return current--;
        }
    }
}
