import java.io.BufferedReader;
import java.io.InputStreamReader;

class S2007 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        final int MAX_MADI = 10;
        StringBuilder sb = new StringBuilder();
        for (int test_case = 1; test_case <= T; test_case++) {
            int result = 0;
            String str = br.readLine();
            for (int madi = 1; madi < MAX_MADI; madi++) {
                if (isValid(str, madi)) {
                    result = madi;
                    break;
                }
            }
            sb.append("#" + test_case + " " + result + "\n");
        }

        System.out.println(sb);
    }

    private static boolean isValid(String str, int madi) {
        String a = str.substring(0, madi);
        String b = str.substring(madi, madi * 2);
        return a.equals(b);
    }
}