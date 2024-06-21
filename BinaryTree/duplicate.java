public class duplicate {
    public static treenode duplicatetree(treenode root) {
        if (root == null)
            return null;
        treenode newnode = new treenode(root.data);
        newnode.left = duplicatetree(root.left);
        root.left = newnode;
        root.right = duplicatetree(root.right);
        return root;
    }

    public static void duplicatemodified(treenode root) {
        if (root == null) {
            return;
        }
        treenode newnode = new treenode(root.data);
        duplicatemodified(root.left);
        duplicatemodified(root.right);
        treenode temp = root.left;
        root.left = newnode;
        newnode.left = temp;
    }

    public static void main(String[] args) {
        treenode root = recursive.create(true);
        // duplicatetree(root);
        duplicatemodified(root);
        levelwiseoutput.leveloutput(root);
    }
}
