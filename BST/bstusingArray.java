public class bstusingArray {
    public static treenode Bstusingarray(int a[], int si, int ei) {
        if (si > ei)
            return null;
        int mid = (ei + si) / 2;
        treenode root = new treenode(a[mid]);
        root.left = Bstusingarray(a, si, mid - 1);
        root.right = Bstusingarray(a, mid + 1, ei);
        return root;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
        treenode root = Bstusingarray(arr, 0, arr.length - 1);
        // recursive.Inorder(root);
        levelwiseoutput.leveloutput(root);
    }
}
