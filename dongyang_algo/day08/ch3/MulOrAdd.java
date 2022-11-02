package day08.ch3;

// 시간 복잡도 O(N)
public class MulOrAdd {
    public static void main(String[] args) {
        String str = "02984";
        int sum = 0, num = 0;
        for (var c : str.split("")) {
            num = Integer.parseInt(c);
            if (sum == 0 || num == 0) {
                sum += num;
            } else {
                sum *= num;
            }
        }

        System.out.println("결과>" + sum);
    }
}