import java.io.IOException;

public class P2263 {
    static int[] inOrder, postOrder, inorderIndexOf;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int N = readInt();
        inOrder = new int[N];
        postOrder = new int[N];
        inorderIndexOf = new int[N + 1];

        for (int i = 0; i < N; i++) {
            inorderIndexOf[(inOrder[i] = readInt())] = i;
        }

        for (int i = 0; i < N; i++) {
            postOrder[i] = readInt();
        }

        preOrder(0, N - 1, 0, N - 1);
        System.out.println(sb);
    }

    private static void preOrder(int inStart, int inEnd, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) {
            return;
        }

        int rootIndex = inorderIndexOf[postOrder[postEnd]];
        sb.append(inOrder[rootIndex]).append(' ');

        preOrder(inStart, rootIndex - 1, postStart, postStart + rootIndex - inStart - 1);
        preOrder(rootIndex + 1, inEnd, postStart + rootIndex - inStart, postEnd - 1);
    }

    private static int readInt() throws IOException {
        int rs = 0;
        boolean isNegative = false;
        int c = System.in.read();
        while (c <= ' ') {
            c = System.in.read();
        }
        if (c == '-') {
            isNegative = true;
            c = System.in.read();
        }
        while (c >= '0' && c <= '9') {
            rs = rs * 10 + c - '0';
            c = System.in.read();
        }
        return isNegative ? -rs : rs;
    }
}