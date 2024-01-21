import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {
    private Node root;

    private List<String> inOrderString = new ArrayList<>();
    private List<String> preOrderString = new ArrayList<>();
    private List<String> postOrderString = new ArrayList<>();

    private int size = 0;

    public BinarySearchTree() {
        this.root = null;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public List<String> getInOrderString() {
        return inOrderString;
    }

    public void setInOrderString(List<String> inOrderString) {
        this.inOrderString = inOrderString;
    }

    public int getSize() {
        return size;
    }

    Node insert(int value){
        Node newNode;
        if(root == null){
            root = new Node(value);
            newNode = root;
            size++;
        }else{
            newNode = insert(root, value);
        }

        return newNode;
    }

    private Node insert(Node node, int value){
        if(node == null){
            node = new Node(value);
            size++;
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

    public String getInOrderMedian(){
        inOrder();

        if(inOrderString.size() % 2 == 0) return inOrderString.get(inOrderString.size()/2 - 1);
        else return inOrderString.get(inOrderString.size()/2);
    }

    public int getInOrderPosition(String value){
        inOrder();

        return inOrderString.indexOf(value) + 1;
    }

    public String inOrder(){
        inOrderString.clear();
        inOrder(root);

        StringBuilder stringValues = new StringBuilder();

        for(String value : inOrderString) {
            stringValues.append(value);
            stringValues.append(" ");
        }

        return stringValues.toString();
    }

    //Em Ordem
    public void inOrder(Node node) {
        if (node == null)
            return;

        // Recursão no lado esquerdo do Nó
        inOrder(node.getLeft_child());

        // Adiciona valor na lista
        inOrderString.add(Integer.toString(node.getValue()));

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

    void remove(int value){
        Node removedNode = remove(root, value);
    }

    private Node remove(Node node, int value){
        if(node == null){
            return node;
        }

        if(node.getValue() == value){
            size--;
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
