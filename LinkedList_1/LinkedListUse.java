package LinkedList_1;

import java.util.Scanner;

public class LinkedListUse {

    public static boolean isPalindrome_2(Node<Integer> head) {

        Node<Integer> temp = head;
        int count = 0;
        while (temp != null) {
            temp = temp.next;
            count++;
        }
        int i = 0;
        Node<Integer> head1 = head;
//        System.out.println("len= "+count+ " count/2="+ count/2);
        while (i < (count / 2)-1) {
            head1 = head1.next;
            i++;
        }
        Node<Integer> newHead = head1.next;
        head1.next = null;
        /*
         * reverse newHead for comparing
         * */
        Node<Integer> curr=newHead,prev=null,next1;
        while (curr != null){
            next1 =curr.next;
            curr.next = prev;
            prev = curr;
            curr = next1;
        }
        newHead = prev;
        /*
        * Comparing the data
        * */
            while (head != null || newHead != null) {
                if (head.data == newHead.data) {
                    head = head.next;
                    newHead = newHead.next;
                }
                else
                    return false;
            }
        return true;
    }


    public static Node<Integer> removeDuplicates(Node<Integer> head) {

        Node<Integer> temp1 = head;
        if (temp1 == null) {
            return head;
        }
        Node<Integer> temp2 = head.next;
        if (temp2 == null) {
            return head;
        }
        while (temp2 != null) {
            if (temp1.data == temp2.data) {
                temp2 = temp2.next;
                temp1.next = temp2;
            } else {
                temp1 = temp2;
                temp2 = temp2.next;
            }
        }
        return head;
    }


    public static void printReverseRecursive(Node<Integer> root) {
        /*
         * First and Iterative solution in O(n^2)
         * */
        Node<Integer> temp = root;
        int count = 0;
        while (temp != null) {
            temp = temp.next;
            count++;
        }
        int i;
        while (count > 0) {
            i = 0;
            temp = root;
            while (i < count - 1) {
                temp = temp.next;
                i++;
            }
            System.out.print(temp.data + " ");
            count--;
        }

        /*
         * Second and Recursive solution in O(n)
         *
         * */

//        Node<Integer> temp1=root;


    }

    public static Node<Integer> append(Node<Integer> root, int n) {

        Node<Integer> temp = root;
        int length = 0;
        while (temp != null) {
            temp = temp.next;
            length++;
        }

        Node<Integer> curr = root;
        Node<Integer> curr2 = root;
        int count = length - n;
        int i = 0;
        while (i < count - 1) {
            curr = curr.next;
            i++;
        }
        Node<Integer> head2 = curr.next;
        curr.next = null;
        Node<Integer> temp2 = head2;
        while (temp2.next != null) {
            temp2 = temp2.next;
        }
        temp2.next = curr2;
        return head2;

    }

    public static int indexOfNIter(Node<Integer> head, int n) {
        Node<Integer> temp = head;
        int count = 0;
        while (temp != null) {
            if (temp.data == n) {
                return count;
            }
            temp = temp.next;
            count++;
        }
        return -1;
    }

    public static Node<Integer> deleteIthNode(Node<Integer> head, int i) {
        Node<Integer> temp = head;
        int count = 0;
        while (temp != null) {
            temp = temp.next;
            count++;
        }
        if (i >= count) {
            return head;
        }
        System.out.println("count = " + count);
        System.out.println("i = " + i);
        temp = head;
        int count1 = 0;
        if (i == 0) {
            return temp.next;
        } else {
            while (count1 < i - 1) {
                temp = temp.next;
                count1++;
            }
            temp.next = temp.next.next;
        }
        return head;
    }

    public static Node<Integer> insertAtPosition(Node<Integer> head, int data, int pos) {

        Node<Integer> temp = head;
        Node<Integer> newNode = new Node<>(data);
        if (pos == 0) {
            newNode.next = head;
            return newNode;
        }
        int i = 0;
        while (i < pos - 1) {
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        return head;
    }

    public static void printIth(Node<Integer> head, int i) {

        Node<Integer> temp = head;
        int count = 0;
        while (temp != null) {
            if (i == count) {
                System.out.println("temp = " + temp.data);
            }
            temp = temp.next;
            count++;
        }


    }

    public static int length(Node<Integer> head) {
        Node<Integer> temp = head;
        int count = 0;
        while (temp != null) {
            temp = temp.next;
            count++;
        }
        return count;
    }


    private static Node<Integer> takeInput() {
        Node<Integer> head = null, tail = null;
        Scanner scanner = new Scanner(System.in);
        int data = scanner.nextInt();
        while (data != -1) {
            Node<Integer> newNode = new Node<>(data);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
//                Node<Integer> temp = head;    //  we only need this
//                while (temp.next != null) {   //  when we don't have
//                    temp = temp.next;         //  tail node(This takes the complexity to O(n^2))
//                }                             //  because 1(for 1st node)+1+2+3+...+(n-1)=((n-1)(n)/2)=O(n^2)
//                temp.next = newNode;
                tail.next = newNode;                    // if we remember the last node then the
                tail = newNode; //tail = tail.next      // complexity will be O(n)

            }
            data = scanner.nextInt();
        }
        return head;
    }

    public static void print(Node<Integer> head) {

        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static void increment(Node<Integer> head) {
        Node<Integer> temp = head;
        while (temp != null) {
            temp.data++;
            temp = temp.next;
        }
    }

    public static void main(String[] args) {

//        Node<Integer> node1 = new Node<>(10);
//        Node<Integer> node2 = new Node<>(20);
//        Node<Integer> node3 = new Node<>(30);
//        Node<Integer> node4 = new Node<>(40);
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        Node<Integer> head = node1;
//        increment(head);
//        printIth(head);
        Node<Integer> head = takeInput();
        System.out.print("Before : ");
        print(head);

//        int len=length(head);
//        System.out.println("Length of list is : "+ len);
//        printIth(head,1);

        System.out.println();

//        head = insertAtPosition(head, 80, 0);
//        print(head);
//        head = deleteIthNode(head, 1);
//        print(head);

//        int index = indexOfNIter(head,20);
//        System.out.println("index = " + index);

//        printReverseRecursive(head);

//        head = append(head, 3);
//        print(head);

//        head = removeDuplicates(head);
//        print(head);

        boolean status = isPalindrome_2(head);
        System.out.println("status = " + status);

    }
}
