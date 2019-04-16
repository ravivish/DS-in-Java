package Test3;


public class Check_cousin {

    /*
    *
    * Given the binary Tree and two nodes
    * say ‘p’ and ‘q’. Determine whether the two
    * nodes are cousins of each other or not. T
    * wo nodes are said to be cousins of each other if
    * they are at same level of the Binary Tree and have
    * different parents.
    * Do it in O(n).
    *
    *
    * Sample input "5 6 10 2 3 4 -1 -1 -1 -1 9 -1 -1 -1 -1" "2 4"
    * o/p=true
    * */

    public static int helper(BinaryTreeNode<Integer> root){
        if (root == null) {
            return 0;
        }
//        if (root.data == p)

        int h1 = 1, h2 = 1;
        h1 += helper(root.left);
        h2 += helper(root.right);
        return (h1 >= h2) ? h1 : h2;
    }

//    public static boolean isCousin(BinaryTreeNode<Integer> root, int p, int q) {
//
//
//    }

}
