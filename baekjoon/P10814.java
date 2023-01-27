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
                if (m1.getAge() == m2.getAge()) {
                    return m1.getNo() - m2.getNo();
                } else {
                    return m1.getAge() - m2.getAge();
                }
            }
        });

        list.forEach(m -> sb.append(m.getAge()).append(" ").append(m.getName()).append("\n"));
        System.out.print(sb);
    }
}

class Member {
    int no;
    int age;
    String name;

    public Member(int no, int age, String name) {
        this.no = no;
        this.age = age;
        this.name = name;
    }

    int getNo() {
        return no;
    }

    int getAge() {
        return age;
    }

    String getName() {
        return name;
    }

}
