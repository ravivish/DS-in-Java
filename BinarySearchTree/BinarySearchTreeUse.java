package BinarySearchTree;

import java.util.*;

public class BinarySearchTreeUse {


    public static boolean printPath(BinaryTreeNode<Integer> root, int sum, List<Integer> path){
        if(root == null){
            return false;
        }

        if(root.left == null && root.right == null){
            if(root.data == sum){
                path.add(root.data);
                return true;
            }else{
                return false;
            }
        }
        if(printPath(root.left, sum-root.data, path) || printPath(root.right, sum - root.data, path)){
            path.add(root.data);
            return true;
        }
        return false;
    }

    public static void rootToLeafPathsSumToK(BinaryTreeNode<Integer> root, int k) {
        // Write your code here
        List<Integer> result=new ArrayList<>();

        boolean r = printPath(root, 22, result);
        if(r){
            result.forEach(node -> System.out.print(root.data + " "));
        }else{
            System.out.println("No path for sum " + 22);
//            System.out.println(result.get(i));
        }


    }

//    public static boolean rootToLeafPathsSumToK(BinaryTreeNode<Integer> root, int k) {
//        // Write your code here
//
//        if (root == null)
//            return (k == 0);
//        else {
//            boolean ans = false;
//
//            /* otherwise check both subtrees */
//            int subsum = k - root.data;
//            if (subsum == 0 && root.left == null && root.right == null)
//                return true;
//            if (root.left != null)
//                ans = ans || rootToLeafPathsSumToK(root.left, subsum);
//            if (root.right != null)
//                ans = ans || rootToLeafPathsSumToK(root.right, subsum);
//            return ans;
//        }
//
//
//    }


    public static void nodesSumToS(BinaryTreeNode<Integer> root, int sum) {
        Stack<BinaryTreeNode<Integer>> s1 = new Stack<>();
        Stack<BinaryTreeNode<Integer>> s2 = new Stack<>();
        BinaryTreeNode<Integer> cur1 = root;
        BinaryTreeNode<Integer> cur2 = root;

        while (!s1.isEmpty() || !s2.isEmpty() || cur1 != null || cur2 != null) {


            if (cur1 != null || cur2 != null) {

                if (cur1 != null) {

                    s1.push(cur1);
                    cur1 = cur1.left;
                }

                if (cur2 != null) {
                    s2.push(cur2);
                    cur2 = cur2.right;
                }
            } else {

                int val1 = s1.peek().data;
                int val2 = s2.peek().data;

                if (s1.peek() == s2.peek()) {
                    break;
                }

                if (val1 + val2 == sum) {
                    System.out.println(Math.min(val1, val2) + " " + Math.max(val1, val2));
                }

                if (val1 + val2 < sum) {
                    cur1 = s1.pop();
                    cur1 = cur1.right;
                } else {
                    cur2 = s2.pop();
                    cur2 = cur2.left;
                }
            }
        }


    }


    public static BinaryTreeNode<Integer> helperLCAOfBT(BinaryTreeNode<Integer> root, int a, int b) {
        if (root == null)
            return null;
        if (root.data == a || root.data == b)
            return root;
        BinaryTreeNode<Integer> left = helperLCAOfBT(root.left, a, b);
        BinaryTreeNode<Integer> right = helperLCAOfBT(root.right, a, b);
        if (left != null && right != null)
            return root;
        return (left != null) ? left : right;
    }

    public static int lcaBinaryTree(BinaryTreeNode<Integer> root, int a, int b) {
        // Write your code here
        BinaryTreeNode<Integer> ans = helperLCAOfBT(root, a, b);
        if (ans != null) {
            return ans.data;
        } else {
            return -1;
        }

    }

    public static BinaryTreeNode<Integer> SortedArrayToBSTHelper(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }

        /* Get the middle element and make it root */
        int mid = (start + end) / 2;
        BinaryTreeNode<Integer> node = new BinaryTreeNode<>(arr[mid]);

        /* Recursively construct the left subtree and make it
        left child of root */
        node.left = SortedArrayToBSTHelper(arr, start, mid - 1);

        /* Recursively construct the right subtree and make it
        right child of root */
        node.right = SortedArrayToBSTHelper(arr, mid + 1, end);

