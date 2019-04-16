import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    // Input

    static BufferedInputStream in = new BufferedInputStream(System.in);

    static int readInt() {
        int no = 0;
        boolean minus = false;
        try {
            int a = in.read();
            while (a == 32 || a == 10) //10 is newline & 32 is ASCII for space
                a = in.read();
            if (a == '-') {
                minus = true;
                a = in.read();
            }
            while (a != 10 && a != 32 && a != -1) {
                no = no * 10 + (a - '0');
                a = in.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return minus ? -no : no;
    }

    static String read() {
        StringBuilder str = new StringBuilder();
        try {
            int a = in.read();
            while (a == 32)
                a = in.read();
            while (a != 10 && a != 32 && a != -1) {
                str.append((char) a);
                a = in.read();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str.toString();
    }


    // Main Method
    public static void main(String[] args) {
        //code
        int t = readInt();
        while (t-- > 0) {

        }
    }
}
