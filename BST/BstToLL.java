// Wrong
public class BstToLL {
    public static Node treeToll(treenode root) {
        if (root == null)
            return null;
        Node left = treeToll(root.left);
        Node rootll = new Node(root.data);
        Node right = treeToll(root.right);
        left.next = rootll;
        rootll.next = right;
        return left;
    }

    public static void printLL(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
        }
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
        treenode root = bstusingArray.Bstusingarray(arr, 0, arr.length - 1);
        Node head = treeToll(root);
        printLL(head);
    }
}
