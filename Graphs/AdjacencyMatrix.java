import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class AdjacencyMatrix {
    public static void dftraversal(int adjMatrix[][], int currentVertex, boolean[] visited) {
        visited[currentVertex] = true;
        System.out.print(currentVertex + " ");
        for (int i = 0; i < adjMatrix.length; i++) {
            if (visited[i] == false && adjMatrix[currentVertex][i] == 1) {
                dftraversal(adjMatrix, i, visited);
            }
        }
    }

    public static void dfTraversal(int adjMatrix[][]) {
        boolean visited[] = new boolean[adjMatrix.length];
        for (int v = 0; v < adjMatrix.length; v++) {
            if (!visited[v]) {
                dftraversal(adjMatrix, v, visited);
                System.out.println();
            }
        }
    }

    public static void bfTraversal(int[][] adjMatrix) {
        Queue<Integer> queue = new LinkedList<>();
        boolean visited[] = new boolean[adjMatrix.length];
        for (int j = 0; j < visited.length; j++) {
            if (visited[j] == false) {
                queue.add(j);
                visited[j] = true;
                while (!queue.isEmpty()) {
                    int v = queue.poll();
                    System.out.print(v + " ");
                    for (int i = 0; i < adjMatrix.length; i++) {
                        if (visited[i] == false && adjMatrix[v][i] == 1) {
                            queue.add(i);
                            visited[i] = true;
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Enter the no.of rows: ");
            int n = input.nextInt();
            System.out.print("Enter the no.of columns: ");
            int e = input.nextInt();
            int[][] adjMatrix = new int[n][n];
            for (int i = 0; i < e; i++) {
                int v1 = input.nextInt();
                int v2 = input.nextInt();
                adjMatrix[v1][v2] = 1;
                adjMatrix[v2][v1] = 1;
            }
            dfTraversal(adjMatrix);
            System.out.println();
            bfTraversal(adjMatrix);
            // for (int i = 0; i < n; i++) {
            // for (int j = 0; j < n; j++) {
            // System.out.print(adjMatrix[i][j] + " ");
            // }
            // System.out.println();
            // }
        }
    }
}