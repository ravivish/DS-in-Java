package BinaryTree;

import java.util.*;

public class BinaryTreeUse {


    static class Node<T> {
        T data;
        Node<T> next;
        Node(T data){
            this.data = data;
        }
    }


    public static ArrayList<Node<BinaryTreeNode<Integer>>> LLforEachLevel(BinaryTreeNode<Integer> root){

        if(root == null){
            return null;
        }

        //Make two queues
        Queue<BinaryTreeNode<Integer>> q1 = new LinkedList<>();
        Queue<BinaryTreeNode<Integer>> q2 = new LinkedList<>();
        //put root in 1st one
        q1.add(root);

        Node<BinaryTreeNode<Integer>> head = null,tail = null,newNode;

        ArrayList<Node<BinaryTreeNode<Integer>>> output = new ArrayList<>();

        //same process as level order traversal

        while(!q1.isEmpty()){
            BinaryTreeNode<Integer> currentNode;
            try {
                currentNode = q1.remove();
                newNode = new Node<BinaryTreeNode<Integer>>(currentNode);
                if(head == null){
                    head = newNode;
                    tail = newNode;
                }

                else{
                    tail.next = newNode;
                    tail = newNode;
                }

                if(currentNode.left != null){
                    q2.add(currentNode.left);
                }

                if(currentNode.right != null){
                    q2.add(currentNode.right);
                }

                if(q1.isEmpty()){
                    output.add(head);
                    head = null;
                    tail = null;

                    Queue<BinaryTreeNode<Integer>> temp = q1;
                    q1 = q2;
                    q2 = temp;
                }
            }
            catch(Exception e){
            }
        }
        return output;
    }


    public static void printZigZag(BinaryTreeNode<Integer> root) {

        // if null then return
        if (root == null) {
            return;
        }

        // declare two stacks
        Stack<BinaryTreeNode<Integer>> currentLevel = new Stack<>();
        Stack<BinaryTreeNode<Integer>> nextLevel = new Stack<>();

        // push the root
        currentLevel.push(root);
        boolean leftToRight = true;

        // check if stack is empty
        while (!currentLevel.isEmpty()) {

            // pop out of stack
            BinaryTreeNode<Integer> node = currentLevel.pop();

            // print the data in it
            System.out.print(node.data + " ");

            // store data according to current
            // order.
            if (leftToRight) {
                if (node.left != null) {
                    nextLevel.push(node.left);
                }

                if (node.right != null) {
                    nextLevel.push(node.right);
                }
            }
            else {
                if (node.right != null) {
                    nextLevel.push(node.right);
                }

                if (node.left != null) {
                    nextLevel.push(node.left);
                }
            }

            if (currentLevel.isEmpty()) {
                System.out.println();
                leftToRight = !leftToRight;
                Stack<BinaryTreeNode<Integer>> temp = currentLevel;
                currentLevel = nextLevel;
                nextLevel = temp;
            }
        }
    }

