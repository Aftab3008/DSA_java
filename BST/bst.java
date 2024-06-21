import java.util.Scanner;

public class bst {
    public static boolean searchtree(treenode root, int key, int level) {
        if (root == null) {
            return false;
        }
        if (root.data == key) {
            System.out.println("Found at Level " + level);
            return true;
        }
        if (root.data > key) {
            return searchtree(root.left, key, level + 1);
        }
        return searchtree(root.right, key, level + 1);
    }

    public static void printBtwK1K2(treenode root, int k1, int k2) {
        if (root == null) {
            return;
        }
        if (root.data < k1) {
            printBtwK1K2(root.right, k1, k2);
        } else if (root.data > k2) {
            printBtwK1K2(root.left, k1, k2);
        } else {
            System.out.println(root.data + " ");
            printBtwK1K2(root.left, k1, k2);
            printBtwK1K2(root.right, k1, k2);
        }
    }

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            treenode root = recursive.create(true);
            int key;
            System.out.print("Enter the key ");
            key = input.nextInt();
            System.out.println(searchtree(root, key, 0));
            recursive.Inorder(root);
            int k1 = 3, k2 = 6;
            System.out.println();
            printBtwK1K2(root, k1, k2);
        }
    }

}