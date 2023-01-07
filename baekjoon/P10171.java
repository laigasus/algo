import java.util.Arrays;
import java.util.List;

public class P10171 {
    public static void main(String[] args) {
        List<String> imoji = Arrays.asList("\\    /\\", " )  ( ')", "(  /  )", " \\(__)|");
        imoji.forEach(System.out::println);
    }
}
