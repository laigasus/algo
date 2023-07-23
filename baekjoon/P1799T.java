import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class P1799T {
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
    @DisplayName("보드 면적 3")
    public void chk1() throws IOException {
        String s = """
                3
                0 1 1
                1 1 1
                1 1 1
                """;
        insertConsole(s);
        String expected = "4";

        P1799.main(null);

        String actual = outputStreamCaptor.toString().trim();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("보드 면적 4")
    public void chk2() throws IOException {
        String s = """
                4
                1 1 1 1
                1 1 1 1
                1 1 1 1
                1 1 1 1
                    """;
        insertConsole(s);
        String expected = "6";

        P1799.main(null);

        String actual = outputStreamCaptor.toString().trim();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("보드 면적 5")
    public void chk3() throws IOException {
        String s = """
                5
                1 1 1 1 1
                1 1 1 1 1
                1 1 1 1 1
                1 1 1 1 1
                1 1 1 1 1
                    """;
        insertConsole(s);
        String expected = "8";

        P1799.main(null);

        String actual = outputStreamCaptor.toString().trim();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("보드 면적 8")
    public void chk4() throws IOException {
        String s = """
                8
                1 1 1 1 1 1 1 1
                1 1 1 1 1 1 1 1
                1 1 1 1 1 1 1 1
                1 1 1 1 1 1 1 1
                1 1 1 1 1 1 1 1
                1 1 1 1 1 1 1 1
                1 1 1 1 1 1 1 1
                1 1 1 1 1 1 1 1
                    """;
        insertConsole(s);
        String expected = "14";

        P1799.main(null);

        String actual = outputStreamCaptor.toString().trim();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("보드 면적 최대 10")
    public void chk5() throws IOException {
        String s = """
                10
                1 1 1 1 1 1 1 1 1 1
                1 1 1 1 1 1 1 1 1 1
                1 1 1 1 1 1 1 1 1 1
                1 1 1 1 1 1 1 1 1 1
                1 1 1 1 1 1 1 1 1 1
                1 1 1 1 1 1 1 1 1 1
                1 1 1 1 1 1 1 1 1 1
                1 1 1 1 1 1 1 1 1 1
                1 1 1 1 1 1 1 1 1 1
                1 1 1 1 1 1 1 1 1 1
                    """;
        insertConsole(s);
        String expected = "18";

        P1799.main(null);

        String actual = outputStreamCaptor.toString().trim();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("놓을 수 없는 칸1")
    public void chk6() throws IOException {
        String s = """
                5
                1 1 0 1 1
                0 1 0 0 1
                1 0 1 0 1
                1 0 0 0 0
                1 0 1 1 1
                        """;
        insertConsole(s);
        String expected = "8";

        P1799.main(null);

        String actual = outputStreamCaptor.toString().trim();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("놓을 수 없는 칸2")
    public void chk7() throws IOException {
        String s = """
                5
                0 0 0 0 0
                0 1 0 1 0
                1 0 0 0 1
                0 1 0 1 0
                0 0 0 0 0
                            """;
        insertConsole(s);
        String expected = "3";

        P1799.main(null);

        String actual = outputStreamCaptor.toString().trim();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("놓을 수 없는 칸3")
    public void chk8() throws IOException {
        String s = """
                5
                0 0 0 1 0
                0 0 1 0 0
                0 1 0 1 0
                0 0 1 0 0
                0 0 0 1 0
                            """;
        insertConsole(s);
        String expected = "3";

        P1799.main(null);

        String actual = outputStreamCaptor.toString().trim();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("놓을 수 없는 칸4")
    public void chk9() throws IOException {
        String s = """
                5
                1 1 0 1 1
                0 1 0 0 0
                1 0 1 0 1
                1 0 0 0 0
                1 0 1 1 1
                                """;
        insertConsole(s);
        String expected = "7";

        P1799.main(null);

        String actual = outputStreamCaptor.toString().trim();
        Assertions.assertEquals(expected, actual);
    }
}