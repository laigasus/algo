package day09;

public class Bitwise1 {
    public static void main(String[] args) {
        int n=11;
        if((n^1)==(n+1)){
            System.out.println("짝수");
        }else{
            System.out.println("홀수");
        }
    }
}
