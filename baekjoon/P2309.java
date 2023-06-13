import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P2309 {
    static final int dwarfLen = 9;
    static final int totalHeight = 100;
    static int[] dwarfs = new int[9];
    static List<Integer> list = new ArrayList<>(dwarfLen);
    static int[] except = new int[2];
    static boolean isCalculated = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int sum = 0;
        for (int i = 0; i < 9; i++) {
            int num = Integer.parseInt(br.readLine());
            dwarfs[i] = num;
            list.add(num);
            sum += num;
        }
        calc(sum, 0, 1);

        Collections.sort(list);

        list.forEach(dwarf -> sb.append(dwarf).append('\n'));
        System.out.print(sb);
    }

    static void calc(int sum, int idx, int depth) {
        if (depth == except.length) {
            for (int i = idx; i < dwarfLen; i++) {
                except[depth - 1] = dwarfs[i];
                if (sum - dwarfs[i] == totalHeight) {
                    for (int ex : except) {
                        list.remove(list.indexOf(ex));
                    }
                    isCalculated = true;
                    return;
                }
            }
            return;
        }

        for (int i = idx; i < dwarfLen - (except.length - depth); i++) {
            if (isCalculated) {
                return;
            }
            except[depth - 1] = dwarfs[i];
            calc(sum - dwarfs[i], i + 1, depth + 1);
        }
    }
}