import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P6597 {
    static int preIndex = 0;
    static String preOrder, inOrder;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str;
        while ((str = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(str);

            preOrder = st.nextToken();
            inOrder = st.nextToken();
            preIndex = 0;

            postOrder(0, inOrder.length() - 1);
            sb.append('\n');
        }

        System.out.print(sb);
    }

    private static void postOrder(int start, int end) {
        if (start > end) {
            return;
        }

        int rootIndex = inOrder.indexOf(preOrder.charAt(preIndex++));
        postOrder(start, rootIndex - 1);
        postOrder(rootIndex + 1, end);
        sb.append(inOrder.charAt(rootIndex));
    }
}