public class BinarySearchTree {
    private Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    Node insert(int value){
        Node newNode;
        if(root == null){
            root = new Node(value);
            newNode = root;
        }else{
            newNode = insert(root, value);
        }

        return newNode;
    }

    private Node insert(Node node, int value){
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

    Node search(int value){
        return Search(root, value);
    }

    private Node Search(Node node, int value){
        if(node == null || node.getValue() == value){
            return node;
        }

        if(value < node.getValue()){
            return Search(node.getLeft_child(), value);
        }else {
            return Search(node.getRight_child(), value);
        }
    }
}
