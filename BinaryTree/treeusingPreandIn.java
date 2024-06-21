public class treeusingPreandIn {
    public static treenode treeconstructionHelper(int[] pr, int[] in, int siP, int eiP, int siI, int eiI) {
        if (siP > eiP) {
            return null;
        }
        int data = pr[siP];
        treenode root = new treenode(data);
        int index = -1;
        for (int i = siI; i <= eiI; i++) {
            if (in[i] == data) {
                index = i;
                break;
            }
        }
        int siPleft = siP + 1;
        int siIleft = siI;
        int eiIleft = index - 1;
        int eiPright = eiP;
        int siIright = index + 1;
        int eiIright = eiI;
        int leftsubtree = eiIleft - siIleft + 1;
        int eiPleft = siPleft + leftsubtree - 1;
        int siPright = eiPleft + 1;
        treenode left = treeconstructionHelper(pr, in, siPleft, eiPleft, siIleft, eiIleft);
        treenode right = treeconstructionHelper(pr, in, siPright, eiPright, siIright, eiIright);
        root.left = left;
        root.right = right;
        return root;
    }

    public static treenode treeconstruction(int pr[], int in[]) {
        treenode root = treeconstructionHelper(pr, in, 0, pr.length - 1, 0, in.length - 1);
        return root;
    }

    public static void main(String[] args) {
        int[] pre = { 1, 2, 4, 5, 3 };
        int[] in = { 4, 2, 5, 1, 3 };
        treenode root = treeconstruction(pre, in);
        levelwiseoutput.leveloutput(root);
    }
}
