import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class P1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        List<Double> list = new ArrayList<>(size);
        list = Arrays.stream(br.readLine().split(" ")).mapToDouble(i -> Double.parseDouble(i))
                .boxed().collect(Collectors.toList());
        br.close();
        int max = list.stream().mapToInt(i -> (int) Math.round(i)).max().getAsInt();
        list.replaceAll(d -> (d / max * 100));
        double avg = list.stream().mapToDouble(i -> i).average().getAsDouble();
        System.out.println(avg);
    }
}
