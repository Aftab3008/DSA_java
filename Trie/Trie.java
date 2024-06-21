public class Trie {
    private trieNode root;
    private int numWords = 0;

    public Trie() {
        root = new trieNode('\0');
    }

    private void addHelper(trieNode node, String word) {
        if (word.length() == 0) {
            node.isEndOfWord = true;
            numWords++;
            return;
        }
        int childIndex = word.charAt(0) - 'a';
        trieNode child = node.children[childIndex];
        if (child == null) {
            child = new trieNode(word.charAt(0));
            node.children[childIndex] = child;
            node.childCount++;
        }
        addHelper(child, word.substring(1));
    }

    public void add(String word) {
        addHelper(root, word);
    }

    private boolean search(trieNode node, String word) {
        if (word.length() == 0) {
            return node.isEndOfWord;
        }
        int childIndex = word.charAt(0) - 'a';
        trieNode child = node.children[childIndex];
        if (child == null) {
            return false;
        }
        return search(child, word.substring(1));
    }

    public boolean search(String word) {
        return search(root, word);
    }

    public void remove(String word) {
        removeHelper(root, word);
    }

    private void removeHelper(trieNode node, String word) {
        if (word.length() == 0) {
            node.isEndOfWord = false;
            numWords--;
            return;
        }
        int childIndex = word.charAt(0) - 'a';
        trieNode child = node.children[childIndex];
        if (child == null) {
            return;
        }
        removeHelper(child, word.substring(1));
        /*
         * We can remove the child nodes only if it is non terminating and
         * its number of children are 0
         */
        if (!child.isEndOfWord && child.childCount == 0) {
            // int numChild = 0;
            // for (int i = 0; i < 26; i++) {
            // if (child.children[i] != null) {
            // numChild++;
            // }
            // }
            // if (numChild == 0) {
            // We can delete child
            node.children[childIndex] = null;
            node.childCount--;
            // }
        }
    }

    public int NumWords() {
        return numWords++;
    }
}
