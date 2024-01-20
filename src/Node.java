public class Node {
    private int value;
    private Node left_child;
    private Node right_child;

    public Node(int value) {
        this.value = value;
        this.left_child = null;
        this.right_child = null;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft_child() {
        return left_child;
    }

    public void setLeft_child(Node left_child) {
        this.left_child = left_child;
    }

    public Node getRight_child() {
        return right_child;
    }

    public void setRight_child(Node right_child) {
        this.right_child = right_child;
    }
}
