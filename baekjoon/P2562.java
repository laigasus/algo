import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P2562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        br.close();
        int max = list.stream().mapToInt(i -> i).max().getAsInt();
        sb.append(max + "\n");
        sb.append(list.indexOf(max)+1 + "\n");

        System.out.print(sb);
    }
}
