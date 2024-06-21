public class trieNode {
    char data;
    boolean isEndOfWord;
    trieNode children[];
    int childCount;

    public trieNode(char data) {
        this.data = data;
        isEndOfWord = false;
        children = new trieNode[26];
        childCount = 0;
    }
}