    public static BinaryTreeNode<Integer> removeAllLeaves(BinaryTreeNode<Integer> root) {

        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return null;
        }
        /*
         * now preorder traversal using rootleft and root.right
         * */
//        System.out.println(root.data+" ");
        root.left = removeAllLeaves(root.left);
        root.right = removeAllLeaves(root.right);
        return root;

    }

    public static boolean checkBalanced(BinaryTreeNode<Integer> root) {

        int lh; /* for height of left subtree */

        int rh; /* for height of right subtree */

        /* If tree is empty then return true */
        if (root == null)
            return true;

        /* Get the height of left and right sub trees */
        lh = height(root.left);
        rh = height(root.right);

        if (Math.abs(lh - rh) <= 1
                && checkBalanced(root.left)
                && checkBalanced(root.right))
            return true;

        /* If we reach here then tree is not height-balanced */
        return false;
    }

    public static BinaryTreeNode<Integer> getTreeFromPostorderAndInorder(int[] inorder, int[] postorder) {

        int inStart = 0;
        int inEnd = inorder.length - 1;
        int postStart = 0;
        int postEnd = postorder.length - 1;

        return getTreeFromPostorderAndInorderhelper(inorder, inStart, inEnd, postorder, postStart, postEnd);
    }

    public static BinaryTreeNode<Integer> getTreeFromPostorderAndInorderhelper(int[] inorder, int inStart, int inEnd,
                                             int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd)
            return null;

        int rootValue = postorder[postEnd];
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootValue);

        int k = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootValue) {
                k = i;
                break;
            }
        }

        root.left = getTreeFromPostorderAndInorderhelper(inorder, inStart, k - 1, postorder, postStart,
                postStart + k - (inStart + 1));
        // Becuase k is not the length, it it need to -(inStart+1) to get the length
        root.right = getTreeFromPostorderAndInorderhelper(inorder, k + 1, inEnd, postorder, postStart + k - inStart, postEnd - 1);
        // postStart+k-inStart = postStart+k-(inStart+1) +1

        return root;
    }


    public static BinaryTreeNode<Integer> getTreeFromPreorderAndInorder(int[] pre, int[] in) {

        int preStart = 0;
        int preEnd = pre.length - 1;
        int inStart = 0;
        int inEnd = in.length - 1;

        return getTreeFromPreorderAndInorderhelper(pre, preStart, preEnd, in, inStart, inEnd);
    }

    public static BinaryTreeNode<Integer> getTreeFromPreorderAndInorderhelper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        int val = preorder[preStart];
        BinaryTreeNode<Integer> p = new BinaryTreeNode<Integer>(val);

        //find parent element index from inorder
        int k = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (val == inorder[i]) {
                k = i;
                break;
            }
        }

        p.left = getTreeFromPreorderAndInorderhelper(preorder, preStart + 1, preStart + (k - inStart), inorder, inStart, k - 1);
        p.right = getTreeFromPreorderAndInorderhelper(preorder, preStart + (k - inStart) + 1, preEnd, inorder, k + 1, inEnd);

        return p;

    }

    public static Pair<Integer, Integer> heightDiameter(BinaryTreeNode<Integer> root) {

        if (root == null) {
            Pair<Integer, Integer> output = new Pair<>();
            output.first = 0;
            output.second = 0;
            return output;
        }
        Pair<Integer, Integer> lo = heightDiameter(root.left);
        Pair<Integer, Integer> ro = heightDiameter(root.right);
        int height = 1 + Math.max(lo.first, ro.first);
        int option1 = lo.first + ro.first; // (left.height + right.height)
        int option2 = lo.second; // left subtree diameter
        int option3 = ro.second; // right subtree diameter
        int diameter = Math.max(option1, Math.max(option2, option3));
        Pair<Integer, Integer> output = new Pair<>();
        output.first = height;
        output.second = diameter;
        return output;

    }

    public static int diameter(BinaryTreeNode<Integer> root) {

        if (root == null) {
            return 0;
        }
        int option1 = heightfordiameter(root.left) + heightfordiameter(root.right);
        int option2 = diameter(root.left);
        int option3 = diameter(root.right);
        return Math.max(option1, Math.max(option2, option3));

    }

    public static int heightfordiameter(BinaryTreeNode<Integer> root) {

        if (root == null) {
            return 0;
        }

        return 1 + Math.max(heightfordiameter(root.left), heightfordiameter(root.right));
    }


    public static void printNodesWithoutSibling(BinaryTreeNode<Integer> root) {
        if (root == null){
            return;
        }

        if (root.left != null && root.right != null) {
            printNodesWithoutSibling(root.left);
            printNodesWithoutSibling(root.right);
        }

        else if (root.left != null){
            System.out.println(root.left.data+" ");
            printNodesWithoutSibling(root.left);

        }

        else if( root.right != null){
            System.out.println(root.right.data+" ");
            printNodesWithoutSibling(root.right);
        }

    }

    public static void postOrder(BinaryTreeNode<Integer> root) {
        if (root == null)
            return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");

    }

    public static void preOrder(BinaryTreeNode<Integer> root) {
        if (root == null)
            return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);

    }

    public static int sum(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        int s;
        s = root.data;
        s += sum(root.left);
        s += sum(root.right);
//        System.out.println(s);
        return s;


    }

    public static void mirror(BinaryTreeNode<Integer> root) {

        if (root == null) {
            return;
        }

        BinaryTreeNode<Integer> temp = root.left;
        root.left = root.right;
        root.right = temp;
        mirror(root.left);
        mirror(root.right);

    }


    public static int height(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        int h1 = 1, h2 = 1;
        h1 += height(root.left);
        h2 += height(root.right);
        return (h1 >= h2) ? h1 : h2;
    }

    public static boolean isNodePresent(BinaryTreeNode<Integer> root, int x) {

        if (root != null) {

            if (root.data == x) {
                return true;
            } else {
                return isNodePresent(root.left, x) || isNodePresent(root.right, x);
            }
        }
        return false;
    }

    public static int countNode(BinaryTreeNode<Integer> root) {
        if (root == null)
            return 0;
        int ans = 1;
        ans += countNode(root.left);
        ans += countNode(root.right);
        return ans;
    }

    public static void print(BinaryTreeNode<Integer> root) {

        if (root == null) {
            return;
        }

        String toBePrinted = root.data + ":";
        if (root.left != null) {
            toBePrinted += " L:" + root.left.data + ",";
        }
        if (root.right != null) {
            toBePrinted += " R:" + root.right.data;
        }
        System.out.println(toBePrinted);
        print(root.left);
        print(root.right);

    }

    public static BinaryTreeNode<Integer> takeInput(Scanner s) {
        int rootData;
        System.out.println("Enter root Data: ");
        rootData = s.nextInt();
        if (rootData == -1) {
            return null;
        }

        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        root.left = takeInput(s);
        root.right = takeInput(s);
        return root;
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
//        Scanner s = new Scanner(System.in);
//        BinaryTreeNode<Integer> root=new BinaryTreeNode<>(1);
//        BinaryTreeNode<Integer> node1=new BinaryTreeNode<>(2);
//        root.left=node1;
//        BinaryTreeNode<Integer> node2=new BinaryTreeNode<>(3);
//        root.right=node2;

//        BinaryTreeNode<Integer> root = takeInput(s);
//        print(root);
//        s.close();

//        BinaryTreeNode<Integer> root = takeInputLevelWise();
//        printLevelWise(root);

//        BinaryTreeNode<Integer> root=takeInputLevelWise();
//        printLevelWise(root);
//        System.out.println("No. of nodes = " +countNode(root));

//        BinaryTreeNode<Integer> root = takeInputLevelWise();
//        System.out.println(isNodePresent(root, 7));

//        BinaryTreeNode<Integer> root1 = takeInputLevelWise();
//        System.out.println(height(root1));

//        BinaryTreeNode<Integer> root=takeInputLevelWise();
//        mirror(root);
//        printLevelWise(root);

//        BinaryTreeNode<Integer> root = takeInputLevelWise();
//        System.out.println("sum = " + sum(root));

//        BinaryTreeNode<Integer> root=takeInputLevelWise();
//        preOrder(root);

//        BinaryTreeNode<Integer> root = takeInputLevelWise();
//        postOrder(root);

//        BinaryTreeNode<Integer> root = takeInputLevelWise();
//        printNodesWithoutSibling(root);
//        printLevelWise(root);

//        BinaryTreeNode<Integer> root=takeInputLevelWise();
//        System.out.println("Diameter = "+diameter(root)); // O(n^2)

//        BinaryTreeNode<Integer> root = takeInputLevelWise();
//        System.out.println("Diameter = " + heightDiameter(root).second);// Improved O(n)
//        System.out.println("height = " + heightDiameter(root).first);

//        BinaryTreeNode<Integer> root = takeInputLevelWise();
//        System.out.println("status = " + checkBalanced(root));

//        BinaryTreeNode<Integer> root=takeInputLevelWise();
//        printNodesWithoutSibling(root);

//        BinaryTreeNode<Integer> root=takeInputLevelWise();
//        ArrayList<Node<BinaryTreeNode<Integer>>> ans=LLforEachLevel(root);
//        System.out.println(ans);

    }
}
