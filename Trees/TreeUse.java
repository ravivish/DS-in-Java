package Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class TreeUse {


    public static void settoMinvalue(TreeNode<Integer> root,int max){

        if (root.data == max){
            root.data=Integer.MIN_VALUE;
        }
        for (int i=0;i<root.children.size();i++){
            settoMinvalue(root.children.get(i),max);
        }
    }

    public static TreeNode<Integer> findSecondLargestHelper(TreeNode<Integer> root) {

        TreeNode<Integer> max = new TreeNode<>(root.data);
        TreeNode<Integer> temp;
        for (int i = 0; i < root.children.size(); i++) {
            temp = findSecondLargestHelper(root.children.get(i));
            if (temp.data > max.data) {
                max.data = temp.data;
            }
        }
        return max;
    }

    public static TreeNode<Integer> findSecondLargest(TreeNode<Integer> root) {

        if (root == null) {
            return root;
        }
//        printlevelWise(root);
        TreeNode<Integer> max = findSecondLargestHelper(root);
        settoMinvalue(root,max.data);
        TreeNode<Integer> newmax=findSecondLargestHelper(root);
        printlevelWise(root);
        return newmax;
    }

    static class pair<T> {
        int sum;
        TreeNode<T> ans;

        pair(int sum, TreeNode<T> ans) {
            this.sum = sum;
            this.ans = ans;
        }
    }

    public static pair<Integer> helper(TreeNode<Integer> root) {
        // Write your code here
        pair<Integer> Ans = new pair<Integer>(root.data, root);

        for (int i = 0; i < root.children.size(); i++) {
            Ans.sum = Ans.sum + root.children.get(i).data;
        }
        pair<Integer> temp = null;
        for (int i = 0; i < root.children.size(); i++) {
            //complete karo
            temp = helper(root.children.get(i));
            if (temp.sum > Ans.sum) {
                Ans = temp;
            }


        }
        return Ans;
    }


    public static TreeNode<Integer> maxSumNode(TreeNode<Integer> root) {
        pair<Integer> a = helper(root);
        return a.ans;
    }


    public static TreeNode<Integer> findNextLargerNode(TreeNode<Integer> root, int n) {

        // Write your code here

        TreeNode<Integer> ans;
        if (root.data > n) {
            ans = root;
        } else {
            ans = null;
        }


        TreeNode<Integer> temp = null;

        for (int i = 0; i < root.children.size(); i++) {

            temp = findNextLargerNode(root.children.get(i), n);
            if (ans == null) {

                ans = temp;

            }
        }
        if (temp != null) {

            if (temp.data < ans.data) {
                ans = temp;
            }

        }
        return ans;
    }

    public static TreeNode<Integer> replacewithDepthHelper(TreeNode<Integer> root, int count) {

        if (root != null) {
            root.data = count;
            count++;
        }
        for (int i = 0; i < root.children.size(); i++) {

            replacewithDepthHelper(root.children.get(i), count);
        }
        return root;

    }

    public static void replaceWithDepthValue(TreeNode<Integer> root) {

        int x = 0;
        replacewithDepthHelper(root, x);
        printlevelWise(root);
    }

    public static boolean checkIdentical(TreeNode<Integer> root1, TreeNode<Integer> root2) {

        if (root1 == null && root2 == null)
            return true;
        if (root1 == null)
            return false;
        if (root2 == null)
            return false;

        if (root1.data != root2.data) {
            return false;
        }


        if (root1.children.size() != root2.children.size())
            return false;


        for (int i = 0; i < root1.children.size() && i < root2.children.size(); i++) {

            boolean ans = checkIdentical(root1.children.get(i), root2.children.get(i));
            if (!ans)
                return false;
        }
        return true;

    }


    public static boolean checkIfContainsX(TreeNode<Integer> root, int x) {

        // Write your code here
        if (root == null) {
            return false;
        }

        if (root.data == x) {
            return true;
        }
        boolean ans = false;
        for (int i = 0; i < root.children.size(); i++) {
            ans = checkIfContainsX(root.children.get(i), x);
            if (ans)
                break;
        }
        return ans;

    }

    public static void postOrder(TreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        for (int i = 0; i < root.children.size(); i++) {
            postOrder(root.children.get(i));
        }
        System.out.print(root.data + " ");
    }

    public static void preOrder(TreeNode<Integer> root) {
        if (root == null)
            return;
        System.out.print(root.data + " ");

        for (int i = 0; i < root.children.size(); i++) {
            preOrder(root.children.get(i));
        }
    }

    public static int countLeafNodes(TreeNode<Integer> root) {

        // Write your code here
        if (root == null) {
            return 0;
        }
        if (root.children.size() == 0) {
            return 1;
        }
        int count = 0;
        for (int i = 0; i < root.children.size(); i++) {
            count += countLeafNodes(root.children.get(i));
        }
        return count;

    }

    public static void printAtK(TreeNode<Integer> root, int k) {
        if (k < 0) {
            return;
        }
        if (k == 0) {
            System.out.print(root.data + " ");
            return;
        }

        for (int i = 0; i < root.children.size(); i++) {
            printAtK(root.children.get(i), k - 1);
        }

    }

    public static int height(TreeNode<Integer> root) {

        if (root == null) {
            return 0;
        }
        int h = 0, max = 0;
        for (int i = 0; i < root.children.size(); i++) {
            h = height(root.children.get(i));
            if (h > max)
                max = h;
        }
        return max + 1;
    }

    public static int numNodeGreater(TreeNode<Integer> root, int x) {

        int num = 0;
        for (int i = 0; i < root.children.size(); i++) {
            num += numNodeGreater(root.children.get(i), x);
        }
        if (root.data > x)
            num++;
        return num;


    }

    public static int numNodes(TreeNode<Integer> root) {

        int count = 1;
        for (int i = 0; i < root.children.size(); i++) {
            count = count + numNodes(root.children.get(i));
        }
        return count;

    }


    public static int sumOfAllNode(TreeNode<Integer> root) {
        int sum = root.data;
        for (int i = 0; i < root.children.size(); i++) {
            sum = sum + sumOfAllNode(root.children.get(i));
        }
        return sum;
    }

    public static TreeNode<Integer> takeInput(Scanner s) {
        int n;
        System.out.println("Enter next node");
        n = s.nextInt();
        TreeNode<Integer> root = new TreeNode<>(n);
        System.out.println("Enter no of children for " + n);
        int childCount = s.nextInt();
        for (int i = 0; i < childCount; i++) {
            TreeNode<Integer> child = takeInput(s);
            root.children.add(child);
        }
        return root;

    }

    public static void print(TreeNode<Integer> root) {
        String s = root.data + ":";
        for (int i = 0; i < root.children.size(); i++) {
            s = s + root.children.get(i).data + ",";
        }
        System.out.println(s);
        for (int i = 0; i < root.children.size(); i++) {
            print(root.children.get(i));
        }

    }

    public static TreeNode<Integer> takeInputlevelWise() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter root data");
        int rootData = s.nextInt();
        QueueUsingLL<TreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
        TreeNode<Integer> root = new TreeNode<>(rootData);
        pendingNodes.enqueue(root);
        while (!pendingNodes.isEmpty()) {
            try {
                TreeNode<Integer> frontNode = pendingNodes.dequeue();
                System.out.println("Enter no of childrens of " + frontNode.data);
                int numChildren = s.nextInt();
                for (int i = 0; i < numChildren; i++) {
                    System.out.println("Enter " + (i + 1) + "th child of " + frontNode.data);
                    int child = s.nextInt();
                    TreeNode<Integer> childNode = new TreeNode<>(child);
                    frontNode.children.add(childNode);
                    pendingNodes.enqueue(childNode);
                }
            } catch (QueueEmptyException e) {
//                Never reach here
                return null;
            }
        }
        return root;
    }

    public static void printlevelWise(TreeNode<Integer> root) {

        if (root == null) {
            return;
        }

        Queue<TreeNode<Integer>> queue = new LinkedList<>();

        queue.add(root);
        int size = 1;

        while (!queue.isEmpty()) {
            int children = 0;

            while (size != 0) {
                TreeNode<Integer> parent = queue.remove();

                System.out.print(parent.data + " ");
                for (int i = 0; i < parent.children.size(); i++) {
                    queue.add(parent.children.get(i));
                    children++;
                }
                size--;
            }
            System.out.println();
            size = children;
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

//        TreeNode<Integer> root = new TreeNode<>(4);
//        TreeNode<Integer> node1 = new TreeNode<>(2);
//        TreeNode<Integer> node2 = new TreeNode<>(3);
//        TreeNode<Integer> node3 = new TreeNode<>(5);
//        TreeNode<Integer> node4 = new TreeNode<>(6);
//        root.children.add(node1);
//        root.children.add(node2);
//        root.children.add(node3);
//        node2.children.add(node4);


//        TreeNode<Integer> root=takeInput(s);
//        print(root);

//        TreeNode<Integer> root=takeInputlevelWise();
//        printlevelWise(root);

//        TreeNode<Integer> root=takeInputlevelWise();
//        System.out.println("count = " + numNodes(root));

//        TreeNode<Integer> root = takeInputlevelWise();
//        System.out.print("sum = " + sumOfAllNode(root));

//        TreeNode<Integer> root = takeInputlevelWise();
//        int no = numNodeGreater(root, 35);
//        System.out.println("no = " + no);

//        TreeNode<Integer> root = takeInputlevelWise();
//        int height = height(root);
//        System.out.println("height = " + height);

//        TreeNode<Integer> root = takeInputlevelWise();
//        printAtK(root, 2);

//        TreeNode<Integer> root = takeInputlevelWise();
//        int leaf=countLeafNodes(root);
//        System.out.println("leaf = " + leaf);

//        TreeNode<Integer> root = takeInputlevelWise();
//        preOrder(root);

//        TreeNode<Integer> root = takeInputlevelWise();
//        postOrder(root);

//        TreeNode<Integer> root = takeInputlevelWise();
//        System.out.println("status = " + checkIfContainsX(root, 40));


//        TreeNode<Integer> root1 = takeInputlevelWise();
//        TreeNode<Integer> root2 = takeInputlevelWise();
//        System.out.println(checkIdentical(root1,root2));

//        TreeNode<Integer> root1 = takeInputlevelWise();
//        replaceWithDepthValue(root1);

//        TreeNode<Integer> root = takeInputlevelWise();
//        TreeNode<Integer> ans=findNextLargerNode(root,50);
//        System.out.println("Just greater than = "+ans.data);// It will causes an error when nextlarger valaue
                                                            //is not present because then ans=null
//        print(ans);

//        TreeNode<Integer> root = takeInputlevelWise();
//        System.out.print(maxSumNode(root).data);

        TreeNode<Integer> root=takeInputlevelWise();
        System.out.println("Second Largest= "+findSecondLargest(root).data);// It will causes an error when
                                                                        // Secondlargest valaue
                                                                    //is not present because then ans=null



    }

}
