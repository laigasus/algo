import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

class S1948 {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        System.setIn(new FileInputStream("res/input.txt"));
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {

            LocalDate a = init(sc.nextInt(), sc.nextInt());
            LocalDate b = init(sc.nextInt(), sc.nextInt());

            long result = ChronoUnit.DAYS.between(a, b) + 1;

            sb.append("#" + test_case + " " + result + "\n");
        }

        System.out.println(sb);
    }

    private static LocalDate init(int month, int day) {
        return LocalDate.of(1, month, day);
    }

}