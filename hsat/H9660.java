public class H9660 {
    private static final String[] LETTER_H = {
            "##  ##",
            "##  ##",
            "##  ##",
            "######",
            "##  ##",
            "##  ##",
            "##  ##"
    };
    private static final String[] LETTER_A = {
            "  ##  ",
            " #### ",
            "##  ##",
            "######",
            "##  ##",
            "##  ##",
            "##  ##"
    };
    private static final String[] LETTER_P = {
            "##### ",
            "##  ##",
            "##  ##",
            "##### ",
            "##    ",
            "##    ",
            "##    "
    };
    private static final String[] LETTER_Y = {
            "##  ##",
            "##  ##",
            "##  ##",
            " #### ",
            "  ##  ",
            "  ##  ",
            "  ##  "
    };
    private static final String[] LETTER_X = {
            "##  ##",
            "##  ##",
            " #### ",
            "  ##  ",
            " #### ",
            "##  ##",
            "##  ##",
    };
    private static final String[] LETTER_M = {
            "##   ##",
            "### ###",
            "#######",
            "## # ##",
            "##   ##",
            "##   ##",
            "##   ##"
    };
    private static final String[] LETTER_S = {
            " #### ",
            "##  ##",
            "##    ",
            " #### ",
            "    ##",
            "##  ##",
            " #### "
    };
    private static final String[] LETTER_SPACE = {
            "      ",
            "      ",
            "      ",
            "      ",
            "      ",
            "      ",
            "      "
    };
    private static final String[] LETTER_DASH = {
            "      ",
            "      ",
            "      ",
            "######",
            "      ",
            "      ",
            "      "
    };

    private static String[] getLetterPattern(char ch) {
        switch (Character.toUpperCase(ch)) {
            case 'H':
                return LETTER_H;
            case 'A':
                return LETTER_A;
            case 'P':
                return LETTER_P;
            case 'Y':
                return LETTER_Y;
            case 'X':
                return LETTER_X;
            case 'M':
                return LETTER_M;
            case 'S':
                return LETTER_S;
            case ' ':
                return LETTER_SPACE;
            case '-':
                return LETTER_DASH;
            default:
                return LETTER_SPACE;
        }
    }

    public static void main(String[] args) {

        String input = "HAPPY X-MAS";

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 7; i++) {
            for (char ch : input.toCharArray()) {
                String[] pattern = getLetterPattern(ch);
                sb.append(String.format("%-9s", pattern[i]));
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }
}