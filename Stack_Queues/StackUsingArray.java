package Stack_Queues;

public class StackUsingArray {

    private int data[];
    private int top;

    public StackUsingArray() {
        data = new int[10];
        top = -1;
    }

    public StackUsingArray(int capacity) {
        data = new int[capacity];
        top = -1;
    }

    public boolean isEmpty() {
//        if (top == -1)
//            return true;
//        else
//            return true;
        return (top == -1);
    }

    public int size() {
        return top + 1;
    }

    public int top() throws StackEmptyException {
        if (size() == 0) {
//            stack empty
            StackEmptyException e = new StackEmptyException();
            throw e;
        }
        top++;
        return data[top];
    }

    public void push(int elem) {
        if (size() == data.length) {
//            we can raise StackFullException here and throw it
            doubleCapacity();
        }
        top++;
        data[top] = elem;
    }

    private void doubleCapacity() {
        int temp[] = data;
        data = new int[2 * temp.length];
        for (int i = 0; i <= top; i++) {
            data[i] = temp[i];
        }
    }

    public int pop() throws StackEmptyException{
        if (size() == 0){
            StackEmptyException e=new StackEmptyException();
            throw e;
        }
        int temp = data[top];
        top--;
        return temp;
    }
}