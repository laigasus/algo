import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P15993F {
    static class Usecase {
        int odd, even;

        public Usecase() {
            this.odd = 0;
            this.even = 0;
        }

    }

    static List<Integer> arr;
    static int n;

    static Usecase usecase;
    static final int DIV = 1_000_000_009;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            arr = new ArrayList<>();
            usecase = new Usecase();

            n = Integer.parseInt(br.readLine());

            count(0);
            sb.append(usecase.odd % DIV)
                    .append(' ')
                    .append(usecase.even % DIV)
                    .append('\n');
        }
        System.out.print(sb);
    }

    private static void count(int sum) {
        if (sum > n) {
            return;
        }

        if (sum == n) {
            switch (arr.size() % 2) {
                case 0 -> usecase.even++;
                default -> usecase.odd++;
            }
            return;
        }

        for (int num : List.of(1, 2, 3)) {
            arr.add(num);
            count(sum + num);
            arr.remove(arr.size() - 1);
        }
    }
}
