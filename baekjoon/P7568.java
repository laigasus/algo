import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P7568 {
    private static class Person {
        int x, y;

        public Person(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        List<Person> persons = new ArrayList<>();

        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            persons.add(new Person(x, y));
        }

        for (var p1 : persons) {
            int rank = 1;
            for (var p2 : persons) {
                if (p1.x < p2.x && p1.y < p2.y) {
                    rank++;
                }
            }
            sb.append(rank + " ");
        }

        System.out.println(sb.toString().trim());
    }
}