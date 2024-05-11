
import java.util.Scanner;
import java.util.stream.IntStream;

class S2025 {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        System.out.println(IntStream.rangeClosed(1, T).sum());
    }
}