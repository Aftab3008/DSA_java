import java.util.ArrayDeque;

public class levelwiseoutput {
    public static void leveloutput(treenode root) {
        ArrayDeque<treenode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            treenode current = queue.poll();
            if (current == null) {
                return;
            }
            System.out.print(current.data + ":" + " ");
            if (current.left != null) {
                System.out.print("L" + current.left.data + " ");
                queue.add(current.left);
            }
            if (current.right != null) {
                System.out.print("R" + current.right.data + " ");
                queue.add(current.right);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        treenode root = tree_levelwise.levelwise();
        leveloutput(root);
    }
}