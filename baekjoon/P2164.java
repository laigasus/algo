import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayDeque<Integer> arr = new ArrayDeque<>(IntStream.rangeClosed(1, N).boxed().collect(Collectors.toList()));

        while (arr.size() > 1) {
            arr.removeFirst();
            arr.add(arr.pollFirst());
        }
        System.out.println(arr.getFirst());
    }
}
