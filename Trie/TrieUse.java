package Trie;

public class TrieUse {

    public static void main(String[] args) {
        Trie t=new Trie();
        t.add("this");
        t.add("that");
        System.out.println(t.search("that"));
        t.remove("that");
        System.out.println(t.search("that"));
        System.out.println(t.countWords());
    }
}
