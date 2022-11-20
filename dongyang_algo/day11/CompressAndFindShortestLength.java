package day11;

public class CompressAndFindShortestLength {
    public static void main(String[] args) {
        String str = "aabbaccc";
        String result="";
        for (int i = 0; i < str.length(); i++) {
            int count = 1;
            while (i < str.length() - 1
                    && str.charAt(i) == str.charAt(i + 1)) {
                count++;
                i++;
            }
            result+=count+""+str.charAt(i);
        }
        System.out.println(result);
    }
}
