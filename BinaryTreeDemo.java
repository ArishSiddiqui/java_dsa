import tree.Node;

public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree bT = new BinaryTree();
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8 };
        Node root = bT.buildTree(arr, 0);
        // System.out.println(bT.sumRightMost(root));
        // bT.inOrderTraversal(root);
        // bT.preOrderTraversal(root);
        // bT.postOrderTraversal(root);
        bT.levelOrderTraversal(root);
    }
}

class BinaryTree {

    public Node buildTree(int[] arr, int index) {
        if (arr.length <= index) {
            return null;
        }

        Node root = new Node(arr[index]);
        root.left = buildTree(arr, 2 * index + 1);
        root.right = buildTree(arr, 2 * index + 2);
        return root;
    }

    public int sumRightMost(Node head) {
        int sum = 0;
        while (head != null) {
            System.out.println(head.data);
            sum += head.data;
            head = head.right;
        }
        return sum;
    }

    public void inOrderTraversal(Node root) {
        if (root == null)
            return;

        inOrderTraversal(root.left);
        System.out.println(root.data);
        inOrderTraversal(root.right);
    }

    public void preOrderTraversal(Node root) {
        if (root == null)
            return;

        System.out.println(root.data);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);

    }

    public void postOrderTraversal(Node root) {
        if (root == null)
            return;

        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.println(root.data);
    }

    public void levelOrderTraversal(Node root) {
        if (root == null)
            return;

        int height = getHeight(root);

        for (int i = 1; i <= height; i++) {
            printCurrentLevel(root, i);
        }
    }

    private int getHeight(Node root) {
        if (root == null)
            return 0;

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    private void printCurrentLevel(Node root, int level) {
        if (root == null)
            return;

        if (level == 1) {
            System.out.println(root.data);
        } else {
            printCurrentLevel(root.left, level - 1);
            printCurrentLevel(root.right, level - 1);
        }
    }
}