import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class P2480 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int dices = 3, sum = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < dices; i++) {
            list.add(sc.nextInt());
        }
        sc.close();
        boolean isDistinct = new HashSet<>(list).size() == list.size();
        if (isDistinct) {
            sum = Collections.max(list) * 100;
        } else {
            int frequency;
            for (int i = 0; i < dices; i++) {
                frequency = Collections.frequency(list, list.get(i));
                switch (frequency) {
                    case 3:
                        sum = 10000 + list.get(i) * 1000;
                        break;
                    case 2:
                        sum = 1000 + list.get(i) * 100;
                        break;
                }
            }
        }
        System.out.println(sum);
    }
}
