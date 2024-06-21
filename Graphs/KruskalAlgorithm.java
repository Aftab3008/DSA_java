//Union Find Algorithm
import java.util.Arrays;
import java.util.Scanner;

class Edge implements Comparable<Edge> {
    int v1;
    int v2;
    int weight;

    Edge(int v1, int v2, int weight) {
        this.v1 = v1;
        this.v2 = v2;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return this.weight - o.weight;
    }
}
public class KruskalAlgorithm {
     public static int findParent(int v, int[] parent) {
        if (parent[v] == v) {
            return v;
        }
        return findParent(parent[v], parent);
    }

    public static Edge[] kruskal(Edge[] edges, int n) {
        Arrays.sort(edges);
        Edge[] mst = new Edge[n - 1];
        int[] parent = new int[n];
        int count = 0, i = 0;
        for (int j = 0; j < n; j++) {
            parent[j] = j;
        }
        while (count != n - 1) {
            Edge currentEdge = edges[i++];
            int v1Parent = findParent(currentEdge.v1, parent);
            int v2Parent = findParent(currentEdge.v2, parent);
            if (v1Parent != v2Parent) {
                mst[count++] = currentEdge;
                parent[v1Parent] = v2Parent;
            }
        }
        return mst;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int e = input.nextInt();
        Edge[] edges = new Edge[e];
        for (int i = 0; i < e; i++) {
            int v1 = input.nextInt();
            int v2 = input.nextInt();
            int weight = input.nextInt();
            edges[i] = new Edge(v1, v2, weight);
        }
        Edge[] mst = kruskal(edges, n);
        System.out.println("Minimum Spanning Tree: ");
        int totalWeight = 0;
        for (int i = 0; i < mst.length; i++) {
            System.out.println(mst[i].v1 + " " + mst[i].v2 );
            totalWeight += mst[i].weight;
        }
        System.out.println("Total Weight: " + totalWeight);
    }
}
