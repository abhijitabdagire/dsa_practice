import java.util.ArrayList;

public class BST_A {

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }

    }

    // Build BST
    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }

        if (root.data > val) {
            // left subTrees
            root.left = insert(root.left, val);
        } else {
            // right subTrees
            root.right = insert(root.right, val);
        }
        return root;
    }

    // Search Key
    public static boolean search(Node root, int key) {
        if (root == null) {
            return false;
        }

        if (root.data == key) {
            return true;
        }
        if (root.data > key) {
            return search(root.left, key);

        } else {
            return search(root.right, key);
        }
    }

    public static void preorder(Node root) {
        if (root == null) {
            return;
        }

        preorder(root.left);
        System.out.print(root.data + " ");
        preorder(root.right);

    }

    // Delete Node
    public static Node delete(Node root, int val) {
        if (root.data < val) {
            root.right = delete(root.right, val);
        } else if (root.data > val) {
            root.left = delete(root.left, val);
        } else { // Voilate
                 // case 1 -> Leaf Node
            if (root.left == null && root.right == null) {
                return null;
            }

            // case 2 -> single child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // case 2 -> Both childern
            Node IS = findInorderSuccessor(root.left);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);

        }
        return root;
    }

    public static Node findInorderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    // PrintInRange
    public static void printInRange(Node root, int k1, int k2) {
        if (root == null) {
            return;
        }
        if (root.data >= k1 && root.data <= k2) {
            printInRange(root.left, k1, k2);
            System.out.print(root.data + " ");
            printInRange(root.right, k1, k2);
        } else if (root.data < k1) {
            printInRange(root.right, k1, k2);
        } else {
            printInRange(root.left, k1, k2);
        }
    }

    // Print root to leaf
    public static void printPath(ArrayList<Integer> path) {
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i) + "->");
        }
        System.out.println("Null");
    }

    public static void printRoot2Leaf(Node root, ArrayList<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.data);
        if (root.left == null && root.right == null) {
            printPath(path);
        }

        printRoot2Leaf(root.left, path);
        printRoot2Leaf(root.right, path);
        path.remove(path.size() - 1);
    }

    // Valid BST
    public static boolean isValidBST(Node root, Node min, Node max) {
        if (root == null) {
            return true;
        }

        if (min != null && root.data <= min.data) {
            return false;
        } else if (max != null && root.data >= max.data) {
            return false;
        }

        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }

    public static void main(String[] args) {
        int values[] = { 8, 5, 3, 6, 10, 11, 14 };
        Node root = null;

        // Build Tree
        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }
        preorder(root);
        System.out.println();

        // Search tree
        if (search(root, 7)) {
            System.out.println("Found");
        } else {
            System.out.println("Not Found");
        }

        // Delete Node
        // root = delete(root, 5);
        // System.out.println();

        // preorder(root);

        // print in range
        printInRange(root, 5, 12);

        // print root to leaf paths
        // printRoot2Leaf(root, new ArrayList<>());

        // Valid BST
        if (isValidBST(root, null, null)) {
            System.out.println("Vaild");
        } else {
            System.out.println("Not Valid");
        }

        // Mirror of BST

    }
}