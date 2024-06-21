import java.util.LinkedList;
import java.util.Queue;

public class levelwise_modified {
    public static void levelmodify(treenode root) {
        Queue<treenode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            treenode current = queue.poll();
            if (current == null) {
                System.out.println();
                if (!queue.isEmpty()) {
                    queue.add(null);
                }
            } else {
                System.out.print(current.data + " ");
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }

        }
    }

    public static void main(String[] args) {
        treenode root = recursive.create(true);
        levelmodify(root);
    }
}
