public class BinaryTreeA_heightTree {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }

    // Height of Tree
    public static int height(Node root) {
        if (root == null) {
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);

        return Math.max(lh, rh) + 1;
    }

    // Count the Node in tree
    public static int count(Node root) {
        if (root == null) {
            return 0;
        }
        int lc = count(root.left);
        int rc = count(root.right);

        return lc + rc + 1;
    }

    // Sum of Nodes
    public static int sum(Node root) {
        if (root == null) {
            return 0;
        }
        int ls = sum(root.left);
        int rs = sum(root.right);

        return ls + rs + root.data;
    }

    // Diameter of a tree
    // Apporach 1
    public static int diameter(Node root) { // 0(N^2)
        if (root == null) {
            return 0;
        }

        int leftDia = diameter(root.left);
        int leftHt = height(root.left);
        int rightDia = diameter(root.right);
        int rightHt = height(root.right);

        int selfDia = leftHt + rightHt + 1;

        return Math.max(selfDia, Math.max(rightDia, leftDia));
    }

    // Apporach 2
    static class Info {
        int dia;
        int ht;

        public Info(int dia, int ht) {
            this.dia = dia;
            this.ht = ht;
        }
    }

    public static Info diameter2(Node root) {
        if (root == null) {
            return new Info(0, 0);
        }

        Info leftInfo = diameter2(root.left);
        Info rightInfo = diameter2(root.right);

        int dia = Math.max(Math.max(leftInfo.dia, rightInfo.dia), leftInfo.ht + rightInfo.ht + 1);
        int ht = Math.max(leftInfo.ht, rightInfo.ht) + 1;

        return new Info(dia, ht);
    }

    public static void main(String[] args) {

        /*
         * 1
         * / \
         * 2 3
         * / \ / \
         * 4 5 6 7
         */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        // System.out.println(height(root));

        // System.out.println(count(root));

        // System.out.println(sum(root));

        // System.out.println(diameter(root));

        System.out.println(diameter2(root).dia);
    }
}
