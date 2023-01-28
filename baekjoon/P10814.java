import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class P10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        
        List<Member> list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            list.add(new Member(i, age, name));
        }
        br.close();

        Collections.sort(list, new Comparator<Member>() {
            @Override
            public int compare(Member m1, Member m2) {
                if (m1.age == m2.age) {
                    return m1.no - m2.no;
                } else {
                    return m1.age - m2.age;
                }
            }
        });

        list.forEach(m -> sb.append(m.age).append(" ").append(m.name).append("\n"));
        System.out.print(sb);
    }
}

class Member {
    int no;
    int age;
    String name;

    public Member(int no, int age, String name) {
        super();
        this.no = no;
        this.age = age;
        this.name = name;
    }
}
