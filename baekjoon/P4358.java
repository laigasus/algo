import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class P4358 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        TreeMap<String, Integer> map = new TreeMap<>();

        String input;
        int size = 0;
        while ((input = br.readLine()) != null) {
            map.put(input, map.getOrDefault(input, 0) + 1);
            size++;
        }

        StringBuilder sb = new StringBuilder();

        for (String species : map.keySet()) {
            sb.append(String.format("%s %.4f\n", species, map.get(species) * 1.0 / size * 100));
        }

        System.out.print(sb);
    }
}
