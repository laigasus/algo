import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P4948 {
    public static boolean[] primeArr = new boolean[246913];
    public static int[] countArr = new int[246913];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        initPrimeArr();

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            } else {
                sb.append(countArr[2 * n] - countArr[n]).append("\n");
            }
        }
        br.close();
        System.out.print(sb);
    }

    public static void initPrimeArr() {
        primeArr[0] = primeArr[1] = true;

        for (int i = 2; i <= Math.sqrt(primeArr.length); i++) {
            if (primeArr[i])
                continue;
            for (int j = i * i; j < primeArr.length; j += i) {
                primeArr[j] = true;
            }
        }

        int count = 0;
        for (int i = 2; i < primeArr.length; i++) {
            if (!primeArr[i])
                count++;
            countArr[i] = count;
        }
    }
}
