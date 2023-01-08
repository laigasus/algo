import java.util.Arrays;
import java.util.List;

public class P10172 {
    public static void main(String[] args) {
        List<String> imojiDog = Arrays.asList("|\\_/|", "|q p|   /}", "( 0 )\"\"\"\\", "|\"^\"`    |", "||_/=\\\\__|");
        imojiDog.forEach(System.out::println);
    }
}
