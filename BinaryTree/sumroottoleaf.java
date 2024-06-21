import java.util.Scanner;

public class sumroottoleaf {
    public static void sumrootToleaf(treenode root, int data, int key, String str) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (key == data) {
                System.out.println("Path from root is " + str);
                System.out.println("Yes");
            }
        }
        if (root.left != null) {
            sumrootToleaf(root.left, data + root.left.data, key, str + root.left.data + " ");
        }
        if (root.right != null) {
            sumrootToleaf(root.right, data + root.right.data, key, str + root.right.data + " ");
        }
    }

    public static void main(String[] args) {
        treenode root = recursive.create(true);
        int key;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the key value ");
        key = input.nextInt();
        sumrootToleaf(root, root.data, key, root.data + " ");
    }
}
