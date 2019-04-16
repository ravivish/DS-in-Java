package Trie;


import java.util.ArrayList;

class TrieNode {
    char data;
    boolean isTerminating;
    TrieNode children[];
    int childCount;

    public TrieNode(char data) {
        this.data = data;
        isTerminating = false;
        children = new TrieNode[26];
        childCount=0;
    }
}

public class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode('\0');

    }

    private void add(TrieNode root, String word) {

        if (word.length() == 0) {
            root.isTerminating = true;
            return;
        }
        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if (child == null) {
            child = new TrieNode(word.charAt(0));
            root.children[childIndex] = child;
            root.childCount++;
        }
        add(child, word.substring(1));


    }

    public void add(String word) {
        add(root, word);
    }

    public boolean search(String word) {
        // add your code here
        return searchHelper(root, word);

    }

    private boolean searchHelper(TrieNode root, String word) {

        if (word.length() == 0){
            return root.isTerminating;
        }
        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if (child == null) {
            return false;
        }
        return searchHelper(child,word.substring(1));
    }

    private void remove(TrieNode root,String word){
        if (word.length() == 0){
            root.isTerminating=false;
            return;
        }
        int childIndex=word.charAt(0)-'a';
        TrieNode child=root.children[childIndex];
        if (child == null){
            return;
        }
        remove(child,word.substring(1));
        /*
         * we can remove a child node only if it is non-terminating and it's no. of children's are 0
         * */

        if (!child.isTerminating && child.childCount == 0){
            root.children[childIndex]=null;
            child=null;
            root.childCount--;
        }
    }
    public void remove(String word){
        remove(root,word);
    }

    private int countWordsHelper(TrieNode root){
        int result = 0;

        // Leaf denotes end of a word
        if (root.isTerminating)
            result++;

        for (int i = 0; i < 26; i++)
            if (root.children[i] != null )
                result += countWordsHelper(root.children[i]);

        return result;
    }
    public int countWords() {
        // Write your code here
        int res=countWordsHelper(root);
        return res;
    }
    private void print(TrieNode root,String ans){
        if(root.isTerminating == true){
            System.out.println(ans);
            //return ans;
        }
        if(root.childCount==0)
            return ;
        for(int i =0;i<root.children.length;i++){
            if(root.children[i]!=null){
                String newAns = ans+root.children[i].data ;
                print(root.children[i],newAns) ;
            }
        }
    }
    public void autoComplete(ArrayList<String> input, String word) {
        // Complete this function
        // Print the output as specified in question

        for (int i=0;i<input.size();i++){
            add(input.get(i));
        }
        int childIndex = word.charAt(0)-'a';
        TrieNode child = root.children[childIndex];
        if(child==null)
            return ;
        String ans = "";
        while(child!=null && child.childCount!=0){
            ans+=child.data ;
            String temp = word.substring(1);
            if(temp.length()==0){
                print(child,ans);  //to print the all autocomplete words
                return ;
            }else{
                childIndex = temp.charAt(0)-'a';
                child = child.children[childIndex];
                word = temp ;
            }
        }


    }



    public boolean findIfPalindromePair(ArrayList<String> vect) {
        // Complete this function
        // Return the output as specified in question
        for (int i=0;i<vect.size();i++){
            add(vect.get(i));
        }

        return true;
    }


}
