import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        BinarySearchTree bst = new BinarySearchTree();
        int line; String line2;

        File input = new File("/Users/marco/Documentos/_Assuntos e Atividade 2024_/UFRN/2023.4/Estruturas de Dados Básicas II/BinarySearchTree/src/input.txt");
        Scanner scan = new Scanner(input);

        while(scan.hasNextLine()){
            line = Integer.parseInt(scan.nextLine());
            bst.insert(line);
        }

        File actions = new File("/Users/marco/Documentos/_Assuntos e Atividade 2024_/UFRN/2023.4/Estruturas de Dados Básicas II/BinarySearchTree/src/actions.txt");
        scan = new Scanner(actions);

        while(scan.hasNextLine()){
            line2 = scan.nextLine();
            if(line2.contains("search")){
                line = Integer.parseInt(line2.substring(line2.indexOf("(")+1, line2.indexOf(")")));
                System.out.println(bst.search(line));
            } else if (line2.equals("inOrder")) {
                System.out.println(bst.inOrder());
            } else if (line2.equals("preOrder")) {
                bst.preOrder(bst.getRoot());
                System.out.println();
            } else if (line2.equals("posOrder")) {
                bst.posOrder(bst.getRoot());
                System.out.println();
            } else if (line2.equals("printTree")) {
                bst.printTree(bst.getRoot());
                System.out.println();
            } else if (line2.contains("insert")) {
                line = Integer.parseInt(line2.substring(line2.indexOf("(")+1, line2.indexOf(")")));
                bst.insert(line);
            } else if (line2.contains("getInOrderPosition")) {
                line2 = line2.substring(line2.indexOf("(")+1, line2.indexOf(")"));
                bst.getInOrderPosition(line2);
            } else if (line2.equals("getInOrderMedian")) {
                bst.getInOrderMedian();
            } else if (line2.contains("remove")) {
                line = Integer.parseInt(line2.substring(line2.indexOf("(")+1, line2.indexOf(")")));
                bst.remove(line);
            }
        }
    }
}