public class checkbst {
    public static boolean check(treenode root) {
        if (root == null)
            return true;
        if (root.data > root.left.data && root.right.data > root.data) {
            return true;
        } else {
            return false;
        }

    }

    public static void main(String[] args) {
        treenode root = createbst.create(null, 10);
        createbst.create(root, 30);
        createbst.create(root, 40);
        createbst.create(root, 5);
    }
}
