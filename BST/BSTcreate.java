public class BSTcreate {
    public static void main(String[] args) {
        BstClass bst = new BstClass();
        bst.insert(5);
        bst.insert(2);
        bst.insert(7);
        bst.insert(1);
        bst.insert(3);
        bst.insert(8);
        bst.insert(6);
        bst.printTree();
        System.out.println();
        System.out.println(bst.isPresent(3));
        bst.deleted(5);
        bst.deleted(2);
        bst.printTree();
        System.out.println();
        bst.leveloutput();
    }
}