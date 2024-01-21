//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(5);
        bst.insert(3);
        bst.insert(2);
        bst.insert(1);
        bst.insert(4);
        bst.insert(6);
        bst.insert(7);

        System.out.println(bst.search(7).getValue());

        bst.inOrder(bst.getRoot());
        System.out.println();
        bst.preOrder(bst.getRoot());
        System.out.println();
        bst.posOrder(bst.getRoot());

        System.out.println();
        bst.printTree(bst.getRoot());
    }
}