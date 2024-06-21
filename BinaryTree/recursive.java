import java.util.Scanner;

public class recursive {
    public static treenode create(boolean isroot) {
        Scanner input = new Scanner(System.in);
        int data;
        if (isroot) {
            System.out.print("Enter the root data ");
            data = input.nextInt();
        } else {
            data = input.nextInt();
        }
        if (data == -1) {
            return null;
        }
        treenode root = new treenode(data);
        System.out.print("Enter the left child of the " + data + " ");
        root.left = create(false);
        System.out.print("Enter the right child of the " + data + " ");
        root.right = create(false);
        return root;
    }

    public static void main(String[] args) {
        treenode root = create(true);
        tree_levelwise.printtree(root);
    }

}
