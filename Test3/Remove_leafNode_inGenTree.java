package Test3;

public class Remove_leafNode_inGenTree {


    /*
    *
    * Remove all leaf nodes from a given generic Tree.
    * Leaf nodes are those nodes, which don't have any children.
    *
    *
    * Sample i/p= " 10 3 20 30 40 2 40 50 0 0 0 0 "
    * o/p= "10 20"
    * */

    public static TreeNode<Integer> removeLeafNodes(TreeNode<Integer> root) {
        if (root == null) {
            return null;
        }
        if (root.children.size() == 0) {
            return root;
        }
        for (int i = 0; i < root.children.size(); i++) {
            root = removeLeafNodes(root.children.get(i));
        }
        return root;
    }


}
