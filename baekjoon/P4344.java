import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P4344 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int classRoom = Integer.parseInt(br.readLine());

        List<Integer> students;

        for (int i = 0; i < classRoom; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            students = new ArrayList<>(n);
            while (st.hasMoreTokens()) {
                students.add(Integer.parseInt(st.nextToken()));
            }
            double avg = students.stream().mapToInt(e -> e).average().getAsDouble();
            double mmr = students.stream().filter(e -> e > avg).count() * 100.0 / n ;
            sb.append(String.format("%.3f%%\n", mmr));
        }
        br.close();
        System.out.print(sb);
    }
}
