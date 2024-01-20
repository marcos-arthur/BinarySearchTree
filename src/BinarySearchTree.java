public class Tree {
    private Node root;

    public Tree() {
        this.root = null;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    Node insert(Node node, int value){
        if(node == null){
            node = new Node(value);
            return node;
        }

        if(value < node.getValue()){
            node.setLeft_child(insert(node.getLeft_child(), value));
        } else if (value > node.getValue()) {
            node.setRight_child(insert(node.getRight_child(), value));
        }

        return node;
    }
}
