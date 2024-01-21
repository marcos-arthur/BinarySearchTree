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

    void remove(int value){
        remove(root, value);
    }

    private Node remove(Node node, int value){
        if(node == null){
            return node;
        }

        if(node.getValue() == value){
            if (node.getRight_child() == null) {
                return node.getLeft_child();
            } else if (node.getLeft_child() == null) {
                return node.getRight_child();
            } else {

                Node greaterLeftSideNodeParent = node;
                Node greaterLeftSideNode = node.getLeft_child();
                while (greaterLeftSideNode.getRight_child() != null){
                    greaterLeftSideNodeParent = greaterLeftSideNode;
                    greaterLeftSideNode = greaterLeftSideNode.getRight_child();
                }

                if(greaterLeftSideNodeParent == node){
                    swap(node, greaterLeftSideNode);
                    node.setLeft_child(greaterLeftSideNode.getLeft_child());
                    greaterLeftSideNode.setLeft_child(null);
                }else{
                    swap(node, greaterLeftSideNode);
                    greaterLeftSideNodeParent.setRight_child(null);
                }

                return node;
            }
        }else{
            if(value < node.getValue()){
                node.setLeft_child(remove(node.getLeft_child(), value));
                return node;
            }else {
                node.setRight_child(remove(node.getRight_child(), value));
                return node;
            }
        }
    }

    private void swap(Node n1, Node n2){
        int aux = n1.getValue();

        n1.setValue(n2.getValue());
        n2.setValue(aux);
    }
}
