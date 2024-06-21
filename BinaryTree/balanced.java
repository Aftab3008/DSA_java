public class balanced {
    public static boolean isBalanced(treenode root) {
        if (root == null) {
            return true;
        }
        int leftH = Height(root.left);
        int rigH = Height(root.right);
        int bf = Math.abs(leftH - rigH);
        if (bf > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public static BalancedTree balancedImproved(treenode root) {
        if (root == null) {
            int height = 0;
            boolean bal = true;
            BalancedTree ans = new BalancedTree();
            ans.height = height;
            ans.balance = bal;
            return ans;
        }
        BalancedTree left = balancedImproved(root.left);
        BalancedTree right = balancedImproved(root.right);
        boolean bal = true;
        int height = 1 + Math.max(left.height, right.height);
        if (Math.abs(left.height - right.height) > 1) {
            bal = false;
        }
        if (!left.balance || !right.balance) {
            bal = false;
        }
        BalancedTree ans = new BalancedTree();
        ans.height = height;
        ans.balance = bal;
        return ans;
    }

    public static int Height(treenode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(Height(root.left), Height(root.right));
    }

    public static void main(String[] args) {
        treenode root = tree_levelwise.levelwise();
        tree_levelwise.printtree(root);
        System.out.println();
        // System.out.println(isBalanced(root));
        BalancedTree result = balancedImproved(root);
        System.out.println("Is the Tree Balanced? " + result.balance);
    }
}
