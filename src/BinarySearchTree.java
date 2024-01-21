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

    //Em Ordem
    public void inOrder(Node node) {
        if (node == null)
            return;

        // Recursão no lado esquerdo do Nó
        inOrder(node.getLeft_child());

        // Imprimir valor
        System.out.print(node.getValue() + " ");

        // Recursão no lado direito do Nó
        inOrder(node.getRight_child());
    }

    //Pré-ordem
    public void preOrder(Node node){
        if (node == null)
            return;

        // Imprimir valor
        System.out.print(node.getValue() + " ");

        // Recursão no lado esquerdo do Nó
        preOrder(node.getLeft_child());

        // Recursão no lado direito do Nó
        preOrder(node.getRight_child());
    }

    // Pós-0rdem
    public void posOrder(Node node){
        if (node == null)
            return;

        // Recursão no lado esquerdo do Nó
        posOrder(node.getLeft_child());

        // Recursão no lado direito do Nó
        posOrder(node.getRight_child());

        // Imprimir valor
        System.out.print(node.getValue() + " ");
    }

    //Utilizando o pré-ordem
    public void printTree(Node node){
        if (node == null){
            return;
        }

        // Imprimir valor
        System.out.print("(" + node.getValue() + " ");

        // Recursão no lado esquerdo do Nó
        printTree(node.getLeft_child());

        // Recursão no lado direito do Nó
        printTree(node.getRight_child());
        System.out.print(")");
    }
}
