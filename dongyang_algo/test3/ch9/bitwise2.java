package test3.ch9;

public class bitwise2 {
    public static void main(String[] args) {
        String str = "GeekSfOrgEEKs";
        str.chars().mapToObj(i -> (char) (i ^ 32)).toList().forEach(System.out::print);
    }
}
