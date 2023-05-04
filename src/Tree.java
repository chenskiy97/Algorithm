public class Tree {
    public static void main(String[] args) {
        Node tree = buildTree(10);
        printTreeNLR(tree, "");
        System.out.println("---------------------");
        printTreeLNR(tree, "");
        System.out.println("---------------------");
        printTreeLRN(tree, "");
        System.out.println("---------------------");
        printTree(tree, "");
    }


    static int t = 0;

    public static Node buildTree(int n) {

        Node root = new Node(t++);
        if (n == 0)
            return null;
        else {
            root.left = buildTree(n / 2);
            root.right = buildTree(n - n / 2 - 1);
        }
        return root;
    }

    public static void printTreeNLR(Node root, String sp) { // Прямой обход (NLR)
        if (root != null) {
            System.out.println(sp + root.value);
            printTreeNLR(root.left, sp + " ");
            printTreeNLR(root.right, sp + " ");
        }
    }

    public static void printTreeLNR(Node root, String sp) { // Центрированный обход (LNR)
        if (root != null) {
            printTreeLNR(root.left, sp + " ");
            System.out.println(sp + root.value);
            printTreeLNR(root.right, sp + " ");
        }
    }

    public static void printTreeLRN(Node root, String sp) { // Обратный обход (LRN)
        if (root != null) {
            printTreeLRN(root.left, sp + " ");
            printTreeLRN(root.right, sp + " ");
            System.out.println(sp + root.value);
        }
    }

    public static void printTree(Node root, String sp) {
        System.out.println(sp + root.value);
        if (root.left != null) {
            printTree(root.left, sp + " ");
        }
        if (root.right != null) {
            printTree(root.right, sp + " ");
        }
    }

    public static class Node {

        Node left;
        Node right;
        int value;

        public Node(int value) {
            this.value = value;
        }
    }
}