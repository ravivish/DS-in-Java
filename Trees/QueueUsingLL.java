package Trees;


public class QueueUsingLL<T> {

    private Node<T> front;
    private Node<T> rear;
    private int size;

    public QueueUsingLL() {
        front = null;
        rear = null;
        size = 0;
    }

    int size() {
        return size;
    }

    boolean isEmpty() {
        return (size == 0);
    }

    public void enqueue(T data) {
        if (size == 0) {
            Node<T> newNode = new Node<>(data);
            front = newNode;
            rear = newNode;
            size++;
        } else {
            Node<T> temp = new Node<>(data);
            rear.next = temp;
            rear = temp;
            size++;
        }
    }

    public T dequeue() throws QueueEmptyException {
        if (size == 0) {
            throw new QueueEmptyException();
        } else {
            size--;
            T temp = front.data;
            front = front.next;
            return temp;
        }
    }

    public T front() throws QueueEmptyException {
        if (size == 0) {
            throw new QueueEmptyException();
        }
        return front.data;
    }

}
