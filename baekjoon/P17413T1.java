import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class P17413T1 {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    protected void insertConsole(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    @Test
    @DisplayName("태그 없이 문자열만")
    public void chk1() throws IOException {
        insertConsole("baekjoon online judge");
        String expected = "noojkeab enilno egduj";

        P17413.main(null);

        String actual = outputStreamCaptor.toString().trim();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("태그 있음. 사이에 문자열")
    public void chk2() throws IOException {
        insertConsole("<open>tag<close>");
        String expected = "<open>gat<close>";

        P17413.main(null);

        String actual = outputStreamCaptor.toString().trim();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("태그 있음. 사이에 문자열. 공란 있음")
    public void chk3() throws IOException {
        insertConsole("<ab cd>ef gh<ij kl>");
        String expected = "<ab cd>fe hg<ij kl>";

        P17413.main(null);

        String actual = outputStreamCaptor.toString().trim();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("문자열(숫자+소문자)")
    public void chk4() throws IOException {
        insertConsole("<ab cd>ef gh<ij kl>");
        String expected = "<ab cd>fe hg<ij kl>";

        P17413.main(null);

        String actual = outputStreamCaptor.toString().trim();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("복합 태그 문자")
    public void chk5() throws IOException {
        insertConsole("<int><max>2147483647<long long><max>9223372036854775807");
        String expected = "<int><max>7463847412<long long><max>7085774586302733229";

        P17413.main(null);

        String actual = outputStreamCaptor.toString().trim();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("복합 태그 문자")
    public void chk6() throws IOException {
        insertConsole("<problem>17413<is hardest>problem ever<end>");
        String expected = "<problem>31471<is hardest>melborp reve<end>";

        P17413.main(null);

        String actual = outputStreamCaptor.toString().trim();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("복합 태그 문자")
    public void chk7() throws IOException {
        insertConsole("<   space   >space space space<    spa   c e>");
        String expected = "<   space   >ecaps ecaps ecaps<    spa   c e>";

        P17413.main(null);

        String actual = outputStreamCaptor.toString().trim();
        Assertions.assertEquals(expected, actual);
    }
}