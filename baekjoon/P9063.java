import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class P9063 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Integer> width = new LinkedList<>(), height = new LinkedList<>();

        StringTokenizer st;
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            width.add(Integer.parseInt(st.nextToken()));
            height.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(width);
        Collections.sort(height);

        int w = width.get(width.size() - 1) - width.get(0);
        int h = height.get(height.size() - 1) - height.get(0);

        System.out.println(w * h);
    }
}