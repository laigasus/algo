import java.time.LocalDate;
import java.time.ZoneId;

public class P10699 {
    public static void main(String[] args) {
        System.out.println(LocalDate.now(ZoneId.of("Asia/Seoul")));
    }
}