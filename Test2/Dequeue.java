package Test2;

public class Dequeue {

    private int[] a;
    private int j, n;

    /** constructor **/
    public Dequeue()
    {
        j = 0;
        n = 0;
        resize();
    }

    /** function to check if empty **/
    public boolean isEmpty()
    {
        return n == 0;
    }

    /** function to clear array deque **/
    public void clear()
    {
        j = 0;
        n = 0;
        resize();
    }

    /** function to get number of elements **/
    public int getSize()
    {
        return n;
    }

    /** function to resize array deque **/
    private void resize()
    {
        int[] temp = new int[Math.max(2 * n, 1)];
        for (int k = 0; k < n; k++)
            temp[k] = a[(j + k) % a.length];
        a = temp;
        j = 0;
    }

    /** function to get an element array deque **/
    public int get(int i)
    {
        return a[(j + i) % a.length];
    }

    /** function to set an element **/
    public int set(int i, int x)
    {
        int y = a[(j + i) % a.length];
        a[(j + i) % a.length] = x;
        return y;
    }

    /** function to add an element **/
    void add(int i, int x)
    {
        if (n + 1 > a.length)
            resize();
        if (i < n/2)
        {
            /** shift left one position **/
            j = (j == 0) ? a.length - 1 : j - 1;

            for (int k = 0; k <= i - 1; k++)
                a[(j + k) % a.length] = a[(j + k + 1)%a.length];
        }
        else
        {
            /** shift right one position **/
            for (int k = n; k > i; k--)
                a[(j + k) % a.length] = a[(j + k - 1)%a.length];
        }
        a[(j + i) % a.length] = x;
        n++;
    }

    /** function to remove an element **/
    public int remove(int i)
    {
        int x = a[(j + i) % a.length];
        if (i < n/2)
        {
            /** shift a[0],..,[i-1] right one position **/
            for (int k = i; k > 0; k--)
                a[(j + k) % a.length] = a[(j + k - 1) % a.length];

            j = (j + 1) % a.length;
        }
        else
        {
            /** shift a[i+1],..,a[n-1] left one position **/
            for (int k = i; k < n - 1; k++)
                a[(j + k) % a.length] = a[(j + k + 1) % a.length];
        }
        n--;
        if (3 * n < a.length)
            resize();
        return x;
    }

    /** function display array deque **/
    public void display()
    {
        System.out.print("\nArray Deque : ");
        int p = j;
        for (int i = 0; i < n; i++)
        {
            System.out.print(a[p % a.length] +" ");
            p++;
        }
        System.out.println();
    }

    public static void main(String[] args) {

    }

}
