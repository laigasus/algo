package day03;

import java.util.Arrays;

/**
 * 인하 은행 ATM에서 여러 사람이 돈을 인출할 때 최소 대기시간은?
 * 
 * @author 옥재욱
 * @see 백준 https://www.acmicpc.net/problem/11399
 */
public class ATM {
    public static void main(String[] args) {
        Bank b1 = new InhaBank(3, 1, 4, 3, 2);
        b1.calcMinResTime();
    }
}

interface Bank {
    void calcMinResTime();
}

class InhaBank implements Bank {
    int[] que;

    public InhaBank(int... que) {
        if (validation(que)) {
            this.que = que;
        } else {
            System.exit(0);
        }
    }

    public void calcMinResTime() {
        int resTime = 0;
        int[] copyQue;
        Arrays.sort(que);
        for (int i = 0; i < que.length; i++) {
            copyQue = Arrays.copyOf(que, i + 1);
            resTime += Arrays.stream(copyQue).sum();
        }

        System.out.printf("결과>%d\n", resTime);
    }

    private boolean validation(int[] que) {
        boolean isMaxTaskValid = Arrays.stream(que).max().getAsInt() <= 1000 ? true : false;
        boolean isMinTaskValid = Arrays.stream(que).min().getAsInt() >= 1 ? true : false;
        boolean isQueLengthValid = que.length <= 1000 ? true : false;

        System.err.print(isMaxTaskValid ? "" : "최대값 1000 초과\n");
        System.err.print(isMinTaskValid ? "" : "최소값 1 미만\n");
        System.err.print(isQueLengthValid ? "" : "최대 큐 1000 초과\n");

        return isMaxTaskValid & isMinTaskValid & isQueLengthValid;
    }
}