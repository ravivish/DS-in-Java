package Test2;

public class Delete_Alternate_Node {


    static class LinkedListNode<T> {
        T data;
        LinkedListNode<T> next;

        public LinkedListNode(T data) {
            this.data = data;
        }
        public void print(LinkedListNode<Integer> head) {

            while (head != null) {
                System.out.print(head.data + " ");
                head = head.next;
            }
        }
    }

    public static void deleteAlternateNodes(LinkedListNode<Integer> head) {

        if (head == null){
            return;
        }
        LinkedListNode<Integer> prev=head;
        LinkedListNode<Integer> curr=head.next;
        while (prev != null && curr != null){

            prev.next=curr.next;
            curr=null;
            prev=prev.next;
            if (prev != null)
                curr=prev.next;
        }

    }

    public static void main(String[] args) {

        LinkedListNode<Integer> node1 = new LinkedListNode<>(10);
        LinkedListNode<Integer> node2 = new LinkedListNode<>(20);
        LinkedListNode<Integer> node3 = new LinkedListNode<>(30);
        LinkedListNode<Integer> node4 = new LinkedListNode<>(40);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        LinkedListNode<Integer> head = node1;
        deleteAlternateNodes(head);

    }

}
