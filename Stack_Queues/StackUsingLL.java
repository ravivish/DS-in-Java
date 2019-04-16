package Stack_Queues;

public class StackUsingLL<T> {

    private Node<T> head;
    private int size;

    public StackUsingLL() {
            head = null;
            size = 0;
    }

    int size() {
        return size;
    }

    T top() throws StackEmptyException {
        if (size() == 0) {
//            StackEmptyException emptyException = new StackEmptyException();
//            throw emptyException;
            throw new StackEmptyException();
        }
        return head.data;
    }

    boolean isEmpty() {
        return (size() == 0);

    }
    void push(T elem) {

        Node<T> newNode = new Node<>(elem);
        newNode.next = head;
        head = newNode;
        size++;
    }

    T pop() throws StackEmptyException {

        if (size() == 0) {
            StackEmptyException e = new StackEmptyException();
            throw e;
        }
        size--;
        T temp = head.data;
        head = head.next;
        return temp;
    }
}
