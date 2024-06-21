import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class hasPath {
    public static boolean hasPathUtil(int[][] adjMatrix, int start, int end) {
        if (start == end) {
            return true;
        }
        Queue<Integer> queue = new LinkedList<>();
        boolean visited[] = new boolean[adjMatrix.length];
        queue.add(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (int i = 0; i < adjMatrix.length; i++) {
                if (visited[i] == false && adjMatrix[v][i] == 1) {
                    if (end == i) {
                        return true;
                    }
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Enter the no.of vertices: ");
            int n = input.nextInt();
            System.out.print("Enter the no.of edges: ");
            int e = input.nextInt();
            int[][] adjMatrix = new int[n][n];
            for (int i = 0; i < e; i++) {
                int v1 = input.nextInt();
                int v2 = input.nextInt();
                adjMatrix[v1][v2] = 1;
                adjMatrix[v2][v1] = 1;
            }
            System.out.print("Enter the start: ");
            int start = input.nextInt();
            System.out.print("Enter the end: ");
            int end = input.nextInt();
            boolean result = hasPathUtil(adjMatrix, start, end);
            System.out.println(result);

        }
    }

}
