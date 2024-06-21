import java.util.ArrayList;
import java.util.Scanner;

public class getPath {
    public static ArrayList<Integer> getPath_DFS(int[][] adj, int start, int end, boolean[] visited) {
        if (start == end) {
            ArrayList<Integer> output = new ArrayList<>();
            output.add(end);
            return output;
        }

        visited[start] = true;

        for (int i = 0; i < adj[start].length; i++) {
            if (adj[start][i] == 1 && !visited[i]) {
                ArrayList<Integer> output = getPath_DFS(adj, i, end, visited);
                if (output != null) {
                    output.add(start);
                    return output;
                }
            }
        }

        return null;
    }

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Enter the no. of vertices: ");
            int n = input.nextInt();
            System.out.print("Enter the no. of edges: ");
            int e = input.nextInt();
            int[][] adjMatrix = new int[n][n];

            for (int i = 0; i < e; i++) {
                int v1 = input.nextInt();
                int v2 = input.nextInt();
                adjMatrix[v1][v2] = 1;
                adjMatrix[v2][v1] = 1;
            }

            System.out.print("Enter the start index: ");
            int start = input.nextInt();
            System.out.print("Enter the end index: ");
            int end = input.nextInt();

            boolean[] visited = new boolean[n];

            ArrayList<Integer> path = getPath_DFS(adjMatrix, start, end, visited);

            if (path != null) {
                System.out.println("Path found:");
                for (int i = path.size() - 1; i >= 0; i--) {
                    System.out.print(path.get(i) + " ");
                }
            } else {
                System.out.println("Path not found");
            }
        }
    }
}
