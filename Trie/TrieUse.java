public class TrieUse {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.add("news");
        trie.add("at");
        trie.add("this");
        System.out.println(trie.search("news"));
        trie.remove("news");
        System.out.println(trie.search("news"));
        trie.add("fuck");
        System.out.println(trie.NumWords());
    }
}
