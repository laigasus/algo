import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P7568 {
    static class Person {
        int x;
        int y;
        int rank;

        public Person(int x, int y) {
            super();
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int rank;
        StringTokenizer st;
        List<Person> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new Person(x, y));
        }
        br.close();

        for (Person p1 : list) {
            rank = 1;
            for (Person p2 : list) {
                if (p1.x < p2.x && p1.y < p2.y) {
                    rank++;
                }
            }
            sb.append(rank + " ");
        }
        System.out.println(sb);
    }
}