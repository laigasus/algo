package day15.ch9;

public class Bitwise2 {
    public static String solution(String str) {
        String rs="";
        for(char s: str.toCharArray()){
            rs+=(char)(s^32);
        }
        return rs;
    }

    public static void main(String[] args) {
        System.out.println(solution("GeekSfOrgEEKs"));
    }
}
