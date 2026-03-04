import tree.Node;

public class BinarySearchTreeDemo {
    public static void main(String[] args) {
        BinarySearchTree bST = new BinarySearchTree();
        bST.insert(50);
        bST.insert(20);
        bST.insert(40);
        bST.insert(10);
        bST.insert(15);
        bST.insert(25);
        bST.inOrderTraversal();
        bST.search(9);
        bST.delete(10);
        bST.inOrderTraversal();
    }
}

class BinarySearchTree {
    Node root;

    public void insert(int data) {
        root = insertNode(root, data);
    }

    private Node insertNode(Node root, int data) {
        Node nN = new Node(data);
        if (root == null) {
            return nN;
        }
        if (data < root.data) {
            root.left = insertNode(root.left, data);
        } else if (data > root.data) {
            root.right = insertNode(root.right, data);
        }
        return root;
    }

    public void inOrderTraversal() {
        inorder(root);
    }

    private void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    public void search(int data) {
        Boolean found = searchData(data, root);
        if (found) {
            System.out.println("Data is available in Tree");
        } else {
            System.out.println("Data is not available in Tree");
        }
    }

    private Boolean searchData(int data, Node root) {
        if (root == null) {
            return false;
        } else if (root.data == data) {
            return true;
        } else if (data < root.data) {
            return searchData(data, root.left);
        }
        return searchData(data, root.right);
    }

    public void delete(int data) {
        deleteNode(root, data);
    }

    private Node findMin(Node node) {
        while (node.left != null)
            node = node.left;
        return node;
    }

    private Node deleteNode(Node root, int val) {
        if (root == null)
            return null;
        if (val < root.data)
            root.left = deleteNode(root.left, val);
        else if (val > root.data) {
            root.right = deleteNode(root.right, val);
        } else {
            if (root.left == null)
                return root.right;
            if (root.right == null)
                return root.left;
            Node minNode = findMin(root.right);
            root.data = minNode.data;
            root.right = deleteNode(root.right, minNode.data);
        }
        return root;
    }

}