package test2.ch11;

public class CompressAndFindShortestLength {
    public static void main(String[] args) {
        String str = "aabbaccc";
        String rs = "";
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            int cnt = 1;
            while (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
                cnt++;
                i++;
            }
            rs += (cnt == 1 ? "" : cnt) + "" + str.charAt(i);
            sum += (cnt == 1 ? 0 : cnt);
        }
        System.out.println(rs);
        System.out.println(sum);
    }
}
