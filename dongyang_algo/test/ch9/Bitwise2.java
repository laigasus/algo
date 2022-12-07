package test.ch9;

public class Bitwise2 {
    public static void main(String[] args) {
        String str = "GeekSfOrgEEKs";
        str.chars().mapToObj(ch->(char)(ch^32)).forEach(System.out::print);
    }
}
