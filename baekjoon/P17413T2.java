import java.util.Stack;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class P17413T2 {

    @ParameterizedTest
    @MethodSource("provideStrings")
    @DisplayName("단어 뒤집기 2")
    void P17413Test(String input, String expected) {
        P17413 p17413 = new P17413();
        String actual = p17413.calc(input);

        Assertions.assertEquals(expected, actual);
    }

    private static Stream<Arguments> provideStrings() {
        return Stream.of(
                Arguments.of("baekjoon online judge", "noojkeab enilno egduj"),
                Arguments.of("<open>tag<close>", "<open>gat<close>"),
                Arguments.of("<ab cd>ef gh<ij kl>", "<ab cd>fe hg<ij kl>"),
                Arguments.of("one1 two2 three3 4fourr 5five 6six", "1eno 2owt 3eerht rruof4 evif5 xis6"),
                Arguments.of("<int><max>2147483647<long long><max>9223372036854775807",
                        "<int><max>7463847412<long long><max>7085774586302733229"),
                Arguments.of("<problem>17413<is hardest>problem ever<end>",
                        "<problem>31471<is hardest>melborp reve<end>"),
                Arguments.of("<   space   >space space space<    spa   c e>",
                        "<   space   >ecaps ecaps ecaps<    spa   c e>"));
    }

    public class P17413 {
        static Stack<Character> st = new Stack<>();
        static StringBuilder sb = new StringBuilder();

        String calc(String s) {
            sb.setLength(0);
            boolean isTagInside = false;

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                if (c == '<' || c == '>') {
                    isTagInside = !isTagInside;
                    printStack();
                    sb.append(c);
                    continue;
                }

                if (isTagInside) {
                    sb.append(c);
                } else {
                    if (c == ' ') {
                        printStack();
                        sb.append(" ");
                    } else {
                        st.push(c);
                    }
                }
            }
            printStack();

            System.out.println(sb);
            return sb.toString();
        }

        static void printStack() {
            while (!st.isEmpty()) {
                sb.append(st.pop());
            }
        }
    }
}