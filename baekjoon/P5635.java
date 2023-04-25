import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class P5635 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Person> list = new ArrayList<>();

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int d = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list.add(new Person(name, d, m, y));
        }

        Comparator<Person> comparator = new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return Period.between(p1.ld, p2.ld).isNegative() ? -1 : 1;
            }
        };

        Collections.sort(list, comparator);

        System.out.println(list.get(0).name);
        System.out.println(list.get(n - 1).name);
    }

}

class Person {
    String name;
    LocalDate ld;

    public Person(String name, int d, int m, int y) {
        this.name = name;
        this.ld = LocalDate.of(y, m, d);
    }
}
