import java.util.ArrayDeque;

public class BstClass {
    private treenode root;
    private int size;

    private static int smallest(treenode right) {
        if (right == null) {
            return Integer.MAX_VALUE;
        }
        int leftlarge = smallest(right.left);
        int rightlarge = smallest(right.right);
        return Math.min(right.data, Math.min(leftlarge, rightlarge));
    }

    private static treenode inserthelper(treenode node, int data) {
        if (node == null) {
            treenode newNode = new treenode(data);
            return newNode;
        }
        if (data < node.data) {
            node.left = inserthelper(node.left, data);
        } else if (data >= node.data) {
            node.right = inserthelper(node.right, data);
        }
        return node;
    }

    public void insert(int data) {
        root = inserthelper(root, data);
        size++;
    }

    private static void printTreehelper(treenode node) {
        // System.out.println("T");
        if (node == null) {
            return;
        }
        printTreehelper(node.left);
        System.out.print(node.data + " ");
        printTreehelper(node.right);
    }

    public void printTree() {
        printTreehelper(root);
    }

    private static boolean isPresenthelper(treenode node, int key) {
        if (node == null) {
            return false;
        }
        if (node.data == key) {
            return true;
        }
        if (key < node.data) {
            return isPresenthelper(node.left, key);
        } else {
            return isPresenthelper(node.right, key);
        }
    }

    public boolean isPresent(int key) {
        return isPresenthelper(root, key);
    }

    public int size() {
        return size;
    }

    private static bstreturn deletehelper(treenode node, int data) {
        if (node == null) {
            return new bstreturn(null, false);
        }
        if (data > node.data) {
            bstreturn outputright = deletehelper(node.right, data);
            node.right = outputright.root;
            outputright.root = node;
            return outputright;
        }
        if (data < node.data) {
            bstreturn outputleft = deletehelper(node.left, data);
            node.left = outputleft.root;
            outputleft.root = node;
            return outputleft;
        }
        if (node.left == null && node.right == null) {
            return new bstreturn(null, true);
        }
        if (node.left != null && node.right == null) {
            return new bstreturn(node.left, true);
        }
        if (node.left == null && node.right != null) {
            return new bstreturn(node.right, true);
        }
        int rightmin = smallest(node.right);
        node.data = rightmin;
        bstreturn output = deletehelper(node.right, rightmin);
        node.right = output.root;
        return new bstreturn(node, true);
    }

    public boolean deleted(int data) {
        bstreturn output = deletehelper(root, data);
        root = output.root;
        if (output.deleted) {
            size--;
        }
        return output.deleted;
    }

    private static void leveloutputhelper(treenode root) {
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

    public void leveloutput() {
        leveloutputhelper(root);
    }
}