        return node;
    }

    public static BinaryTreeNode<Integer> SortedArrayToBST(int[] arr) {


        BinaryTreeNode<Integer> root = SortedArrayToBSTHelper(arr, 0, arr.length - 1);

        return root;
    }


    public static boolean isBST(BinaryTreeNode<Integer> root) {
        return isBSTUtil(root, Integer.MIN_VALUE,
                Integer.MAX_VALUE);
    }

    /* Returns true if the given tree is a BST and its
      values are >= min and <= max. */
    public static boolean isBSTUtil(BinaryTreeNode<Integer> node, int min, int max) {
        /* an empty tree is BST */
        if (node == null)
            return true;

        /* false if this node violates the min/max constraints */
        if (node.data < min || node.data > max)
            return false;

        /* otherwise check the subtrees recursively
        tightening the min/max constraints */
        // Allow only distinct values
        return (isBSTUtil(node.left, min, node.data - 1) &&
                isBSTUtil(node.right, node.data + 1, max));
    }

    public static void printNodeFromK1ToK2(BinaryTreeNode<Integer> root, int k1, int k2) {
        if (root == null)
            return;

        if (root.data >= k1) {

            printNodeFromK1ToK2(root.left, k1, k2);
        }

        if (root.data >= k1 && root.data <= k2) {
            System.out.print(root.data + " ");
        }
        if (root.data <= k2) {

            printNodeFromK1ToK2(root.right, k1, k2);
        }
    }

    public static BinaryTreeNode<Integer> searchInBST(BinaryTreeNode<Integer> root, int k) {

        while (root != null) {
            // pass right subtree as new tree
            if (k > root.data)
                root = root.right;

                // pass left subtree as new tree
            else if (k < root.data)
                root = root.left;
            else
                return root;// if the key is found return 1
        }
        return null;

    }


    public static BinaryTreeNode<Integer> takeInputLevelWise() {


        Scanner s = new Scanner(System.in);

        Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList<>();

        System.out.println("Enter root data");

        int rootData = s.nextInt();

        if (rootData == -1) {

            return null;

        }

        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);

        pendingNodes.add(root);


        while (!pendingNodes.isEmpty()) {

            BinaryTreeNode<Integer> front;

            front = pendingNodes.remove();

            System.out.println("Enter left child of " + front.data);

            int leftChild = s.nextInt();

            if (leftChild != -1) {

                BinaryTreeNode<Integer> child = new BinaryTreeNode<>(leftChild);

                pendingNodes.add(child);

                front.left = child;

            }


            System.out.println("Enter right child of " + front.data);

            int rightChild = s.nextInt();

            if (rightChild != -1) {

                BinaryTreeNode<Integer> child = new BinaryTreeNode<>(rightChild);

                pendingNodes.add(child);
                front.right = child;

            }

        }
        return root;
    }

    public static void printLevelWise(BinaryTreeNode<Integer> root) {

        if (root == null) {
            return;
        }
        Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {

            root = q.remove();
            System.out.print(root.data + ":");
            if (root.left != null) {
                System.out.print("L:" + root.left.data + ",");
                q.add(root.left);
            }
            if (root.left == null) {
                System.out.print("L:" + "-1,");
            }
            if (root.right != null) {
                System.out.print("R:" + root.right.data);
                System.out.println();
                q.add(root.right);
            }
            if (root.right == null) {
                System.out.print("R:" + "-1");
                System.out.println();

            }
        }
    }


    public static void main(String[] args) {
//        BinaryTreeNode<Integer> root = takeInputLevelWise();
//        if (searchInBST(root, 8) == null) ;
//        else
//            System.out.println(searchInBST(root, 8).data);

//        BinaryTreeNode<Integer> root=takeInputLevelWise();
//        System.out.println(isBST(root));


//        BSTClass bstClass=new BSTClass();
//        bstClass.insertData(10);
//        bstClass.insertData(20);
//        bstClass.insertData(5);
//        bstClass.insertData(15);
//        bstClass.insertData(3);
//        bstClass.insertData(7);
////        bstClass.printTree();
////        bstClass.deleteData(10);
////        bstClass.printTree();
//        bstClass.search(20);

//        BinaryTreeNode<Integer> root = takeInputLevelWise();
//        nodesSumToS(root, 15);


    }
}
