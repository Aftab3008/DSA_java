import java.util.ArrayDeque;
import java.util.Scanner;

public class tree_levelwise {
    public static treenode levelwise() {
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Enter the root data ");
            int rootdata = input.nextInt();
            if (rootdata <= -1) {
                System.out.println("Empty tree");
                treenode root1 = null;
                return root1;
            }
            treenode root = new treenode(rootdata);
            ArrayDeque<treenode> queue = new ArrayDeque<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                treenode tempnode = queue.pollFirst();
                System.out.print("Leftchild of " + tempnode.data + " ");
                int rootleft = input.nextInt();
                if (rootleft != -1) {
                    treenode left = new treenode(rootleft);
                    tempnode.left = left;
                    queue.add(left);
                }
                System.out.print("Rightchild of " + tempnode.data + " ");
                int rootright = input.nextInt();
                if (rootright != -1) {
                    treenode right = new treenode(rootright);
                    tempnode.right = right;
                    queue.add(right);
                }
            }
            return root;
        }

    }

    public static treenode printtree(treenode root) {
        if (root == null) {
            return null;
        }
        System.out.print(root.data + " ");
        printtree(root.left);
        printtree(root.right);
        return root;
    }

    public static int nodes(treenode root) {
        if (root == null) {
            return 0;
        }
        return nodes(root.left) + nodes(root.right) + 1;
    }

    public static void DepthK(treenode root, int K) {
        if (root == null) {
            return;
        }
        if (K == 0) {
            System.out.println(root.data);
            return;
        }
        DepthK(root.left, K - 1);
        DepthK(root.right, K - 1);
    }

    public static treenode removeleaf(treenode root) {
        treenode root1 = root;
        if (root1 == null) {
            return null;
        }
        if (root1.left == null && root1.right == null) {
            return null;
        }
        root1.left = removeleaf(root1.left);
        root1.right = removeleaf(root1.right);
        return root1;
    }

    public static treenode mirrortree(treenode root) {
        if (root == null) {
            return null;
        }
        treenode rootM = new treenode(root.data);
        rootM.left = mirrortree(root.right);
        rootM.right = mirrortree(root.left);
        return rootM;
    }

    public static void main(String[] args) {
        treenode root = levelwise();
        printtree(root);
        treenode rootM = mirrortree(root);
        printtree(rootM);
        System.out.println("rootM");
        System.out.println("\nNumber of nodes in the binary tree is:" + nodes(root));
        System.out.println("\nDepth of the given binary tree is:");
        DepthK(root, 1);
        System.out.println("\nBinary Tree after removing all leaf node :");
        printtree(root);
        treenode r1 = removeleaf(root);
        printtree(r1);
        // System.out.println("root1");
        printtree(root);
        System.out.println("root");
        System.out.println("\nNumber of nodes in the binary tree is:" + nodes(root));
        printtree(rootM);
        System.out.println("rootM");
    }
}
