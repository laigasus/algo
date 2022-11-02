package day09;

public class Bitwise2 {
    public static void main(String[] args) {
        String str = "GeekSfOrgEEKs";
        String rs = "";
        for (char s : str.toCharArray()) {
            s = (char) ((int) s ^ 32);
            rs += s;
        }
        System.out.println(rs);
    }
}
