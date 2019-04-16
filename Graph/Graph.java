package Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Graph {

    private static void printBFSHelper(int[][] edge, int sv, boolean[] visited) {

        Queue<Integer> q=new LinkedList<>() ;
        q.add(sv);
        int n=edge.length;
        visited[sv]=true;
        while (!q.isEmpty()){
            int front;
            front=q.remove();
            System.out.print(front+" ");
            for (int i=0;i<n;i++){
                if (edge[front][i]==1 && !visited[i]){
                    q.add(i);
                    visited[i]=true;
                }
            }
        }
    }

    public static void printBFS(int[][] edge) {
        boolean visited[]=new boolean[edge.length];
        for (int i=0;i<edge.length;i++){
            if (!visited[i]){
                printBFSHelper(edge,i,visited);
            }
        }

    }


    private static void printDFSHelper(int[][] edge, int sv, boolean[] visited) {

        System.out.print(sv+" ");             //It is DFS traversal
        visited[sv] = true;
        int n = edge.length;
        for (int i = 0; i < n; i++) {
            if (edge[sv][i] == 1 & !visited[i]) {
                printDFSHelper(edge, i, visited);
            }
        }
    }

    private static void printDFS(int[][] edge) {

        boolean visited[] = new boolean[edge.length];
        for (int i = 0; i < edge.length; i++) { //This loop is for unconnected component of graph and we are calling on only
            if (!visited[i]) {                  // vertex array(boolean) which are not visited yet
                printDFSHelper(edge, i, visited);
            }
        }

    }


    public static void main(String[] args) {

        int n;
        int e;
        Scanner s = new Scanner(System.in);
        System.out.println("Enter no. of vertex : ");
        n = s.nextInt();
        System.out.println("Enter no. of edges : ");
        e = s.nextInt();
        int edge[][] = new int[n][n];
        for (int i = 0; i < e; i++) {
            int fv = s.nextInt();
            int sv = s.nextInt();
            edge[fv][sv] = 1;
            edge[sv][fv] = 1;
        }
        System.out.println("DFS");
        printDFS(edge);
        System.out.println("\nBFS");
        printBFS(edge);
    }


}
