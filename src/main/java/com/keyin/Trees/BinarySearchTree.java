package Trees;

public class BinarySearchTree {

    BinaryNode root;

    public BinarySearchTree() {
        root = null;
    }

    void insert(int number) {
        BinaryNode newNode = new BinaryNode(number);
        if (root == null) {
            root = newNode;
            return;
        }
        BinaryNode currentNode = root;
        while (true) {
            if (number < currentNode.number) {
                if (currentNode.left == null) {
                    currentNode.left = newNode;
                    break;
                } else {
                    currentNode = currentNode.left;
                }
            } else {
                if (currentNode.right == null) {
                    currentNode.right = newNode;
                    break;
                } else {
                    currentNode = currentNode.right;
                }
            }
        }
    }

    public BinaryNode getRoot() {
        return root;
    }

    public void setRoot(BinaryNode root) {
        this.root = root;
    }
}

