package LinkedList_2;


import java.util.Scanner;

public class LinkedListNodeUse {
    private static LinkedListNode<Integer> helperofbublesort_swap(LinkedListNode<Integer> head, int i, int j) {
        if(i==0 || j==0)
        {
            if(j==0)
            {
                j=i;
                i=0;
            }
            LinkedListNode<Integer> temp=head;
            int k=1;
            while(k!=j)
            {
                temp=temp.next;
                k++;
            }
            LinkedListNode<Integer> temp2=head;
            temp2=temp.next;
            temp.next=head;
            head=temp2;
            temp2=head.next;
            head.next=temp.next.next;
            temp.next.next=temp2;
            return head;

        }


        LinkedListNode<Integer> temp=head;
        LinkedListNode<Integer> temp2=head;

        int k=1;
        while(k!=i)
        {
            temp=temp.next;
            k++;
        }
        LinkedListNode<Integer> temp3=temp.next;
        k=1;
        while(k!=j)
        {
            temp2=temp2.next;
            k++;

        }
        LinkedListNode<Integer> temp4=temp2.next;
        temp.next=temp4;
        temp2.next=temp3;
        temp4=temp4.next;
        temp.next.next=temp3.next;
        temp3.next=temp4;
        return head;
    }

    public static LinkedListNode<Integer> bubbleSort(LinkedListNode<Integer> head) {
        //Write your code here
        LinkedListNode<Integer> temp = head;
        int count = 0;
        while (temp != null) {
            temp = temp.next;
            count++;
        }
        LinkedListNode<Integer> curr = head;
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count; j++) {
                if (curr.next == null && curr.next.next == null){
                    return head;
                }
                if (curr.data > curr.next.data) {
                    curr = helperofbublesort_swap(curr, i, j);
                }
            }
            curr = curr.next;
        }
        return head;
    }

    public static LinkedListNode<Integer> skipMdeleteN(LinkedListNode<Integer> head, int M, int N) {

        if (head == null && head.next == null)
            return head;
        LinkedListNode<Integer> temp = head;
        LinkedListNode<Integer> curr = head;
        while (temp != null) {
            int count = 0;
            while (temp != null && count != M - 1) {
                temp = temp.next;
                count++;
            }
            int count1 = 0;
            if (temp == null) {
                return head;
            }
//        System.out.println("temp = " + temp.data);
            LinkedListNode<Integer> temp1 = temp.next;
            while (count1 != N && temp1 != null) {
                temp1 = temp1.next;
                count1++;
            }
            temp.next = temp1;
            temp = temp1;
//            System.out.println("temp1 = " + temp1.data);
        }

        return head;
    }

    public static LinkedListNode<Integer> kReverse(LinkedListNode<Integer> head, int k) {
        LinkedListNode<Integer> curr = head;
        LinkedListNode<Integer> prev = null, next = null;
        int count = 0;
        while (count < k && curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        if (next != null) {
            head.next = kReverse(next, k);
        }
        return prev;
    }

    public static LinkedListNode<Integer> swap_nodes(LinkedListNode<Integer> head, int i, int j) {

        if (i == j) {
            return head;
        }
        LinkedListNode<Integer> c1 = head, p1 = null;
        LinkedListNode<Integer> c2 = head, p2 = null;
        int count = 0;
        while (c1.next != null && count < i) {
            p1 = c1;
            c1 = c1.next;
            count++;
        }

        count = 0;
        while (c2.next != null && count < j) {
            p2 = c2;
            c2 = c2.next;
            count++;
        }

        if (c2 == null || c1 == null)
            return head;

        if (p1 != null)
            p1.next = c2;
        else
            head = c2;

        if (p2 != null)
            p2.next = c1;
        else
            head = c1;

        LinkedListNode<Integer> temp = c1.next;
        c1.next = c2.next;
        c2.next = temp;

        return head;
    }

    private static LinkedListNode<Integer> sortedMerge(LinkedListNode<Integer> a, LinkedListNode<Integer> b) {
        LinkedListNode<Integer> result = null;
        if (a == null)
            return b;
        if (b == null)
            return a;

        if (a.data <= b.data) {
            result = a;
            result.next = sortedMerge(a.next, b);
        } else {
            result = b;
            result.next = sortedMerge(a, b.next);
        }
        return result;

    }

    private static LinkedListNode<Integer> middleofLLfor_mergesort(LinkedListNode<Integer> head) {

        LinkedListNode<Integer> slow = head;
        LinkedListNode<Integer> fast = head;
        LinkedListNode<Integer> temp = head;
        int count = 0;
        while (temp != null) {
            temp = temp.next;
            count++;
        }
        if (count % 2 == 0) {

            while (fast.next.next != null) {
                if (fast.next.next.next.next == null) {
                    slow = slow.next;
                    break;
                } else {
                    fast = fast.next.next;
                    slow = slow.next;
                }
            }
        } else {
            while (fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
        }

        return slow;

    }

    public static LinkedListNode<Integer> mergeSort(LinkedListNode<Integer> head) {
        // write your code here
        if (head == null || head.next == null) {
            return head;
        }
        LinkedListNode<Integer> middle_node = middleofLLfor_mergesort(head);
        LinkedListNode<Integer> list2head = middle_node.next;
        middle_node.next = null;
//        print(head);
//        System.out.print(" \n list 2: ");
//        print(list2head);
        LinkedListNode<Integer> leftlist = mergeSort(head);
        LinkedListNode<Integer> rightlist = mergeSort(list2head);
        LinkedListNode<Integer> sortedlist = sortedMerge(leftlist, rightlist);
        return sortedlist;
    }

    public static LinkedListNode<Integer> reverse_R(LinkedListNode<Integer> head) {
        if (head == null) {
            return head;
        }
        if (head.next == null) {
            return head;
        }

        LinkedListNode<Integer> temp = head.next, temp1;
        temp1 = reverse_R(head.next);
        temp.next = head;
        head.next = null;
        return temp1;

    }

    public static LinkedListNode<Integer> reverse_I(LinkedListNode<Integer> head) {

        LinkedListNode<Integer> curr = head;
        LinkedListNode<Integer> pre = null;
        LinkedListNode<Integer> temp;
        while (curr != null) {
            temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }

        return pre;

    }

    public static LinkedListNode<Integer> helperofDeleteIthNodeRec(LinkedListNode<Integer> head, int i, int index) {
        LinkedListNode<Integer> temp = head;
        if (head == null) {
            return head;
        }
        if (i == index) {
            temp.next = temp.next.next;
            return head;
        }
        temp.next = helperofDeleteIthNodeRec(temp.next, i, index + 1);
        return temp;
    }

    public static LinkedListNode<Integer> deleteIthNodeRec(LinkedListNode<Integer> head, int i) {
        if (head == null) {
            return head;
        }
        LinkedListNode<Integer> temp = head;
        int count = 0;
        while (temp != null) {
            temp = temp.next;
            count++;
        }
        if (i >= count) {
            return head;
        }
        if (i == 0) {
            return head.next;
        }

        head.next = helperofDeleteIthNodeRec(head.next, i - 1, 1);

        return head;
    }

    public static LinkedListNode<Integer> sortEvenOdd(LinkedListNode<Integer> head) {

        LinkedListNode<Integer> temp = head;
        LinkedListNode<Integer> oddhead = null;
        LinkedListNode<Integer> oddtail = null;
        LinkedListNode<Integer> evenhead = null;
        LinkedListNode<Integer> eventail = null;
        if (head == null) {
            return head;
        }
        while (temp != null) {
            if (temp.data % 2 != 0) {
                if (oddhead == null) {
                    oddhead = oddtail = temp;
                    temp = temp.next;
                } else {
                    oddtail.next = temp;
                    temp = temp.next;
                    oddtail = oddtail.next;
                }
            } else {
                if (evenhead == null) {
                    evenhead = eventail = temp;
                    temp = temp.next;
                } else {
                    eventail.next = temp;
                    temp = temp.next;
                    eventail = eventail.next;
                }
            }
        }
        if (oddhead == null) {
            return evenhead;
        } else if (evenhead == null) {
            return oddhead;
        }
        oddtail.next = null;
        eventail.next = null;
        oddtail.next = evenhead;
        return oddhead;

    }

    public static int helperindexOfNRec(LinkedListNode<Integer> head, int n, int index) {

        if (head == null)
            return -1;
        if (head.data == n)
            return index;
        int ans = helperindexOfNRec(head.next, n, index + 1);
        return ans;
    }

    public static int indexOfNRec(LinkedListNode<Integer> head, int n) {

        if (head == null) {
            return -1;
        }
        if (head.data == n) {
            return 0;
        }
        int ans = helperindexOfNRec(head.next, n, 1);
        return ans;
    }


    public static LinkedListNode<Integer> mergeTwoList
            (LinkedListNode<Integer> head1, LinkedListNode<Integer> head2) {


        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }


        LinkedListNode<Integer> t1 = head1;
        LinkedListNode<Integer> t2 = head2;

        LinkedListNode<Integer> head = null;
        LinkedListNode<Integer> tail = null;


        while (t1 != null && t2 != null) {
            if ((int) t1.data <= (int) t2.data) {
                if (head == null) {
                    head = tail = t1;
                } else {
                    tail.next = t1;
                    tail = tail.next;

                }
                t1 = t1.next;
            } else {
                if (head == null) {
                    head = tail = t2;

                } else {
                    tail.next = t2;
                    tail = tail.next;
                }
                t2 = t2.next;
            }
        }


        tail.next = null;

        if (t1 != null) {
            tail.next = t1;
        }

        if (t2 != null) {
            tail.next = t2;
        }


        return head;
    }

    public static int printMiddel(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> slow = head;
        LinkedListNode<Integer> fast = head;
        LinkedListNode<Integer> temp = head;
        int count = 0;
        while (temp != null) {
            temp = temp.next;
            count++;
        }
        if (count % 2 == 0) {

            while (fast != null) {
                if (fast.next.next.next.next == null) {
//                    fast = fast.next.next;
                    slow = slow.next;
                    break;
                } else {
                    fast = fast.next.next;
                    slow = slow.next;
                }
            }
        } else {
            while (fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
        }

        return slow.data;
    }

    public static void print(LinkedListNode<Integer> head) {

        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    private static LinkedListNode<Integer> takeInput() {
        LinkedListNode<Integer> head = null, tail = null;
        Scanner scanner = new Scanner(System.in);
        int data = scanner.nextInt();
        while (data != -1) {
            LinkedListNode<Integer> newNode = new LinkedListNode<>(data);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
//                LinkedListNode<Integer> temp = head;    //  we only need this
//                while (temp.next != null) {            //  when we don't have
//                    temp = temp.next;                 //  tail node(This takes the complexity to O(n^2))
//                }                                    //  because 1(for 1st node)+1+2+3+...+(n-1)=((n-1)(n)/2)=O(n^2)
//                temp.next = newNode;
                tail.next = newNode;                    // if we remember the last node then the
                tail = newNode; //tail = tail.next     // complexity will be O(n)

            }
            data = scanner.nextInt();
        }
        return head;
    }

    public static void main(String[] args) {
        LinkedListNode<Integer> head = takeInput();
        System.out.print("Before : ");
        print(head);
        System.out.println();
        /*
         * return the middle element
         * */
//        int middle = printMiddel(head);
//        System.out.println("middle = " + middle);

        /*
         * merge two sorted list in increasing order in O(1) space
         * */
//        System.out.print("List 1:");
//        LinkedListNode<Integer> head1 = takeInput();
//        System.out.print("List 2:");
//        LinkedListNode<Integer> head2 = takeInput();
//        head1 = mergeTwoList(head1, head2);
//        print(head1);

        /*
         * return the index of an integer in LinkedList recursively
         * */
//        int index=indexOfNRec(head,3);
//        System.out.println("index = " + index);

        /*
         * sort the LinkedList as Even after odd
         * */
//        head = sortEvenOdd(head);
//        print(head);

        /*
         * Delete ith node recursively
         * */
//        head = deleteIthNodeRec(head,2);
//        print(head);

        /*
         * Reverse the LinkedList Iteratively
         * */
//        head = reverse_I(head);
//        print(head);

        /*
         * Bubble sort iteratively
         * */
        head = bubbleSort(head);
        print(head);

        /*
         * Reverse the LinkedList Recursively
         * */
//        head = reverse_R(head);
//        print(head);

        /*
         * Sort the LL in increasing order using merge sort
         * */
//        head = mergeSort(head);
//        print(head);

        /*
         * Swap two nodes of LinkedList
         * */
//        head = swap_nodes(head,1,4);
//        print(head);

        /*
         * Implement kReverse( int k ) in a linked list
         * i.e. you need to reverse first K elements
         * then reverse next k elements and join the linked list and so on.
         * */
//        head = kReverse(head, 4);
//        print(head);

        /*
         * delete every n nodes
         * */
//        head = skipMdeleteN(head, 2, 2);
//        print(head);


    }
}
