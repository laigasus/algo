package test.ch11;

public class CompressAndFindShortestLength {
    public static void main(String[] args) {
        String str = "aabbaccc";
        String rs = "";

        for (int i = 0; i < str.length(); i++) {
            int cnt = 1;
            while (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
                cnt++;
                i++;
            }
            rs += cnt + "" + str.charAt(i);
        }

        System.out.println(rs);
    }
}
