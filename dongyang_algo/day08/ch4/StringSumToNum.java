package day08.ch4;

// 시간 복잡도 O(N)
public class StringSumToNum {
    public static void main(String[] args) {
        int sum = 0;
        String str = "10987654321";
        for (var n : str.split("")) {
            sum += Integer.valueOf(n);
        }

        System.out.println("총합>" + sum);
    }
}
