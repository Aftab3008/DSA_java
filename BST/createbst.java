
public class createbst {
    public static treenode create(treenode root, int data) {
        if (data == -1) {
            return null;
        } else if (data != -1) {
            if (root == null) {
                treenode newNode = new treenode(data);
                return newNode;
            }
            if (data < root.data) {
                root.left = create(root.left, data);
            } else if (data > root.data) {
                root.right = create(root.right, data);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        treenode root = null;
        root = create(root, 10);
        create(root, 30);
        create(root, 40);
        create(root, 5);
        levelwiseoutput.leveloutput(root);
        // recursive.Inorder(root);
    }
}
