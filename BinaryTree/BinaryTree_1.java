import java.util.Scanner;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
    }

}

public class BinaryTree_1 {
    public static Node createTree() {
        System.out.println("Enter the root data");
        Scanner input = new Scanner(System.in);
        int data = input.nextInt();
        if (data == -1) {
            return null;
        }
        Node root = new Node(data);
        System.out.println("Enter the left child of " + root.data);
        root.left = createTree();
        System.out.println("Enter the right child of " + root.data);
        root.right = createTree();
        return root;
    }

    public static int numnodes(Node root) {
        if (root == null) {
            return 0;
        }
        int leftchilds = numnodes(root.left);
        int rightchilds = numnodes(root.right);
        return 1 + leftchilds + rightchilds;
    }

    public static int largest(Node root) {
        if (root == null) {
            return -1;
        }
        int leftlarge = largest(root.left);
        int rightlarge = largest(root.right);
        return Math.max(root.data, Math.max(leftlarge, rightlarge));
    }

    public static void printTree(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + ":");
        if (root.left != null) {
            System.out.print("L" + root.left.data);
        }
        if (root.right != null) {
            System.out.print(" R" + root.right.data);
        }
        System.out.println();
        printTree(root.left);
        printTree(root.right);
    }

    public static void main(String[] args) {
        Node root = createTree();
        printTree(root);
        int num = numnodes(root);
        System.out.println("No.of nodes are " + num);
        System.out.println("Largest number is " + largest(root));
    }

}