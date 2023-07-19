import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1991 {

    static Node[] nodes;
    static StringBuilder sb = new StringBuilder();

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        nodes = new Node[N];
        for (int i = 0; i < N; i++) {
            nodes[i] = new Node(i);
        }

        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int data = Integer.valueOf(st.nextToken().charAt(0) - 'A');
            int left = Integer.valueOf(st.nextToken().charAt(0) - 'A');
            int right = Integer.valueOf(st.nextToken().charAt(0) - 'A');

            nodes[data].left = left >= 0 ? nodes[left] : null;
            nodes[data].right = right >= 0 ? nodes[right] : null;
        }

        preorder(nodes[0]);
        sb.append('\n');

        inorder(nodes[0]);
        sb.append('\n');

        postorder(nodes[0]);
        System.out.println(sb);
    }

    static void preorder(Node node) {
        // root
        sb.append((char) (node.data + 'A'));

        // left
        if (node.left != null) {
            preorder(node.left);
        }

        // right
        if (node.right != null) {
            preorder(node.right);
        }
    }

    static void inorder(Node node) {
        // left
        if (node.left != null) {
            inorder(node.left);
        }

        // root
        sb.append((char) (node.data + 'A'));

        // right
        if (node.right != null) {
            inorder(node.right);
        }
    }

    static void postorder(Node node) {
        // left
        if (node.left != null) {
            postorder(node.left);
        }

        // right
        if (node.right != null) {
            postorder(node.right);
        }

        // root
        sb.append((char) (node.data + 'A'));
    }
}