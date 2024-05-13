import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

class S1285 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            long N = sc.nextInt();

            TreeMap<Integer, Integer> map = new TreeMap<>();

            while (N-- > 0) {
                int dist = Math.abs(sc.nextInt());
                map.put(dist, map.getOrDefault(dist, 0) + 1);
            }

            Entry<Integer, Integer> first = map.firstEntry();
            sb.append(String.format("#%d %d %d\n", test_case, first.getKey(), first.getValue()));
        }

        System.out.println(sb);
    }

}